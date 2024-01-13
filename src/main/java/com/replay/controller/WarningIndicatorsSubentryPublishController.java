package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.WarningIndicatorsSubentryPublishDTO;
import com.replay.vo.WarningIndicatorsSubentryPublishVO;
import com.replay.entity.WarningIndicatorsSubentryPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IWarningIndicatorsSubentryPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预警分项指标发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预警分项指标发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/warning-indicators-subentry-publish")
public class WarningIndicatorsSubentryPublishController {

    private final IWarningIndicatorsSubentryPublishService  warningIndicatorsSubentryPublishService;

    @ApiOperation(value = "预警分项指标发布表列表查询")
    @PostMapping("/list")
    public Result<List<WarningIndicatorsSubentryPublishVO>> list(@RequestBody WarningIndicatorsSubentryPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(WarningIndicatorsSubentryPublishVO.class,warningIndicatorsSubentryPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, WarningIndicatorsSubentryPublish.class)))));
    }

    @ApiOperation(value = "预警分项指标发布表分页查询")
    @PostMapping("/page")
    public Result<Page<WarningIndicatorsSubentryPublishVO>> page(@RequestBody WarningIndicatorsSubentryPublishDTO dto) {
        Page<WarningIndicatorsSubentryPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<WarningIndicatorsSubentryPublish> result = warningIndicatorsSubentryPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, WarningIndicatorsSubentryPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(WarningIndicatorsSubentryPublishVO.class, result));
    }

    @ApiOperation(value = "预警分项指标发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody WarningIndicatorsSubentryPublishDTO dto) {
        WarningIndicatorsSubentryPublish entity = BeanUtil.copyProperties(dto, WarningIndicatorsSubentryPublish.class);
        warningIndicatorsSubentryPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预警分项指标发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody WarningIndicatorsSubentryPublishDTO dto) {
        WarningIndicatorsSubentryPublish entity = BeanUtil.copyProperties(dto, WarningIndicatorsSubentryPublish.class);
        return Result.ok(warningIndicatorsSubentryPublishService.save(entity));
    }

    @ApiOperation(value = "预警分项指标发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody WarningIndicatorsSubentryPublishDTO dto) {
        WarningIndicatorsSubentryPublish entity = BeanUtil.copyProperties(dto, WarningIndicatorsSubentryPublish.class);
        return Result.ok(warningIndicatorsSubentryPublishService.updateById(entity));
    }

    @ApiOperation(value = "预警分项指标发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(warningIndicatorsSubentryPublishService.removeById(id));
    }

    @ApiOperation(value = "预警分项指标发布表详情")
    @GetMapping("/{id}")
    public Result<WarningIndicatorsSubentryPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(warningIndicatorsSubentryPublishService.getById(id), WarningIndicatorsSubentryPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(warningIndicatorsSubentryPublishService.removeByIds(ids));
    }


}

