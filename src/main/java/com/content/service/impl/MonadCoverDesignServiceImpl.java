package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.MonadCoverDesign;
import com.content.vo.MonadCoverDesignVO;
import com.content.mapper.MonadCoverDesignMapper;
import com.content.service.IMonadCoverDesignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【封面设计通知单】实现层
 *
 * @author sml
 * @date 2023-08-03
 */
@Slf4j
@Service
public class MonadCoverDesignServiceImpl extends ServiceImpl<MonadCoverDesignMapper, MonadCoverDesign> implements IMonadCoverDesignService {
}
