package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.PreventInformationPublish;
import com.replay.vo.PreventInformationPublishVO;
import com.replay.mapper.PreventInformationPublishMapper;
import com.replay.service.IPreventInformationPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预防信息发布表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class PreventInformationPublishServiceImpl extends ServiceImpl<PreventInformationPublishMapper, PreventInformationPublish> implements IPreventInformationPublishService {
}
