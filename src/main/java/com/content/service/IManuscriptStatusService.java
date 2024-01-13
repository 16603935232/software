package com.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.content.entity.ManuscriptStatus;
import com.baomidou.mybatisplus.extension.service.IService;
import com.content.vo.ManuscriptStatusVO;
import com.content.dto.ManuscriptStatusDTO;
import java.util.List;

/**
 * 【稿件状态表】代理层
 *
 * @author sml
 * @date 2023-07-28
 */
public interface IManuscriptStatusService extends IService<ManuscriptStatus> {
}
