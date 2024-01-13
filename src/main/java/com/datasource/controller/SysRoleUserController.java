package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.SysRoleUserDTO;
import com.datasource.vo.SysRoleUserVO;
import com.datasource.entity.SysRoleUser;
import com.datasource.utils.QueryUtil;
import com.datasource.service.ISysRoleUserService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【用户对应角色表】控制器层
 *
 * @author liuzhiyu
 * @date 2023-01-04
 */
@Slf4j
@Api(tags = {"【用户对应角色表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys-role-user")
public class SysRoleUserController {

    private final ISysRoleUserService  sysRoleUserService;

    @ApiOperation(value = "用户对应角色表列表查询")
    @PostMapping("/list")
    public Result<List<SysRoleUserVO>> list(@RequestBody SysRoleUserDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(SysRoleUserVO.class,sysRoleUserService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, SysRoleUser.class)))));
    }

    @ApiOperation(value = "用户对应角色表分页查询")
    @PostMapping("/page")
    public Result<Page<SysRoleUserVO>> page(@RequestBody SysRoleUserDTO dto) {
        Page<SysRoleUser> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<SysRoleUser> result = sysRoleUserService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, SysRoleUser.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(SysRoleUserVO.class, result));
    }

    @ApiOperation(value = "用户对应角色表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody SysRoleUserDTO dto) {
        SysRoleUser entity = BeanUtil.copyProperties(dto, SysRoleUser.class);
        sysRoleUserService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "用户对应角色表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody SysRoleUserDTO dto) {
        SysRoleUser entity = BeanUtil.copyProperties(dto, SysRoleUser.class);
        return Result.ok(sysRoleUserService.save(entity));
    }

    @ApiOperation(value = "用户对应角色表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody SysRoleUserDTO dto) {
        SysRoleUser entity = BeanUtil.copyProperties(dto, SysRoleUser.class);
        return Result.ok(sysRoleUserService.updateById(entity));
    }

    @ApiOperation(value = "用户对应角色表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(sysRoleUserService.removeById(id));
    }

    @ApiOperation(value = "用户对应角色表详情")
    @GetMapping("/{id}")
    public Result<SysRoleUserVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(sysRoleUserService.getById(id), SysRoleUserVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(sysRoleUserService.removeByIds(ids));
    }


}

