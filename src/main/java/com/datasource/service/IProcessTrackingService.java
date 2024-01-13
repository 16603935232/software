package com.datasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.datasource.entity.ProcessTracking;
import com.baomidou.mybatisplus.extension.service.IService;
import com.datasource.vo.ProcessTrackingVO;
import com.datasource.dto.ProcessTrackingDTO;
import java.util.List;

/**
 * 【过程跟踪表】代理层
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
public interface IProcessTrackingService extends IService<ProcessTracking> {
}
