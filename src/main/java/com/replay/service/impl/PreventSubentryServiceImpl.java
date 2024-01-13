package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.PreventSubentry;
import com.replay.vo.PreventSubentryVO;
import com.replay.mapper.PreventSubentryMapper;
import com.replay.service.IPreventSubentryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【应对措施分项信息表】实现层
 *
 * @author shangml
 * @date 2023-04-25
 */
@Slf4j
@Service
public class PreventSubentryServiceImpl extends ServiceImpl<PreventSubentryMapper, PreventSubentry> implements IPreventSubentryService {
}
