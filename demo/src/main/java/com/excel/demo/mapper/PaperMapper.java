package com.excel.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.excel.demo.entity.Paper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【论文表】映射器
 *
 * @author carl
 * @date 2022-12-13
 * @company:
 */
@Mapper
public interface PaperMapper extends BaseMapper<Paper> {

}
