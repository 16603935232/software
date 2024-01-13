package com.datasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.datasource.entity.SysRoleUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.datasource.vo.SysRoleUserVO;
import com.datasource.dto.SysRoleUserDTO;
import java.util.List;

/**
 * 【用户对应角色表】代理层
 *
 * @author liuzhiyu
 * @date 2023-01-04
 */
public interface ISysRoleUserService extends IService<SysRoleUser> {
}
