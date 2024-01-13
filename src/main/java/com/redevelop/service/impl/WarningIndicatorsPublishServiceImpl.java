package com.redevelop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redevelop.entity.WarningIndicatorsPublish;
import com.redevelop.vo.WarningIndicatorsPublishVO;
import com.redevelop.mapper.WarningIndicatorsPublishMapper;
import com.redevelop.service.IWarningIndicatorsPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预警指标体系发布表】实现层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Service
public class WarningIndicatorsPublishServiceImpl extends ServiceImpl<WarningIndicatorsPublishMapper, WarningIndicatorsPublish> implements IWarningIndicatorsPublishService {
}
