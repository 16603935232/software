package com.datasource.mapper;

import com.datasource.entity.DataPush;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【数据更新情况推送表】映射器
 *
 * @author shangml
 * @date 2023-12-13
 */
@Mapper
public interface DataPushMapper extends BaseMapper<DataPush> {

}
