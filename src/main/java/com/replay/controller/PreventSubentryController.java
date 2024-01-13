package com.replay.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay.result.Result;

import com.replay.dto.PreventSubentryDTO;
import com.replay.vo.PreventSubentryVO;
import com.replay.entity.PreventSubentry;
import com.replay.utils.QueryUtil;
import com.replay.service.IPreventSubentryService;
import com.replay.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【应对措施分项信息表】控制器层
 *
 * @author shangml
 * @date 2023-04-25
 */
@Slf4j
@Api(tags = {"【应对措施分项信息表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/prevent-subentry")
public class PreventSubentryController {

    private final IPreventSubentryService  preventSubentryService;

    @ApiOperation(value = "应对措施分项信息表列表查询")
    @PostMapping("/list")
    public Result<List<PreventSubentryVO>> list(@RequestBody PreventSubentryDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PreventSubentryVO.class,preventSubentryService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, PreventSubentry.class)))));
    }

    @ApiOperation(value = "应对措施分项信息表分页查询")
    @PostMapping("/page")
    public Result<Page<PreventSubentryVO>> page(@RequestBody PreventSubentryDTO dto) {
        Page<PreventSubentry> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<PreventSubentry> result = preventSubentryService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, PreventSubentry.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PreventSubentryVO.class, result));
    }

    @ApiOperation(value = "应对措施分项信息表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PreventSubentryDTO dto) {
        PreventSubentry entity = BeanUtil.copyProperties(dto, PreventSubentry.class);
        preventSubentryService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "应对措施分项信息表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PreventSubentryDTO dto) {
        PreventSubentry entity = BeanUtil.copyProperties(dto, PreventSubentry.class);
        return Result.ok(preventSubentryService.save(entity));
    }

    @ApiOperation(value = "应对措施分项信息表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PreventSubentryDTO dto) {
        PreventSubentry entity = BeanUtil.copyProperties(dto, PreventSubentry.class);
        return Result.ok(preventSubentryService.updateById(entity));
    }

    @ApiOperation(value = "应对措施分项信息表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(preventSubentryService.removeById(id));
    }

    @ApiOperation(value = "应对措施分项信息表详情")
    @GetMapping("/{id}")
    public Result<PreventSubentryVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(preventSubentryService.getById(id), PreventSubentryVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(preventSubentryService.removeByIds(ids));
    }


}

