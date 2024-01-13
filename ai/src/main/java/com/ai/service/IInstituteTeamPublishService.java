package com.ai.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ai.entity.InstituteTeamPublish;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ai.vo.InstituteTeamPublishVO;
import com.ai.dto.InstituteTeamPublishDTO;
import org.springframework.web.multipart.MultipartFile;
import com.ai.excel.InstituteTeamPublishExcelDTO;
import java.util.List;

/**
 * 【研究机构-团队发布表】代理层
 *
 * @author sml
 * @date 2023-10-18
 */
public interface IInstituteTeamPublishService extends IService<InstituteTeamPublish> {
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
    List<InstituteTeamPublishExcelDTO> downloadExcel(List<Long> ids);
}
