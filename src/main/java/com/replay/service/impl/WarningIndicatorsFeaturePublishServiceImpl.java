package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.WarningIndicatorsFeaturePublish;
import com.replay.vo.WarningIndicatorsFeaturePublishVO;
import com.replay.mapper.WarningIndicatorsFeaturePublishMapper;
import com.replay.service.IWarningIndicatorsFeaturePublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预警差距、威胁发布表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class WarningIndicatorsFeaturePublishServiceImpl extends ServiceImpl<WarningIndicatorsFeaturePublishMapper, WarningIndicatorsFeaturePublish> implements IWarningIndicatorsFeaturePublishService {
}
