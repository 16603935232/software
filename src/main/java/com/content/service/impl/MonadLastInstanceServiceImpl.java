package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.MonadLastInstance;
import com.content.vo.MonadLastInstanceVO;
import com.content.mapper.MonadLastInstanceMapper;
import com.content.service.IMonadLastInstanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【终审报告单】实现层
 *
 * @author sml
 * @date 2023-08-08
 */
@Slf4j
@Service
public class MonadLastInstanceServiceImpl extends ServiceImpl<MonadLastInstanceMapper, MonadLastInstance> implements IMonadLastInstanceService {
}
