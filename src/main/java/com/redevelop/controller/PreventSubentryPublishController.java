package com.redevelop.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redevelop.result.Result;

import com.redevelop.dto.PreventSubentryPublishDTO;
import com.redevelop.vo.PreventSubentryPublishVO;
import com.redevelop.entity.PreventSubentryPublish;
import com.redevelop.utils.QueryUtil;
import com.redevelop.service.IPreventSubentryPublishService;
import com.redevelop.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【应对措施分项信息发布表】控制器层
 *
 * @author shangml
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【应对措施分项信息发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/prevent-subentry-publish")
public class PreventSubentryPublishController {

    private final IPreventSubentryPublishService  preventSubentryPublishService;

    @ApiOperation(value = "应对措施分项信息发布表列表查询")
    @PostMapping("/list")
    public Result<List<PreventSubentryPublishVO>> list(@RequestBody PreventSubentryPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PreventSubentryPublishVO.class,preventSubentryPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, PreventSubentryPublish.class)))));
    }

    @ApiOperation(value = "应对措施分项信息发布表分页查询")
    @PostMapping("/page")
    public Result<Page<PreventSubentryPublishVO>> page(@RequestBody PreventSubentryPublishDTO dto) {
        Page<PreventSubentryPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<PreventSubentryPublish> result = preventSubentryPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, PreventSubentryPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PreventSubentryPublishVO.class, result));
    }

    @ApiOperation(value = "应对措施分项信息发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PreventSubentryPublishDTO dto) {
        PreventSubentryPublish entity = BeanUtil.copyProperties(dto, PreventSubentryPublish.class);
        preventSubentryPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "应对措施分项信息发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PreventSubentryPublishDTO dto) {
        PreventSubentryPublish entity = BeanUtil.copyProperties(dto, PreventSubentryPublish.class);
        return Result.ok(preventSubentryPublishService.save(entity));
    }

    @ApiOperation(value = "应对措施分项信息发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PreventSubentryPublishDTO dto) {
        PreventSubentryPublish entity = BeanUtil.copyProperties(dto, PreventSubentryPublish.class);
        return Result.ok(preventSubentryPublishService.updateById(entity));
    }

    @ApiOperation(value = "应对措施分项信息发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(preventSubentryPublishService.removeById(id));
    }

    @ApiOperation(value = "应对措施分项信息发布表详情")
    @GetMapping("/{id}")
    public Result<PreventSubentryPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(preventSubentryPublishService.getById(id), PreventSubentryPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(preventSubentryPublishService.removeByIds(ids));
    }


}

