package com.redevelop.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redevelop.result.Result;

import com.redevelop.dto.WarningSubentryDTO;
import com.redevelop.vo.WarningSubentryVO;
import com.redevelop.entity.WarningSubentry;
import com.redevelop.utils.QueryUtil;
import com.redevelop.service.IWarningSubentryService;
import com.redevelop.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预警分项指标表】控制器层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Api(tags = {"【预警分项指标表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/warning-subentry")
public class WarningSubentryController {

    private final IWarningSubentryService  warningSubentryService;

    @ApiOperation(value = "预警分项指标表列表查询")
    @PostMapping("/list")
    public Result<List<WarningSubentryVO>> list(@RequestBody WarningSubentryDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(WarningSubentryVO.class,warningSubentryService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, WarningSubentry.class)))));
    }

    @ApiOperation(value = "预警分项指标表分页查询")
    @PostMapping("/page")
    public Result<Page<WarningSubentryVO>> page(@RequestBody WarningSubentryDTO dto) {
        Page<WarningSubentry> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<WarningSubentry> result = warningSubentryService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, WarningSubentry.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(WarningSubentryVO.class, result));
    }

    @ApiOperation(value = "预警分项指标表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody WarningSubentryDTO dto) {
        WarningSubentry entity = BeanUtil.copyProperties(dto, WarningSubentry.class);
        warningSubentryService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预警分项指标表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody WarningSubentryDTO dto) {
        WarningSubentry entity = BeanUtil.copyProperties(dto, WarningSubentry.class);
        return Result.ok(warningSubentryService.save(entity));
    }

    @ApiOperation(value = "预警分项指标表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody WarningSubentryDTO dto) {
        WarningSubentry entity = BeanUtil.copyProperties(dto, WarningSubentry.class);
        return Result.ok(warningSubentryService.updateById(entity));
    }

    @ApiOperation(value = "预警分项指标表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(warningSubentryService.removeById(id));
    }

    @ApiOperation(value = "预警分项指标表详情")
    @GetMapping("/{id}")
    public Result<WarningSubentryVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(warningSubentryService.getById(id), WarningSubentryVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(warningSubentryService.removeByIds(ids));
    }


}

