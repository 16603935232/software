package com.redevelop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redevelop.entity.WarningSubentryPublish;
import com.redevelop.vo.WarningSubentryPublishVO;
import com.redevelop.mapper.WarningSubentryPublishMapper;
import com.redevelop.service.IWarningSubentryPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预警分项指标发布表】实现层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Service
public class WarningSubentryPublishServiceImpl extends ServiceImpl<WarningSubentryPublishMapper, WarningSubentryPublish> implements IWarningSubentryPublishService {
}
