package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.ObservIndicatorsSubentryPublish;
import com.replay.vo.ObservIndicatorsSubentryPublishVO;
import com.replay.mapper.ObservIndicatorsSubentryPublishMapper;
import com.replay.service.IObservIndicatorsSubentryPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【观测分项指标发布表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class ObservIndicatorsSubentryPublishServiceImpl extends ServiceImpl<ObservIndicatorsSubentryPublishMapper, ObservIndicatorsSubentryPublish> implements IObservIndicatorsSubentryPublishService {
}
