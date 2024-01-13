package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.LoopSummaryPublish;
import com.replay.vo.LoopSummaryPublishVO;
import com.replay.mapper.LoopSummaryPublishMapper;
import com.replay.service.ILoopSummaryPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【环路量化总结发布表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class LoopSummaryPublishServiceImpl extends ServiceImpl<LoopSummaryPublishMapper, LoopSummaryPublish> implements ILoopSummaryPublishService {
}
