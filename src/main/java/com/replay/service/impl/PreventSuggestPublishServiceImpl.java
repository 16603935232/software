package com.replay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.replay.entity.PreventSuggestPublish;
import com.replay.vo.PreventSuggestPublishVO;
import com.replay.mapper.PreventSuggestPublishMapper;
import com.replay.service.IPreventSuggestPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预防专家建议发布表】实现层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Service
public class PreventSuggestPublishServiceImpl extends ServiceImpl<PreventSuggestPublishMapper, PreventSuggestPublish> implements IPreventSuggestPublishService {
}
