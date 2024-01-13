package com.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ai.entity.InstituteTeamPublish;
import com.ai.vo.InstituteTeamPublishVO;
import com.ai.mapper.InstituteTeamPublishMapper;
import com.ai.service.IInstituteTeamPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ai.excel.InstituteTeamPublishExcelDTO;
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
 * 【研究机构-团队发布表】实现层
 *
 * @author sml
 * @date 2023-10-18
 */
@Slf4j
@Service
public class InstituteTeamPublishServiceImpl extends ServiceImpl<InstituteTeamPublishMapper, InstituteTeamPublish> implements IInstituteTeamPublishService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean importExcel(MultipartFile file){
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            ImportParams importParams = new ImportParams();
            for (int i = 0; i < reader.getSheetCount(); i++) {
                //设置读取第几个sheet页
                importParams.setStartSheetIndex(i);
                List<InstituteTeamPublishExcelDTO> result = ExcelImportUtil.importExcel(file.getInputStream(), InstituteTeamPublishExcelDTO.class, importParams);
                List<InstituteTeamPublish> excelList = result.stream().map(excelDTO -> {
                    InstituteTeamPublish entity = new InstituteTeamPublish();
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
    public List<InstituteTeamPublishExcelDTO> downloadExcel(List<Long> ids){
        List<InstituteTeamPublish> list;
        if (ids.size()>0){
            list = this.listByIds(ids);
        }else {
            list =this.list();
        }
        List<InstituteTeamPublishExcelDTO> excelList = list.stream().map(excel -> {
            InstituteTeamPublishExcelDTO excelDto = new InstituteTeamPublishExcelDTO();
            BeanUtils.copyProperties(excel, excelDto);
            return excelDto;
        }).collect(Collectors.toList());
        return excelList;
    }
}
