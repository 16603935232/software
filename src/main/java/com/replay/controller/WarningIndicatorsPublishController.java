package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.WarningIndicatorsPublishDTO;
import com.replay.vo.WarningIndicatorsPublishVO;
import com.replay.entity.WarningIndicatorsPublish;
import com.replay.utils.QueryUtil;
import com.replay.service.IWarningIndicatorsPublishService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预警指标体系发布表】控制器层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Slf4j
@Api(tags = {"【预警指标体系发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/warning-indicators-publish")
public class WarningIndicatorsPublishController {

    private final IWarningIndicatorsPublishService  warningIndicatorsPublishService;

    @ApiOperation(value = "预警指标体系发布表列表查询")
    @PostMapping("/list")
    public Result<List<WarningIndicatorsPublishVO>> list(@RequestBody WarningIndicatorsPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(WarningIndicatorsPublishVO.class,warningIndicatorsPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, WarningIndicatorsPublish.class)))));
    }

    @ApiOperation(value = "预警指标体系发布表分页查询")
    @PostMapping("/page")
    public Result<Page<WarningIndicatorsPublishVO>> page(@RequestBody WarningIndicatorsPublishDTO dto) {
        Page<WarningIndicatorsPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<WarningIndicatorsPublish> result = warningIndicatorsPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, WarningIndicatorsPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(WarningIndicatorsPublishVO.class, result));
    }

    @ApiOperation(value = "预警指标体系发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody WarningIndicatorsPublishDTO dto) {
        WarningIndicatorsPublish entity = BeanUtil.copyProperties(dto, WarningIndicatorsPublish.class);
        warningIndicatorsPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预警指标体系发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody WarningIndicatorsPublishDTO dto) {
        WarningIndicatorsPublish entity = BeanUtil.copyProperties(dto, WarningIndicatorsPublish.class);
        return Result.ok(warningIndicatorsPublishService.save(entity));
    }

    @ApiOperation(value = "预警指标体系发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody WarningIndicatorsPublishDTO dto) {
        WarningIndicatorsPublish entity = BeanUtil.copyProperties(dto, WarningIndicatorsPublish.class);
        return Result.ok(warningIndicatorsPublishService.updateById(entity));
    }

    @ApiOperation(value = "预警指标体系发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(warningIndicatorsPublishService.removeById(id));
    }

    @ApiOperation(value = "预警指标体系发布表详情")
    @GetMapping("/{id}")
    public Result<WarningIndicatorsPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(warningIndicatorsPublishService.getById(id), WarningIndicatorsPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(warningIndicatorsPublishService.removeByIds(ids));
    }


}

