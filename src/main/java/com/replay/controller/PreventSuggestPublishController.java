package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.PreventSuggestPublishDTO;
import com.replay.vo.PreventSuggestPublishVO;
import com.replay.entity.PreventSuggestPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IPreventSuggestPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预防专家建议发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预防专家建议发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/prevent-suggest-publish")
public class PreventSuggestPublishController {

    private final IPreventSuggestPublishService  preventSuggestPublishService;

    @ApiOperation(value = "预防专家建议发布表列表查询")
    @PostMapping("/list")
    public Result<List<PreventSuggestPublishVO>> list(@RequestBody PreventSuggestPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PreventSuggestPublishVO.class,preventSuggestPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, PreventSuggestPublish.class)))));
    }

    @ApiOperation(value = "预防专家建议发布表分页查询")
    @PostMapping("/page")
    public Result<Page<PreventSuggestPublishVO>> page(@RequestBody PreventSuggestPublishDTO dto) {
        Page<PreventSuggestPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<PreventSuggestPublish> result = preventSuggestPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, PreventSuggestPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PreventSuggestPublishVO.class, result));
    }

    @ApiOperation(value = "预防专家建议发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PreventSuggestPublishDTO dto) {
        PreventSuggestPublish entity = BeanUtil.copyProperties(dto, PreventSuggestPublish.class);
        preventSuggestPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预防专家建议发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PreventSuggestPublishDTO dto) {
        PreventSuggestPublish entity = BeanUtil.copyProperties(dto, PreventSuggestPublish.class);
        return Result.ok(preventSuggestPublishService.save(entity));
    }

    @ApiOperation(value = "预防专家建议发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PreventSuggestPublishDTO dto) {
        PreventSuggestPublish entity = BeanUtil.copyProperties(dto, PreventSuggestPublish.class);
        return Result.ok(preventSuggestPublishService.updateById(entity));
    }

    @ApiOperation(value = "预防专家建议发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(preventSuggestPublishService.removeById(id));
    }

    @ApiOperation(value = "预防专家建议发布表详情")
    @GetMapping("/{id}")
    public Result<PreventSuggestPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(preventSuggestPublishService.getById(id), PreventSuggestPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(preventSuggestPublishService.removeByIds(ids));
    }


}

