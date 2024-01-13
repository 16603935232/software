package com.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ai.entity.Institute;
import com.ai.vo.InstituteVO;
import com.ai.mapper.InstituteMapper;
import com.ai.service.IInstituteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【研究机构表】实现层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Service
public class InstituteServiceImpl extends ServiceImpl<InstituteMapper, Institute> implements IInstituteService {
}
