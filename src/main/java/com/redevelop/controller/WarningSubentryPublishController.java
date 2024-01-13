package com.redevelop.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redevelop.result.Result;

import com.redevelop.dto.WarningSubentryPublishDTO;
import com.redevelop.vo.WarningSubentryPublishVO;
import com.redevelop.entity.WarningSubentryPublish;
import com.redevelop.utils.QueryUtil;
import com.redevelop.service.IWarningSubentryPublishService;
import com.redevelop.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预警分项指标发布表】控制器层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Api(tags = {"【预警分项指标发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/warning-subentry-publish")
public class WarningSubentryPublishController {

    private final IWarningSubentryPublishService  warningSubentryPublishService;

    @ApiOperation(value = "预警分项指标发布表列表查询")
    @PostMapping("/list")
    public Result<List<WarningSubentryPublishVO>> list(@RequestBody WarningSubentryPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(WarningSubentryPublishVO.class,warningSubentryPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, WarningSubentryPublish.class)))));
    }

    @ApiOperation(value = "预警分项指标发布表分页查询")
    @PostMapping("/page")
    public Result<Page<WarningSubentryPublishVO>> page(@RequestBody WarningSubentryPublishDTO dto) {
        Page<WarningSubentryPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<WarningSubentryPublish> result = warningSubentryPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, WarningSubentryPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(WarningSubentryPublishVO.class, result));
    }

    @ApiOperation(value = "预警分项指标发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody WarningSubentryPublishDTO dto) {
        WarningSubentryPublish entity = BeanUtil.copyProperties(dto, WarningSubentryPublish.class);
        warningSubentryPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预警分项指标发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody WarningSubentryPublishDTO dto) {
        WarningSubentryPublish entity = BeanUtil.copyProperties(dto, WarningSubentryPublish.class);
        return Result.ok(warningSubentryPublishService.save(entity));
    }

    @ApiOperation(value = "预警分项指标发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody WarningSubentryPublishDTO dto) {
        WarningSubentryPublish entity = BeanUtil.copyProperties(dto, WarningSubentryPublish.class);
        return Result.ok(warningSubentryPublishService.updateById(entity));
    }

    @ApiOperation(value = "预警分项指标发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(warningSubentryPublishService.removeById(id));
    }

    @ApiOperation(value = "预警分项指标发布表详情")
    @GetMapping("/{id}")
    public Result<WarningSubentryPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(warningSubentryPublishService.getById(id), WarningSubentryPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(warningSubentryPublishService.removeByIds(ids));
    }


}

