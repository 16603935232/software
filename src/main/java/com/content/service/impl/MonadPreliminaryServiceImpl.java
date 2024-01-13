package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.MonadPreliminary;
import com.content.vo.MonadPreliminaryVO;
import com.content.mapper.MonadPreliminaryMapper;
import com.content.service.IMonadPreliminaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【初审/复审/终审报告单】实现层
 *
 * @author sml
 * @date 2023-08-01
 */
@Slf4j
@Service
public class MonadPreliminaryServiceImpl extends ServiceImpl<MonadPreliminaryMapper, MonadPreliminary> implements IMonadPreliminaryService {
}
