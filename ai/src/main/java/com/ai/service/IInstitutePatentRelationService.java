package com.ai.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ai.entity.InstitutePatentRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ai.vo.InstitutePatentRelationVO;
import com.ai.dto.InstitutePatentRelationDTO;
import org.springframework.web.multipart.MultipartFile;
import com.ai.excel.InstitutePatentRelationExcelDTO;
import java.util.List;

/**
 * 【研究机构专利关联表】代理层
 *
 * @author sml
 * @date 2023-10-16
 */
public interface IInstitutePatentRelationService extends IService<InstitutePatentRelation> {
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
    List<InstitutePatentRelationExcelDTO> downloadExcel(List<Long> ids);
}
