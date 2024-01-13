package com.ai.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ai.entity.InstitutePaperRelationPublish;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ai.vo.InstitutePaperRelationPublishVO;
import com.ai.dto.InstitutePaperRelationPublishDTO;
import org.springframework.web.multipart.MultipartFile;
import com.ai.excel.InstitutePaperRelationPublishExcelDTO;
import java.util.List;

/**
 * 【】代理层
 *
 * @author sml
 * @date 2023-10-16
 */
public interface IInstitutePaperRelationPublishService extends IService<InstitutePaperRelationPublish> {
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
    List<InstitutePaperRelationPublishExcelDTO> downloadExcel(List<Long> ids);
}
