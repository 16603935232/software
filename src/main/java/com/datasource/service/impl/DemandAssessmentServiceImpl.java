package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.DemandAssessment;
import com.datasource.vo.DemandAssessmentVO;
import com.datasource.mapper.DemandAssessmentMapper;
import com.datasource.service.IDemandAssessmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【需求单退回表】实现层
 *
 * @author shangmingliang
 * @date 2023-01-04
 */
@Slf4j
@Service
public class DemandAssessmentServiceImpl extends ServiceImpl<DemandAssessmentMapper, DemandAssessment> implements IDemandAssessmentService {
}
