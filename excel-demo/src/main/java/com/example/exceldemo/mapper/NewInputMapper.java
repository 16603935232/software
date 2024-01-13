package com.example.exceldemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.exceldemo.entity.NewInput;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【新增产业能耗设定输入表】映射器
 *
 * @author shangml
 * @date 2023-01-15
 */
@Mapper
public interface NewInputMapper extends BaseMapper<NewInput> {

}
