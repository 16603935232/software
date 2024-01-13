package com.datasource.mapper;

import com.datasource.entity.SysRoleUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【用户对应角色表】映射器
 *
 * @author liuzhiyu
 * @date 2023-01-04
 */
@Mapper
public interface SysRoleUserMapper extends BaseMapper<SysRoleUser> {

}
