package com.replay_collection.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay_collection.entity.MonitoringSource;
import com.replay_collection.vo.MonitoringSourceVO;
import com.replay_collection.mapper.MonitoringSourceMapper;
import com.replay_collection.service.IMonitoringSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【监测源】实现层
 *
 * @author sml
 * @date 2023-03-23
 */
@Slf4j
@Service
public class MonitoringSourceServiceImpl extends ServiceImpl<MonitoringSourceMapper, MonitoringSource> implements IMonitoringSourceService {
}
