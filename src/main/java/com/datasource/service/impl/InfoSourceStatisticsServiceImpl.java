package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.InfoSourceStatistics;
import com.datasource.vo.InfoSourceStatisticsVO;
import com.datasource.mapper.InfoSourceStatisticsMapper;
import com.datasource.service.IInfoSourceStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【信源数据统计】实现层
 *
 * @author shangml
 * @date 2023-12-06
 */
@Slf4j
@Service
public class InfoSourceStatisticsServiceImpl extends ServiceImpl<InfoSourceStatisticsMapper, InfoSourceStatistics> implements IInfoSourceStatisticsService {
}
