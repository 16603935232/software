package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.PreventIndicatorsPublishDTO;
import com.replay.vo.PreventIndicatorsPublishVO;
import com.replay.entity.PreventIndicatorsPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IPreventIndicatorsPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预防指标体系发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预防指标体系发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/prevent-indicators-publish")
public class PreventIndicatorsPublishController {

    private final IPreventIndicatorsPublishService  preventIndicatorsPublishService;

    @ApiOperation(value = "预防指标体系发布表列表查询")
    @PostMapping("/list")
    public Result<List<PreventIndicatorsPublishVO>> list(@RequestBody PreventIndicatorsPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PreventIndicatorsPublishVO.class,preventIndicatorsPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, PreventIndicatorsPublish.class)))));
    }

    @ApiOperation(value = "预防指标体系发布表分页查询")
    @PostMapping("/page")
    public Result<Page<PreventIndicatorsPublishVO>> page(@RequestBody PreventIndicatorsPublishDTO dto) {
        Page<PreventIndicatorsPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<PreventIndicatorsPublish> result = preventIndicatorsPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, PreventIndicatorsPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PreventIndicatorsPublishVO.class, result));
    }

    @ApiOperation(value = "预防指标体系发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PreventIndicatorsPublishDTO dto) {
        PreventIndicatorsPublish entity = BeanUtil.copyProperties(dto, PreventIndicatorsPublish.class);
        preventIndicatorsPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预防指标体系发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PreventIndicatorsPublishDTO dto) {
        PreventIndicatorsPublish entity = BeanUtil.copyProperties(dto, PreventIndicatorsPublish.class);
        return Result.ok(preventIndicatorsPublishService.save(entity));
    }

    @ApiOperation(value = "预防指标体系发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PreventIndicatorsPublishDTO dto) {
        PreventIndicatorsPublish entity = BeanUtil.copyProperties(dto, PreventIndicatorsPublish.class);
        return Result.ok(preventIndicatorsPublishService.updateById(entity));
    }

    @ApiOperation(value = "预防指标体系发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(preventIndicatorsPublishService.removeById(id));
    }

    @ApiOperation(value = "预防指标体系发布表详情")
    @GetMapping("/{id}")
    public Result<PreventIndicatorsPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(preventIndicatorsPublishService.getById(id), PreventIndicatorsPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(preventIndicatorsPublishService.removeByIds(ids));
    }


}

