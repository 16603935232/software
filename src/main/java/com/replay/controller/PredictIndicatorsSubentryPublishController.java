package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.PredictIndicatorsSubentryPublishDTO;
import com.replay.vo.PredictIndicatorsSubentryPublishVO;
import com.replay.entity.PredictIndicatorsSubentryPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IPredictIndicatorsSubentryPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预测分项指标发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预测分项指标发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/predict-indicators-subentry-publish")
public class PredictIndicatorsSubentryPublishController {

    private final IPredictIndicatorsSubentryPublishService  predictIndicatorsSubentryPublishService;

    @ApiOperation(value = "预测分项指标发布表列表查询")
    @PostMapping("/list")
    public Result<List<PredictIndicatorsSubentryPublishVO>> list(@RequestBody PredictIndicatorsSubentryPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PredictIndicatorsSubentryPublishVO.class,predictIndicatorsSubentryPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, PredictIndicatorsSubentryPublish.class)))));
    }

    @ApiOperation(value = "预测分项指标发布表分页查询")
    @PostMapping("/page")
    public Result<Page<PredictIndicatorsSubentryPublishVO>> page(@RequestBody PredictIndicatorsSubentryPublishDTO dto) {
        Page<PredictIndicatorsSubentryPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<PredictIndicatorsSubentryPublish> result = predictIndicatorsSubentryPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, PredictIndicatorsSubentryPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PredictIndicatorsSubentryPublishVO.class, result));
    }

    @ApiOperation(value = "预测分项指标发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PredictIndicatorsSubentryPublishDTO dto) {
        PredictIndicatorsSubentryPublish entity = BeanUtil.copyProperties(dto, PredictIndicatorsSubentryPublish.class);
        predictIndicatorsSubentryPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预测分项指标发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PredictIndicatorsSubentryPublishDTO dto) {
        PredictIndicatorsSubentryPublish entity = BeanUtil.copyProperties(dto, PredictIndicatorsSubentryPublish.class);
        return Result.ok(predictIndicatorsSubentryPublishService.save(entity));
    }

    @ApiOperation(value = "预测分项指标发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PredictIndicatorsSubentryPublishDTO dto) {
        PredictIndicatorsSubentryPublish entity = BeanUtil.copyProperties(dto, PredictIndicatorsSubentryPublish.class);
        return Result.ok(predictIndicatorsSubentryPublishService.updateById(entity));
    }

    @ApiOperation(value = "预测分项指标发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(predictIndicatorsSubentryPublishService.removeById(id));
    }

    @ApiOperation(value = "预测分项指标发布表详情")
    @GetMapping("/{id}")
    public Result<PredictIndicatorsSubentryPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(predictIndicatorsSubentryPublishService.getById(id), PredictIndicatorsSubentryPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(predictIndicatorsSubentryPublishService.removeByIds(ids));
    }


}

