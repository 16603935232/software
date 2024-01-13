package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.PredictIndicatorsFeaturePublishDTO;
import com.replay.vo.PredictIndicatorsFeaturePublishVO;
import com.replay.entity.PredictIndicatorsFeaturePublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IPredictIndicatorsFeaturePublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预测特征、难题发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预测特征、难题发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/predict-indicators-feature-publish")
public class PredictIndicatorsFeaturePublishController {

    private final IPredictIndicatorsFeaturePublishService  predictIndicatorsFeaturePublishService;

    @ApiOperation(value = "预测特征、难题发布表列表查询")
    @PostMapping("/list")
    public Result<List<PredictIndicatorsFeaturePublishVO>> list(@RequestBody PredictIndicatorsFeaturePublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PredictIndicatorsFeaturePublishVO.class,predictIndicatorsFeaturePublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, PredictIndicatorsFeaturePublish.class)))));
    }

    @ApiOperation(value = "预测特征、难题发布表分页查询")
    @PostMapping("/page")
    public Result<Page<PredictIndicatorsFeaturePublishVO>> page(@RequestBody PredictIndicatorsFeaturePublishDTO dto) {
        Page<PredictIndicatorsFeaturePublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<PredictIndicatorsFeaturePublish> result = predictIndicatorsFeaturePublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, PredictIndicatorsFeaturePublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PredictIndicatorsFeaturePublishVO.class, result));
    }

    @ApiOperation(value = "预测特征、难题发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PredictIndicatorsFeaturePublishDTO dto) {
        PredictIndicatorsFeaturePublish entity = BeanUtil.copyProperties(dto, PredictIndicatorsFeaturePublish.class);
        predictIndicatorsFeaturePublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预测特征、难题发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PredictIndicatorsFeaturePublishDTO dto) {
        PredictIndicatorsFeaturePublish entity = BeanUtil.copyProperties(dto, PredictIndicatorsFeaturePublish.class);
        return Result.ok(predictIndicatorsFeaturePublishService.save(entity));
    }

    @ApiOperation(value = "预测特征、难题发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PredictIndicatorsFeaturePublishDTO dto) {
        PredictIndicatorsFeaturePublish entity = BeanUtil.copyProperties(dto, PredictIndicatorsFeaturePublish.class);
        return Result.ok(predictIndicatorsFeaturePublishService.updateById(entity));
    }

    @ApiOperation(value = "预测特征、难题发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(predictIndicatorsFeaturePublishService.removeById(id));
    }

    @ApiOperation(value = "预测特征、难题发布表详情")
    @GetMapping("/{id}")
    public Result<PredictIndicatorsFeaturePublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(predictIndicatorsFeaturePublishService.getById(id), PredictIndicatorsFeaturePublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(predictIndicatorsFeaturePublishService.removeByIds(ids));
    }


}

