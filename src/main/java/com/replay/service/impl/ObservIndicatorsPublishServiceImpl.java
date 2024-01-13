package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.ObservIndicatorsPublish;
import com.replay.vo.ObservIndicatorsPublishVO;
import com.replay.mapper.ObservIndicatorsPublishMapper;
import com.replay.service.IObservIndicatorsPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【观测指标体系发布表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class ObservIndicatorsPublishServiceImpl extends ServiceImpl<ObservIndicatorsPublishMapper, ObservIndicatorsPublish> implements IObservIndicatorsPublishService {
}
