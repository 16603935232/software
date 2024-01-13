package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.ProcessTracking;
import com.datasource.vo.ProcessTrackingVO;
import com.datasource.mapper.ProcessTrackingMapper;
import com.datasource.service.IProcessTrackingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【过程跟踪表】实现层
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
@Slf4j
@Service
public class ProcessTrackingServiceImpl extends ServiceImpl<ProcessTrackingMapper, ProcessTracking> implements IProcessTrackingService {
}
