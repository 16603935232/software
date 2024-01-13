package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.PredictIndicatorsFeaturePublish;
import com.replay.vo.PredictIndicatorsFeaturePublishVO;
import com.replay.mapper.PredictIndicatorsFeaturePublishMapper;
import com.replay.service.IPredictIndicatorsFeaturePublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预测特征、难题发布表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class PredictIndicatorsFeaturePublishServiceImpl extends ServiceImpl<PredictIndicatorsFeaturePublishMapper, PredictIndicatorsFeaturePublish> implements IPredictIndicatorsFeaturePublishService {
}
