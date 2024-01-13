package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.WarningInformationPublish;
import com.replay.vo.WarningInformationPublishVO;
import com.replay.mapper.WarningInformationPublishMapper;
import com.replay.service.IWarningInformationPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预警信息发布表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class WarningInformationPublishServiceImpl extends ServiceImpl<WarningInformationPublishMapper, WarningInformationPublish> implements IWarningInformationPublishService {
}
