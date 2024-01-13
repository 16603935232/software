package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.ObservInformationPublishDTO;
import com.replay.vo.ObservInformationPublishVO;
import com.replay.entity.ObservInformationPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IObservInformationPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【观测信息发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【观测信息发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/observ-information-publish")
public class ObservInformationPublishController {

    private final IObservInformationPublishService  observInformationPublishService;

    @ApiOperation(value = "观测信息发布表列表查询")
    @PostMapping("/list")
    public Result<List<ObservInformationPublishVO>> list(@RequestBody ObservInformationPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ObservInformationPublishVO.class,observInformationPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, ObservInformationPublish.class)))));
    }

    @ApiOperation(value = "观测信息发布表分页查询")
    @PostMapping("/page")
    public Result<Page<ObservInformationPublishVO>> page(@RequestBody ObservInformationPublishDTO dto) {
        Page<ObservInformationPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<ObservInformationPublish> result = observInformationPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, ObservInformationPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ObservInformationPublishVO.class, result));
    }

    @ApiOperation(value = "观测信息发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ObservInformationPublishDTO dto) {
        ObservInformationPublish entity = BeanUtil.copyProperties(dto, ObservInformationPublish.class);
        observInformationPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "观测信息发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ObservInformationPublishDTO dto) {
        ObservInformationPublish entity = BeanUtil.copyProperties(dto, ObservInformationPublish.class);
        return Result.ok(observInformationPublishService.save(entity));
    }

    @ApiOperation(value = "观测信息发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ObservInformationPublishDTO dto) {
        ObservInformationPublish entity = BeanUtil.copyProperties(dto, ObservInformationPublish.class);
        return Result.ok(observInformationPublishService.updateById(entity));
    }

    @ApiOperation(value = "观测信息发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(observInformationPublishService.removeById(id));
    }

    @ApiOperation(value = "观测信息发布表详情")
    @GetMapping("/{id}")
    public Result<ObservInformationPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(observInformationPublishService.getById(id), ObservInformationPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(observInformationPublishService.removeByIds(ids));
    }


}

