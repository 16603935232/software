package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.WarningIndicatorsFeaturePublishDTO;
import com.replay.vo.WarningIndicatorsFeaturePublishVO;
import com.replay.entity.WarningIndicatorsFeaturePublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IWarningIndicatorsFeaturePublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预警差距、威胁发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预警差距、威胁发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/warning-indicators-feature-publish")
public class WarningIndicatorsFeaturePublishController {

    private final IWarningIndicatorsFeaturePublishService  warningIndicatorsFeaturePublishService;

    @ApiOperation(value = "预警差距、威胁发布表列表查询")
    @PostMapping("/list")
    public Result<List<WarningIndicatorsFeaturePublishVO>> list(@RequestBody WarningIndicatorsFeaturePublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(WarningIndicatorsFeaturePublishVO.class,warningIndicatorsFeaturePublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, WarningIndicatorsFeaturePublish.class)))));
    }

    @ApiOperation(value = "预警差距、威胁发布表分页查询")
    @PostMapping("/page")
    public Result<Page<WarningIndicatorsFeaturePublishVO>> page(@RequestBody WarningIndicatorsFeaturePublishDTO dto) {
        Page<WarningIndicatorsFeaturePublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<WarningIndicatorsFeaturePublish> result = warningIndicatorsFeaturePublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, WarningIndicatorsFeaturePublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(WarningIndicatorsFeaturePublishVO.class, result));
    }

    @ApiOperation(value = "预警差距、威胁发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody WarningIndicatorsFeaturePublishDTO dto) {
        WarningIndicatorsFeaturePublish entity = BeanUtil.copyProperties(dto, WarningIndicatorsFeaturePublish.class);
        warningIndicatorsFeaturePublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预警差距、威胁发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody WarningIndicatorsFeaturePublishDTO dto) {
        WarningIndicatorsFeaturePublish entity = BeanUtil.copyProperties(dto, WarningIndicatorsFeaturePublish.class);
        return Result.ok(warningIndicatorsFeaturePublishService.save(entity));
    }

    @ApiOperation(value = "预警差距、威胁发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody WarningIndicatorsFeaturePublishDTO dto) {
        WarningIndicatorsFeaturePublish entity = BeanUtil.copyProperties(dto, WarningIndicatorsFeaturePublish.class);
        return Result.ok(warningIndicatorsFeaturePublishService.updateById(entity));
    }

    @ApiOperation(value = "预警差距、威胁发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(warningIndicatorsFeaturePublishService.removeById(id));
    }

    @ApiOperation(value = "预警差距、威胁发布表详情")
    @GetMapping("/{id}")
    public Result<WarningIndicatorsFeaturePublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(warningIndicatorsFeaturePublishService.getById(id), WarningIndicatorsFeaturePublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(warningIndicatorsFeaturePublishService.removeByIds(ids));
    }


}

