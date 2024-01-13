package com.ai.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ai.entity.InstitutePaperRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ai.vo.InstitutePaperRelationVO;
import com.ai.dto.InstitutePaperRelationDTO;
import org.springframework.web.multipart.MultipartFile;
import com.ai.excel.InstitutePaperRelationExcelDTO;
import java.util.List;

/**
 * 【】代理层
 *
 * @author sml
 * @date 2023-10-16
 */
public interface IInstitutePaperRelationService extends IService<InstitutePaperRelation> {
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
    List<InstitutePaperRelationExcelDTO> downloadExcel(List<Long> ids);
}
