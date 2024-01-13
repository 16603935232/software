package com.datasource.mapper;

import com.datasource.entity.Prompt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【不再提示表】映射器
 *
 * @author shangml
 * @date 2023-01-31
 */
@Mapper
public interface PromptMapper extends BaseMapper<Prompt> {

}
