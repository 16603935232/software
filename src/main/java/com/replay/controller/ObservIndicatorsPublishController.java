package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.ObservIndicatorsPublishDTO;
import com.replay.vo.ObservIndicatorsPublishVO;
import com.replay.entity.ObservIndicatorsPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IObservIndicatorsPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【观测指标体系发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【观测指标体系发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/observ-indicators-publish")
public class ObservIndicatorsPublishController {

    private final IObservIndicatorsPublishService  observIndicatorsPublishService;

    @ApiOperation(value = "观测指标体系发布表列表查询")
    @PostMapping("/list")
    public Result<List<ObservIndicatorsPublishVO>> list(@RequestBody ObservIndicatorsPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ObservIndicatorsPublishVO.class,observIndicatorsPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, ObservIndicatorsPublish.class)))));
    }

    @ApiOperation(value = "观测指标体系发布表分页查询")
    @PostMapping("/page")
    public Result<Page<ObservIndicatorsPublishVO>> page(@RequestBody ObservIndicatorsPublishDTO dto) {
        Page<ObservIndicatorsPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<ObservIndicatorsPublish> result = observIndicatorsPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, ObservIndicatorsPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ObservIndicatorsPublishVO.class, result));
    }

    @ApiOperation(value = "观测指标体系发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ObservIndicatorsPublishDTO dto) {
        ObservIndicatorsPublish entity = BeanUtil.copyProperties(dto, ObservIndicatorsPublish.class);
        observIndicatorsPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "观测指标体系发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ObservIndicatorsPublishDTO dto) {
        ObservIndicatorsPublish entity = BeanUtil.copyProperties(dto, ObservIndicatorsPublish.class);
        return Result.ok(observIndicatorsPublishService.save(entity));
    }

    @ApiOperation(value = "观测指标体系发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ObservIndicatorsPublishDTO dto) {
        ObservIndicatorsPublish entity = BeanUtil.copyProperties(dto, ObservIndicatorsPublish.class);
        return Result.ok(observIndicatorsPublishService.updateById(entity));
    }

    @ApiOperation(value = "观测指标体系发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(observIndicatorsPublishService.removeById(id));
    }

    @ApiOperation(value = "观测指标体系发布表详情")
    @GetMapping("/{id}")
    public Result<ObservIndicatorsPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(observIndicatorsPublishService.getById(id), ObservIndicatorsPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(observIndicatorsPublishService.removeByIds(ids));
    }


}

