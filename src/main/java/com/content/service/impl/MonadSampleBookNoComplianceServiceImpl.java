package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.MonadSampleBookNoCompliance;
import com.content.vo.MonadSampleBookNoComplianceVO;
import com.content.mapper.MonadSampleBookNoComplianceMapper;
import com.content.service.IMonadSampleBookNoComplianceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【样书上交不达标说明单】实现层
 *
 * @author sml
 * @date 2023-08-14
 */
@Slf4j
@Service
public class MonadSampleBookNoComplianceServiceImpl extends ServiceImpl<MonadSampleBookNoComplianceMapper, MonadSampleBookNoCompliance> implements IMonadSampleBookNoComplianceService {
}
