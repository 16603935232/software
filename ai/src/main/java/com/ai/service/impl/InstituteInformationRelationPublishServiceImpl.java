package com.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ai.entity.InstituteInformationRelationPublish;
import com.ai.vo.InstituteInformationRelationPublishVO;
import com.ai.mapper.InstituteInformationRelationPublishMapper;
import com.ai.service.IInstituteInformationRelationPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ai.excel.InstituteInformationRelationPublishExcelDTO;
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
 * 【研究机构资讯关联表】实现层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Service
public class InstituteInformationRelationPublishServiceImpl extends ServiceImpl<InstituteInformationRelationPublishMapper, InstituteInformationRelationPublish> implements IInstituteInformationRelationPublishService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean importExcel(MultipartFile file){
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            ImportParams importParams = new ImportParams();
            for (int i = 0; i < reader.getSheetCount(); i++) {
                //设置读取第几个sheet页
                importParams.setStartSheetIndex(i);
                List<InstituteInformationRelationPublishExcelDTO> result = ExcelImportUtil.importExcel(file.getInputStream(), InstituteInformationRelationPublishExcelDTO.class, importParams);
                List<InstituteInformationRelationPublish> excelList = result.stream().map(excelDTO -> {
                    InstituteInformationRelationPublish entity = new InstituteInformationRelationPublish();
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
    public List<InstituteInformationRelationPublishExcelDTO> downloadExcel(List<Long> ids){
        List<InstituteInformationRelationPublish> list;
        if (ids.size()>0){
            list = this.listByIds(ids);
        }else {
            list =this.list();
        }
        List<InstituteInformationRelationPublishExcelDTO> excelList = list.stream().map(excel -> {
            InstituteInformationRelationPublishExcelDTO excelDto = new InstituteInformationRelationPublishExcelDTO();
            BeanUtils.copyProperties(excel, excelDto);
            return excelDto;
        }).collect(Collectors.toList());
        return excelList;
    }
}
