package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.PredictInformationPublishDTO;
import com.replay.vo.PredictInformationPublishVO;
import com.replay.entity.PredictInformationPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IPredictInformationPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预测信息发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预测信息发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/predict-information-publish")
public class PredictInformationPublishController {

    private final IPredictInformationPublishService  predictInformationPublishService;

    @ApiOperation(value = "预测信息发布表列表查询")
    @PostMapping("/list")
    public Result<List<PredictInformationPublishVO>> list(@RequestBody PredictInformationPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PredictInformationPublishVO.class,predictInformationPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, PredictInformationPublish.class)))));
    }

    @ApiOperation(value = "预测信息发布表分页查询")
    @PostMapping("/page")
    public Result<Page<PredictInformationPublishVO>> page(@RequestBody PredictInformationPublishDTO dto) {
        Page<PredictInformationPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<PredictInformationPublish> result = predictInformationPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, PredictInformationPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PredictInformationPublishVO.class, result));
    }

    @ApiOperation(value = "预测信息发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PredictInformationPublishDTO dto) {
        PredictInformationPublish entity = BeanUtil.copyProperties(dto, PredictInformationPublish.class);
        predictInformationPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预测信息发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PredictInformationPublishDTO dto) {
        PredictInformationPublish entity = BeanUtil.copyProperties(dto, PredictInformationPublish.class);
        return Result.ok(predictInformationPublishService.save(entity));
    }

    @ApiOperation(value = "预测信息发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PredictInformationPublishDTO dto) {
        PredictInformationPublish entity = BeanUtil.copyProperties(dto, PredictInformationPublish.class);
        return Result.ok(predictInformationPublishService.updateById(entity));
    }

    @ApiOperation(value = "预测信息发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(predictInformationPublishService.removeById(id));
    }

    @ApiOperation(value = "预测信息发布表详情")
    @GetMapping("/{id}")
    public Result<PredictInformationPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(predictInformationPublishService.getById(id), PredictInformationPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(predictInformationPublishService.removeByIds(ids));
    }


}

