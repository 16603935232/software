package com.datasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.datasource.entity.InfoSourceStatistics;
import com.baomidou.mybatisplus.extension.service.IService;
import com.datasource.vo.InfoSourceStatisticsVO;
import com.datasource.dto.InfoSourceStatisticsDTO;
import java.util.List;

/**
 * 【信源数据统计】代理层
 *
 * @author shangml
 * @date 2023-12-06
 */
public interface IInfoSourceStatisticsService extends IService<InfoSourceStatistics> {
}
