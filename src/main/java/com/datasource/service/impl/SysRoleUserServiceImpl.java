package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.SysRoleUser;
import com.datasource.vo.SysRoleUserVO;
import com.datasource.mapper.SysRoleUserMapper;
import com.datasource.service.ISysRoleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【用户对应角色表】实现层
 *
 * @author liuzhiyu
 * @date 2023-01-04
 */
@Slf4j
@Service
public class SysRoleUserServiceImpl extends ServiceImpl<SysRoleUserMapper, SysRoleUser> implements ISysRoleUserService {
}
