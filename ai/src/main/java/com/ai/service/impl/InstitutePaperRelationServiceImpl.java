package com.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ai.entity.InstitutePaperRelation;
import com.ai.vo.InstitutePaperRelationVO;
import com.ai.mapper.InstitutePaperRelationMapper;
import com.ai.service.IInstitutePaperRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ai.excel.InstitutePaperRelationExcelDTO;
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
 * 【】实现层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Service
public class InstitutePaperRelationServiceImpl extends ServiceImpl<InstitutePaperRelationMapper, InstitutePaperRelation> implements IInstitutePaperRelationService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean importExcel(MultipartFile file){
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            ImportParams importParams = new ImportParams();
            for (int i = 0; i < reader.getSheetCount(); i++) {
                //设置读取第几个sheet页
                importParams.setStartSheetIndex(i);
                List<InstitutePaperRelationExcelDTO> result = ExcelImportUtil.importExcel(file.getInputStream(), InstitutePaperRelationExcelDTO.class, importParams);
                List<InstitutePaperRelation> excelList = result.stream().map(excelDTO -> {
                    InstitutePaperRelation entity = new InstitutePaperRelation();
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
    public List<InstitutePaperRelationExcelDTO> downloadExcel(List<Long> ids){
        List<InstitutePaperRelation> list;
        if (ids.size()>0){
            list = this.listByIds(ids);
        }else {
            list =this.list();
        }
        List<InstitutePaperRelationExcelDTO> excelList = list.stream().map(excel -> {
            InstitutePaperRelationExcelDTO excelDto = new InstitutePaperRelationExcelDTO();
            BeanUtils.copyProperties(excel, excelDto);
            return excelDto;
        }).collect(Collectors.toList());
        return excelList;
    }
}
