package com.redevelop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redevelop.entity.WarningIndicators;
import com.redevelop.vo.WarningIndicatorsVO;
import com.redevelop.mapper.WarningIndicatorsMapper;
import com.redevelop.service.IWarningIndicatorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预警指标体系表】实现层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Service
public class WarningIndicatorsServiceImpl extends ServiceImpl<WarningIndicatorsMapper, WarningIndicators> implements IWarningIndicatorsService {
}
