package com.redevelop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redevelop.entity.WarningSubentry;
import com.redevelop.vo.WarningSubentryVO;
import com.redevelop.mapper.WarningSubentryMapper;
import com.redevelop.service.IWarningSubentryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预警分项指标表】实现层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Service
public class WarningSubentryServiceImpl extends ServiceImpl<WarningSubentryMapper, WarningSubentry> implements IWarningSubentryService {
}
