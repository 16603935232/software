package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.ObservIndicatorsSubentryPublishDTO;
import com.replay.vo.ObservIndicatorsSubentryPublishVO;
import com.replay.entity.ObservIndicatorsSubentryPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IObservIndicatorsSubentryPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【观测分项指标发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【观测分项指标发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/observ-indicators-subentry-publish")
public class ObservIndicatorsSubentryPublishController {

    private final IObservIndicatorsSubentryPublishService  observIndicatorsSubentryPublishService;

    @ApiOperation(value = "观测分项指标发布表列表查询")
    @PostMapping("/list")
    public Result<List<ObservIndicatorsSubentryPublishVO>> list(@RequestBody ObservIndicatorsSubentryPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ObservIndicatorsSubentryPublishVO.class,observIndicatorsSubentryPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, ObservIndicatorsSubentryPublish.class)))));
    }

    @ApiOperation(value = "观测分项指标发布表分页查询")
    @PostMapping("/page")
    public Result<Page<ObservIndicatorsSubentryPublishVO>> page(@RequestBody ObservIndicatorsSubentryPublishDTO dto) {
        Page<ObservIndicatorsSubentryPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<ObservIndicatorsSubentryPublish> result = observIndicatorsSubentryPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, ObservIndicatorsSubentryPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ObservIndicatorsSubentryPublishVO.class, result));
    }

    @ApiOperation(value = "观测分项指标发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ObservIndicatorsSubentryPublishDTO dto) {
        ObservIndicatorsSubentryPublish entity = BeanUtil.copyProperties(dto, ObservIndicatorsSubentryPublish.class);
        observIndicatorsSubentryPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "观测分项指标发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ObservIndicatorsSubentryPublishDTO dto) {
        ObservIndicatorsSubentryPublish entity = BeanUtil.copyProperties(dto, ObservIndicatorsSubentryPublish.class);
        return Result.ok(observIndicatorsSubentryPublishService.save(entity));
    }

    @ApiOperation(value = "观测分项指标发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ObservIndicatorsSubentryPublishDTO dto) {
        ObservIndicatorsSubentryPublish entity = BeanUtil.copyProperties(dto, ObservIndicatorsSubentryPublish.class);
        return Result.ok(observIndicatorsSubentryPublishService.updateById(entity));
    }

    @ApiOperation(value = "观测分项指标发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(observIndicatorsSubentryPublishService.removeById(id));
    }

    @ApiOperation(value = "观测分项指标发布表详情")
    @GetMapping("/{id}")
    public Result<ObservIndicatorsSubentryPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(observIndicatorsSubentryPublishService.getById(id), ObservIndicatorsSubentryPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(observIndicatorsSubentryPublishService.removeByIds(ids));
    }


}

