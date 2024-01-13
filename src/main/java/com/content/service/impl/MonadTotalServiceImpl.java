package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.MonadTotal;
import com.content.vo.MonadTotalVO;
import com.content.mapper.MonadTotalMapper;
import com.content.service.IMonadTotalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【单据总表】实现层
 *
 * @author sml
 * @date 2023-07-31
 */
@Slf4j
@Service
public class MonadTotalServiceImpl extends ServiceImpl<MonadTotalMapper, MonadTotal> implements IMonadTotalService {
}
