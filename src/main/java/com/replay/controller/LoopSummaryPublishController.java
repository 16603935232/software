package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.LoopSummaryPublishDTO;
import com.replay.vo.LoopSummaryPublishVO;
import com.replay.entity.LoopSummaryPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.ILoopSummaryPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【环路量化总结发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【环路量化总结发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/loop-summary-publish")
public class LoopSummaryPublishController {

    private final ILoopSummaryPublishService  loopSummaryPublishService;

    @ApiOperation(value = "环路量化总结发布表列表查询")
    @PostMapping("/list")
    public Result<List<LoopSummaryPublishVO>> list(@RequestBody LoopSummaryPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(LoopSummaryPublishVO.class,loopSummaryPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, LoopSummaryPublish.class)))));
    }

    @ApiOperation(value = "环路量化总结发布表分页查询")
    @PostMapping("/page")
    public Result<Page<LoopSummaryPublishVO>> page(@RequestBody LoopSummaryPublishDTO dto) {
        Page<LoopSummaryPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<LoopSummaryPublish> result = loopSummaryPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, LoopSummaryPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(LoopSummaryPublishVO.class, result));
    }

    @ApiOperation(value = "环路量化总结发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody LoopSummaryPublishDTO dto) {
        LoopSummaryPublish entity = BeanUtil.copyProperties(dto, LoopSummaryPublish.class);
        loopSummaryPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "环路量化总结发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody LoopSummaryPublishDTO dto) {
        LoopSummaryPublish entity = BeanUtil.copyProperties(dto, LoopSummaryPublish.class);
        return Result.ok(loopSummaryPublishService.save(entity));
    }

    @ApiOperation(value = "环路量化总结发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody LoopSummaryPublishDTO dto) {
        LoopSummaryPublish entity = BeanUtil.copyProperties(dto, LoopSummaryPublish.class);
        return Result.ok(loopSummaryPublishService.updateById(entity));
    }

    @ApiOperation(value = "环路量化总结发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(loopSummaryPublishService.removeById(id));
    }

    @ApiOperation(value = "环路量化总结发布表详情")
    @GetMapping("/{id}")
    public Result<LoopSummaryPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(loopSummaryPublishService.getById(id), LoopSummaryPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(loopSummaryPublishService.removeByIds(ids));
    }


}

