package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.PredictIndicatorsPublishDTO;
import com.replay.vo.PredictIndicatorsPublishVO;
import com.replay.entity.PredictIndicatorsPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IPredictIndicatorsPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预测指标体系表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预测指标体系表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/predict-indicators-publish")
public class PredictIndicatorsPublishController {

    private final IPredictIndicatorsPublishService  predictIndicatorsPublishService;

    @ApiOperation(value = "预测指标体系表列表查询")
    @PostMapping("/list")
    public Result<List<PredictIndicatorsPublishVO>> list(@RequestBody PredictIndicatorsPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PredictIndicatorsPublishVO.class,predictIndicatorsPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, PredictIndicatorsPublish.class)))));
    }

    @ApiOperation(value = "预测指标体系表分页查询")
    @PostMapping("/page")
    public Result<Page<PredictIndicatorsPublishVO>> page(@RequestBody PredictIndicatorsPublishDTO dto) {
        Page<PredictIndicatorsPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<PredictIndicatorsPublish> result = predictIndicatorsPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, PredictIndicatorsPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PredictIndicatorsPublishVO.class, result));
    }

    @ApiOperation(value = "预测指标体系表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PredictIndicatorsPublishDTO dto) {
        PredictIndicatorsPublish entity = BeanUtil.copyProperties(dto, PredictIndicatorsPublish.class);
        predictIndicatorsPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预测指标体系表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PredictIndicatorsPublishDTO dto) {
        PredictIndicatorsPublish entity = BeanUtil.copyProperties(dto, PredictIndicatorsPublish.class);
        return Result.ok(predictIndicatorsPublishService.save(entity));
    }

    @ApiOperation(value = "预测指标体系表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PredictIndicatorsPublishDTO dto) {
        PredictIndicatorsPublish entity = BeanUtil.copyProperties(dto, PredictIndicatorsPublish.class);
        return Result.ok(predictIndicatorsPublishService.updateById(entity));
    }

    @ApiOperation(value = "预测指标体系表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(predictIndicatorsPublishService.removeById(id));
    }

    @ApiOperation(value = "预测指标体系表详情")
    @GetMapping("/{id}")
    public Result<PredictIndicatorsPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(predictIndicatorsPublishService.getById(id), PredictIndicatorsPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(predictIndicatorsPublishService.removeByIds(ids));
    }


}

