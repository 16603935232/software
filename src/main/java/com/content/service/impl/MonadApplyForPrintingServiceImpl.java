package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.MonadApplyForPrinting;
import com.content.vo.MonadApplyForPrintingVO;
import com.content.mapper.MonadApplyForPrintingMapper;
import com.content.service.IMonadApplyForPrintingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【申请开印刷委托书】实现层
 *
 * @author sml
 * @date 2023-08-14
 */
@Slf4j
@Service
public class MonadApplyForPrintingServiceImpl extends ServiceImpl<MonadApplyForPrintingMapper, MonadApplyForPrinting> implements IMonadApplyForPrintingService {
}
