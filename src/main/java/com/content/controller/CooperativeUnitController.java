package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.CooperativeUnitDTO;
import com.content.vo.CooperativeUnitVO;
import com.content.entity.CooperativeUnit;
import com.content.utils.QueryUtil;
import com.content.service.ICooperativeUnitService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【合作单位表】控制器层
 *
 * @author sml
 * @date 2023-08-03
 */
@Slf4j
@Api(tags = {"【合作单位表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/cooperative-unit")
public class CooperativeUnitController {

    private final ICooperativeUnitService  cooperativeUnitService;

    @ApiOperation(value = "合作单位表列表查询")
    @PostMapping("/list")
    public Result<List<CooperativeUnitVO>> list(@RequestBody CooperativeUnitDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(CooperativeUnitVO.class,cooperativeUnitService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, CooperativeUnit.class)))));
    }

    @ApiOperation(value = "合作单位表分页查询")
    @PostMapping("/page")
    public Result<Page<CooperativeUnitVO>> page(@RequestBody CooperativeUnitDTO dto) {
        Page<CooperativeUnit> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<CooperativeUnit> result = cooperativeUnitService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, CooperativeUnit.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(CooperativeUnitVO.class, result));
    }

    @ApiOperation(value = "合作单位表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody CooperativeUnitDTO dto) {
        CooperativeUnit entity = BeanUtil.copyProperties(dto, CooperativeUnit.class);
        cooperativeUnitService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "合作单位表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody CooperativeUnitDTO dto) {
        CooperativeUnit entity = BeanUtil.copyProperties(dto, CooperativeUnit.class);
        return Result.ok(cooperativeUnitService.save(entity));
    }

    @ApiOperation(value = "合作单位表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody CooperativeUnitDTO dto) {
        CooperativeUnit entity = BeanUtil.copyProperties(dto, CooperativeUnit.class);
        return Result.ok(cooperativeUnitService.updateById(entity));
    }

    @ApiOperation(value = "合作单位表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(cooperativeUnitService.removeById(id));
    }

    @ApiOperation(value = "合作单位表详情")
    @GetMapping("/{id}")
    public Result<CooperativeUnitVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(cooperativeUnitService.getById(id), CooperativeUnitVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(cooperativeUnitService.removeByIds(ids));
    }


}

