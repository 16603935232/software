package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.CooperativeUnit;
import com.content.vo.CooperativeUnitVO;
import com.content.mapper.CooperativeUnitMapper;
import com.content.service.ICooperativeUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【合作单位表】实现层
 *
 * @author sml
 * @date 2023-08-03
 */
@Slf4j
@Service
public class CooperativeUnitServiceImpl extends ServiceImpl<CooperativeUnitMapper, CooperativeUnit> implements ICooperativeUnitService {
}
