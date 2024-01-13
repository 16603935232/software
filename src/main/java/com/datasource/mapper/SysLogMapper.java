package com.datasource.mapper;

import com.datasource.entity.SysLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【日志表】映射器
 *
 * @author liuzhiyu
 * @date 2023-07-04
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

}
