package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.PreventInformationPublishDTO;
import com.replay.vo.PreventInformationPublishVO;
import com.replay.entity.PreventInformationPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IPreventInformationPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预防信息发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预防信息发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/prevent-information-publish")
public class PreventInformationPublishController {

    private final IPreventInformationPublishService  preventInformationPublishService;

    @ApiOperation(value = "预防信息发布表列表查询")
    @PostMapping("/list")
    public Result<List<PreventInformationPublishVO>> list(@RequestBody PreventInformationPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PreventInformationPublishVO.class,preventInformationPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, PreventInformationPublish.class)))));
    }

    @ApiOperation(value = "预防信息发布表分页查询")
    @PostMapping("/page")
    public Result<Page<PreventInformationPublishVO>> page(@RequestBody PreventInformationPublishDTO dto) {
        Page<PreventInformationPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<PreventInformationPublish> result = preventInformationPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, PreventInformationPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PreventInformationPublishVO.class, result));
    }

    @ApiOperation(value = "预防信息发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PreventInformationPublishDTO dto) {
        PreventInformationPublish entity = BeanUtil.copyProperties(dto, PreventInformationPublish.class);
        preventInformationPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预防信息发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PreventInformationPublishDTO dto) {
        PreventInformationPublish entity = BeanUtil.copyProperties(dto, PreventInformationPublish.class);
        return Result.ok(preventInformationPublishService.save(entity));
    }

    @ApiOperation(value = "预防信息发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PreventInformationPublishDTO dto) {
        PreventInformationPublish entity = BeanUtil.copyProperties(dto, PreventInformationPublish.class);
        return Result.ok(preventInformationPublishService.updateById(entity));
    }

    @ApiOperation(value = "预防信息发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(preventInformationPublishService.removeById(id));
    }

    @ApiOperation(value = "预防信息发布表详情")
    @GetMapping("/{id}")
    public Result<PreventInformationPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(preventInformationPublishService.getById(id), PreventInformationPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(preventInformationPublishService.removeByIds(ids));
    }


}

