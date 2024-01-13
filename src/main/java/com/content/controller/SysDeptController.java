package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.SysDeptDTO;
import com.content.vo.SysDeptVO;
import com.content.entity.SysDept;
import com.content.utils.QueryUtil;
import com.content.service.ISysDeptService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【部门表】控制器层
 *
 * @author lzy
 * @date 2023-08-03
 */
@Slf4j
@Api(tags = {"【部门表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys-dept")
public class SysDeptController {

    private final ISysDeptService  sysDeptService;

    @ApiOperation(value = "部门表列表查询")
    @PostMapping("/list")
    public Result<List<SysDeptVO>> list(@RequestBody SysDeptDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(SysDeptVO.class,sysDeptService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, SysDept.class)))));
    }

    @ApiOperation(value = "部门表分页查询")
    @PostMapping("/page")
    public Result<Page<SysDeptVO>> page(@RequestBody SysDeptDTO dto) {
        Page<SysDept> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<SysDept> result = sysDeptService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, SysDept.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(SysDeptVO.class, result));
    }

    @ApiOperation(value = "部门表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody SysDeptDTO dto) {
        SysDept entity = BeanUtil.copyProperties(dto, SysDept.class);
        sysDeptService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "部门表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody SysDeptDTO dto) {
        SysDept entity = BeanUtil.copyProperties(dto, SysDept.class);
        return Result.ok(sysDeptService.save(entity));
    }

    @ApiOperation(value = "部门表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody SysDeptDTO dto) {
        SysDept entity = BeanUtil.copyProperties(dto, SysDept.class);
        return Result.ok(sysDeptService.updateById(entity));
    }

    @ApiOperation(value = "部门表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(sysDeptService.removeById(id));
    }

    @ApiOperation(value = "部门表详情")
    @GetMapping("/{id}")
    public Result<SysDeptVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(sysDeptService.getById(id), SysDeptVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(sysDeptService.removeByIds(ids));
    }


}

