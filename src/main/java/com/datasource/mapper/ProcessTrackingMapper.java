package com.datasource.mapper;

import com.datasource.entity.ProcessTracking;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【过程跟踪表】映射器
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
@Mapper
public interface ProcessTrackingMapper extends BaseMapper<ProcessTracking> {

}
