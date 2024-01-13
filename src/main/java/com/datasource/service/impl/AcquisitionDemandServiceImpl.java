package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.AcquisitionDemand;
import com.datasource.vo.AcquisitionDemandVO;
import com.datasource.mapper.AcquisitionDemandMapper;
import com.datasource.service.IAcquisitionDemandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【采集提需表】实现层
 *
 * @author haoxiaoming
 * @date 2022-12-21
 */
@Slf4j
@Service
public class AcquisitionDemandServiceImpl extends ServiceImpl<AcquisitionDemandMapper, AcquisitionDemand> implements IAcquisitionDemandService {
}
