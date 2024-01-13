package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.ObservInformationPublish;
import com.replay.vo.ObservInformationPublishVO;
import com.replay.mapper.ObservInformationPublishMapper;
import com.replay.service.IObservInformationPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【观测信息发布表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class ObservInformationPublishServiceImpl extends ServiceImpl<ObservInformationPublishMapper, ObservInformationPublish> implements IObservInformationPublishService {
}
