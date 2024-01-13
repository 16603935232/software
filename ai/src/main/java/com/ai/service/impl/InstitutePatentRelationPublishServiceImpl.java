package com.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ai.entity.InstitutePatentRelationPublish;
import com.ai.vo.InstitutePatentRelationPublishVO;
import com.ai.mapper.InstitutePatentRelationPublishMapper;
import com.ai.service.IInstitutePatentRelationPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ai.excel.InstitutePatentRelationPublishExcelDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import java.util.List;
import java.util.stream.Collectors;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * 【研究机构专利关联表】实现层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Service
public class InstitutePatentRelationPublishServiceImpl extends ServiceImpl<InstitutePatentRelationPublishMapper, InstitutePatentRelationPublish> implements IInstitutePatentRelationPublishService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean importExcel(MultipartFile file){
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            ImportParams importParams = new ImportParams();
            for (int i = 0; i < reader.getSheetCount(); i++) {
                //设置读取第几个sheet页
                importParams.setStartSheetIndex(i);
                List<InstitutePatentRelationPublishExcelDTO> result = ExcelImportUtil.importExcel(file.getInputStream(), InstitutePatentRelationPublishExcelDTO.class, importParams);
                List<InstitutePatentRelationPublish> excelList = result.stream().map(excelDTO -> {
                    InstitutePatentRelationPublish entity = new InstitutePatentRelationPublish();
                    BeanUtils.copyProperties(excelDTO, entity);
                    return entity;
                }).collect(Collectors.toList());
                this.saveBatch(excelList);
                }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<InstitutePatentRelationPublishExcelDTO> downloadExcel(List<Long> ids){
        List<InstitutePatentRelationPublish> list;
        if (ids.size()>0){
            list = this.listByIds(ids);
        }else {
            list =this.list();
        }
        List<InstitutePatentRelationPublishExcelDTO> excelList = list.stream().map(excel -> {
            InstitutePatentRelationPublishExcelDTO excelDto = new InstitutePatentRelationPublishExcelDTO();
            BeanUtils.copyProperties(excel, excelDto);
            return excelDto;
        }).collect(Collectors.toList());
        return excelList;
    }
}
