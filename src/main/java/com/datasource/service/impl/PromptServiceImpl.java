package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.Prompt;
import com.datasource.vo.PromptVO;
import com.datasource.mapper.PromptMapper;
import com.datasource.service.IPromptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【不再提示表】实现层
 *
 * @author shangml
 * @date 2023-01-31
 */
@Slf4j
@Service
public class PromptServiceImpl extends ServiceImpl<PromptMapper, Prompt> implements IPromptService {
}
