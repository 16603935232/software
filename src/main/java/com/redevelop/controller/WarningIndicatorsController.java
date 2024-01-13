package com.redevelop.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redevelop.result.Result;

import com.redevelop.dto.WarningIndicatorsDTO;
import com.redevelop.vo.WarningIndicatorsVO;
import com.redevelop.entity.WarningIndicators;
import com.redevelop.utils.QueryUtil;
import com.redevelop.service.IWarningIndicatorsService;
import com.redevelop.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预警指标体系表】控制器层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Api(tags = {"【预警指标体系表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/warning-indicators")
public class WarningIndicatorsController {

    private final IWarningIndicatorsService  warningIndicatorsService;

    @ApiOperation(value = "预警指标体系表列表查询")
    @PostMapping("/list")
    public Result<List<WarningIndicatorsVO>> list(@RequestBody WarningIndicatorsDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(WarningIndicatorsVO.class,warningIndicatorsService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, WarningIndicators.class)))));
    }

    @ApiOperation(value = "预警指标体系表分页查询")
    @PostMapping("/page")
    public Result<Page<WarningIndicatorsVO>> page(@RequestBody WarningIndicatorsDTO dto) {
        Page<WarningIndicators> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<WarningIndicators> result = warningIndicatorsService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, WarningIndicators.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(WarningIndicatorsVO.class, result));
    }

    @ApiOperation(value = "预警指标体系表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody WarningIndicatorsDTO dto) {
        WarningIndicators entity = BeanUtil.copyProperties(dto, WarningIndicators.class);
        warningIndicatorsService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预警指标体系表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody WarningIndicatorsDTO dto) {
        WarningIndicators entity = BeanUtil.copyProperties(dto, WarningIndicators.class);
        return Result.ok(warningIndicatorsService.save(entity));
    }

    @ApiOperation(value = "预警指标体系表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody WarningIndicatorsDTO dto) {
        WarningIndicators entity = BeanUtil.copyProperties(dto, WarningIndicators.class);
        return Result.ok(warningIndicatorsService.updateById(entity));
    }

    @ApiOperation(value = "预警指标体系表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(warningIndicatorsService.removeById(id));
    }

    @ApiOperation(value = "预警指标体系表详情")
    @GetMapping("/{id}")
    public Result<WarningIndicatorsVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(warningIndicatorsService.getById(id), WarningIndicatorsVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(warningIndicatorsService.removeByIds(ids));
    }


}

