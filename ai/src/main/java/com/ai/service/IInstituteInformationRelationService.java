package com.ai.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ai.entity.InstituteInformationRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ai.vo.InstituteInformationRelationVO;
import com.ai.dto.InstituteInformationRelationDTO;
import org.springframework.web.multipart.MultipartFile;
import com.ai.excel.InstituteInformationRelationExcelDTO;
import java.util.List;

/**
 * 【研究机构资讯关联表】代理层
 *
 * @author sml
 * @date 2023-10-16
 */
public interface IInstituteInformationRelationService extends IService<InstituteInformationRelation> {
    /**
    * 导入Excel
    *
    * @param file 文件
    * @return 是否
    */
    Boolean importExcel(MultipartFile file);
    /**
    * 导出Excel
    *
    * @param ids ID列表
    * @return 对象列表
    */
    List<InstituteInformationRelationExcelDTO> downloadExcel(List<Long> ids);
}
