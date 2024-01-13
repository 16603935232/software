package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.SysLogDTO;
import com.datasource.vo.SysLogVO;
import com.datasource.entity.SysLog;
import com.datasource.utils.QueryUtil;
import com.datasource.service.ISysLogService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【日志表】控制器层
 *
 * @author liuzhiyu
 * @date 2023-07-04
 */
@Slf4j
@Api(tags = {"【日志表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys-log")
public class SysLogController {

    private final ISysLogService  sysLogService;

    @ApiOperation(value = "日志表列表查询")
    @PostMapping("/list")
    public Result<List<SysLogVO>> list(@RequestBody SysLogDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(SysLogVO.class,sysLogService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, SysLog.class)))));
    }

    @ApiOperation(value = "日志表分页查询")
    @PostMapping("/page")
    public Result<Page<SysLogVO>> page(@RequestBody SysLogDTO dto) {
        Page<SysLog> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<SysLog> result = sysLogService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, SysLog.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(SysLogVO.class, result));
    }

    @ApiOperation(value = "日志表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody SysLogDTO dto) {
        SysLog entity = BeanUtil.copyProperties(dto, SysLog.class);
        sysLogService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "日志表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody SysLogDTO dto) {
        SysLog entity = BeanUtil.copyProperties(dto, SysLog.class);
        return Result.ok(sysLogService.save(entity));
    }

    @ApiOperation(value = "日志表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody SysLogDTO dto) {
        SysLog entity = BeanUtil.copyProperties(dto, SysLog.class);
        return Result.ok(sysLogService.updateById(entity));
    }

    @ApiOperation(value = "日志表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(sysLogService.removeById(id));
    }

    @ApiOperation(value = "日志表详情")
    @GetMapping("/{id}")
    public Result<SysLogVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(sysLogService.getById(id), SysLogVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(sysLogService.removeByIds(ids));
    }


}

