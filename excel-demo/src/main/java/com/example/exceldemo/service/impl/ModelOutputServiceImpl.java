package com.example.exceldemo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exceldemo.dto.InputDTO;
import com.example.exceldemo.entity.ModelOutput;
import com.example.exceldemo.entity.NewInput;
import com.example.exceldemo.entity.StockInput;
import com.example.exceldemo.excption.MsgException;
import com.example.exceldemo.mapper.ModelOutputMapper;
import com.example.exceldemo.result.Result;
import com.example.exceldemo.service.IModelOutputService;
import com.example.exceldemo.service.INewInputService;
import com.example.exceldemo.service.IStockInputService;
import com.example.exceldemo.util.IdUtils;
import com.example.exceldemo.vo.OutputVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 【模型输出表】实现层
 *
 * @author shangml
 * @date 2023-01-15
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ModelOutputServiceImpl extends ServiceImpl<ModelOutputMapper, ModelOutput> implements IModelOutputService {

    private final INewInputService newInputService;

    private final IStockInputService stockInputService;

    @Override
    public Result<OutputVO> call(@Validated InputDTO dto) throws IOException {

        // 定义返回对象
        OutputVO outputVO = new OutputVO();

        List<NewInput> newInputList = dto.getNewInputList();
        List<StockInput> stockInputList = dto.getStockInputList();
        String filePath = this.getClass().getResource(File.separator + "/excel/").getPath() + File.separator+ "园区产业发展与能源预测.xlsx";
        filePath = filePath.replace("/", File.separator);
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook wb=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheetNew = wb.getSheetAt(0);
        XSSFSheet sheetStock = wb.getSheetAt(1);
        AtomicInteger sheetNewStartRow = new AtomicInteger(2);
        newInputList.forEach(l -> {
            if (l.getDeveloped() == null){
                l.setDeveloped(l.getIndustryType().equals(0) ? 1 : 0);
            }
            l.setYear(l.getScheduledTime().getYear());
            l.setDeveloped(l.getDeveloped());
            l.setYear(l.getYear());
        });
        newInputList.forEach(l ->{
            getCell(sheetNew, sheetNewStartRow, 0).setCellValue(l.getProductName());
            getCell(sheetNew, sheetNewStartRow, 1).setCellValue(l.getProductCode());
            getCell(sheetNew, sheetNewStartRow, 2).setCellValue(l.getDeveloped());
            getCell(sheetNew, sheetNewStartRow, 3).setCellValue(l.getYear());
            getCell(sheetNew, sheetNewStartRow, 4).setCellValue(l.getYield().toPlainString());
            getCell(sheetNew, sheetNewStartRow, 5).setCellValue(l.getYieldUnit());
            getCell(sheetNew, sheetNewStartRow, 6).setCellValue(l.getEfficiency());
            sheetNewStartRow.getAndIncrement();
        });
        AtomicInteger sheetNewStockRow = new AtomicInteger(2);
        stockInputList.forEach(l ->{
            getCell(sheetStock, sheetNewStockRow, 0).setCellValue(l.getEnterpriseName());
            getCell(sheetStock, sheetNewStockRow, 1).setCellValue(l.getEnterpriseCode());
            getCell(sheetStock, sheetNewStockRow, 2).setCellValue(l.getProductName());
            getCell(sheetStock, sheetNewStockRow, 3).setCellValue(l.getProductCode());
            getCell(sheetStock, sheetNewStockRow, 4).setCellValue(l.getYield().toPlainString());
            getCell(sheetStock, sheetNewStockRow, 5).setCellValue(l.getYieldUnit());
            getCell(sheetStock, sheetNewStockRow, 6).setCellValue(l.getEfficiency());
            sheetNewStockRow.getAndIncrement();
        });

        // 设置打开excel刷新公式
        wb.setForceFormulaRecalculation(true);
        // 强制在数据流中刷新公式及数据
        XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);

        // 读取输出数据
        XSSFSheet sheetOutput = wb.getSheetAt(2);
        List<ModelOutput> modelOutputList = new ArrayList<>();
        for (int i= 2; i < 9; i+=3){
            for (int j = 2; j < 13 ; j++) {
                ModelOutput output = new ModelOutput();
                String dataType = new DataFormatter().formatCellValue(getCell(sheetOutput, new AtomicInteger(i), 0));
                String year = new DataFormatter().formatCellValue(getCell(sheetOutput, new AtomicInteger(1), j));
                String newValue = NumberToTextConverter.toText(getCell(sheetOutput, new AtomicInteger(i), j).getNumericCellValue());
                String stockValue = NumberToTextConverter.toText(getCell(sheetOutput, new AtomicInteger(i + 1), j).getNumericCellValue());
                String actualValue = NumberToTextConverter.toText(getCell(sheetOutput, new AtomicInteger(i + 2), j).getNumericCellValue());
                String gdpRate = NumberToTextConverter.toText(getCell(sheetOutput, new AtomicInteger(2), 16).getNumericCellValue());
                String estimatedEnergyConsumption = NumberToTextConverter.toText(getCell(sheetOutput, new AtomicInteger(2), 17).getNumericCellValue());
                String projectedCarbonEmissions = NumberToTextConverter.toText(getCell(sheetOutput, new AtomicInteger(2), 18).getNumericCellValue());
                   if (dataType.equals("能耗量")){
                    output.setDataType(0);
                }
                if (dataType.equals("产值")){
                    output.setDataType(1);
                }
                if (dataType.equals("增加值")){
                    output.setDataType(2);
                }
                output.setDataTime(LocalDate.of(Integer.valueOf(year), Month.JANUARY, 1));
                output.setNewValue(new BigDecimal(newValue).setScale(4, BigDecimal.ROUND_HALF_UP));
                output.setStockValue(new BigDecimal(stockValue).setScale(4, BigDecimal.ROUND_HALF_UP));
                output.setActualValue(new BigDecimal(actualValue).setScale(4, BigDecimal.ROUND_HALF_UP));
                output.setGdpRate(new BigDecimal(gdpRate).setScale(4, BigDecimal.ROUND_HALF_UP));
                output.setEstimatedEnergyConsumption(new BigDecimal(estimatedEnergyConsumption).setScale(4, BigDecimal.ROUND_HALF_UP));
                output.setProjectedCarbonEmissions(new BigDecimal(projectedCarbonEmissions).setScale(4, BigDecimal.ROUND_HALF_UP));
                modelOutputList.add(output);
            }
        }

        fileInputStream.close();
        outputVO.setModelOutputList(modelOutputList);
        outputVO.setNewInputList(newInputList);
        outputVO.setStockInputList(stockInputList);

        return Result.ok(outputVO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean savePlan(OutputVO vo) {
        Long planCode = IdUtils.getId();
        vo.getModelOutputList().forEach(l ->{
            l.setPlanCode(planCode);
            l.setAreaName(vo.getAreaName());
            l.setAreaCode(vo.getAreaCode());
            l.setPlanName(vo.getPlanName());
        });
        vo.getNewInputList().forEach(l -> l.setPlanCode(planCode));
        vo.getStockInputList().forEach(l -> l.setPlanCode(planCode));

        this.saveBatch(vo.getModelOutputList());
        newInputService.saveBatch(vo.getNewInputList());
        stockInputService.saveBatch(vo.getStockInputList());
        return true;
    }

    @Override
    public OutputVO selectPlan(ModelOutput modelOutput) {
        OutputVO outputVO = new OutputVO();
        outputVO.setModelOutputList(this.list(Wrappers.lambdaQuery(modelOutput)));
        if (CollectionUtils.isEmpty(outputVO.getModelOutputList())){
            throw new MsgException("该方案不存在");
        }
        outputVO.setStockInputList(stockInputService.list(Wrappers.<StockInput>lambdaQuery()
                .eq(StockInput::getPlanCode, list().get(0).getPlanCode())));
        outputVO.setNewInputList(newInputService.list(Wrappers.<NewInput>lambdaQuery()
                .eq(NewInput::getPlanCode, list().get(0).getPlanCode())));
        return outputVO;
    }

    public XSSFCell getCell(XSSFSheet sheet, AtomicInteger row, Integer cellNum){

        XSSFRow xssfRow = null;

        XSSFCell xssfCell = null;

        if (sheet.getRow(row.get()) == null){
            xssfRow = sheet.createRow(row.get());
        } else {
            xssfRow = sheet.getRow(row.get());
        }

        if (xssfRow.getCell(cellNum) == null){
             xssfCell = xssfRow.createCell(cellNum);
        } else {
            xssfCell = xssfRow.getCell(cellNum);
        }
        return xssfCell;
    }

    public static void test(XSSFWorkbook wb) throws IOException {
        FileOutputStream fileOut =null;
        try {
            //获取本的桌面路径
            FileSystemView fsv = FileSystemView.getFileSystemView();
            fileOut = new FileOutputStream("D://test/test.xlsx");
            // 写入excel文件
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException io) {
            io.printStackTrace();
            System.out.println("io erorr : " + io.getMessage());
        } finally {
            if (fileOut != null) {
                try {
                    fileOut.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
