package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.PredictIndicatorsPublish;
import com.replay.vo.PredictIndicatorsPublishVO;
import com.replay.mapper.PredictIndicatorsPublishMapper;
import com.replay.service.IPredictIndicatorsPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预测指标体系表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class PredictIndicatorsPublishServiceImpl extends ServiceImpl<PredictIndicatorsPublishMapper, PredictIndicatorsPublish> implements IPredictIndicatorsPublishService {
}
