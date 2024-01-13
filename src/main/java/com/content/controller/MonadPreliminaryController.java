package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.MonadPreliminaryDTO;
import com.content.vo.MonadPreliminaryVO;
import com.content.entity.MonadPreliminary;
import com.content.utils.QueryUtil;
import com.content.service.IMonadPreliminaryService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【初审/复审/终审报告单】控制器层
 *
 * @author sml
 * @date 2023-08-01
 */
@Slf4j
@Api(tags = {"【初审/复审/终审报告单】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/monad-preliminary")
public class MonadPreliminaryController {

    private final IMonadPreliminaryService  monadPreliminaryService;

    @ApiOperation(value = "初审/复审/终审报告单列表查询")
    @PostMapping("/list")
    public Result<List<MonadPreliminaryVO>> list(@RequestBody MonadPreliminaryDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MonadPreliminaryVO.class,monadPreliminaryService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MonadPreliminary.class)))));
    }

    @ApiOperation(value = "初审/复审/终审报告单分页查询")
    @PostMapping("/page")
    public Result<Page<MonadPreliminaryVO>> page(@RequestBody MonadPreliminaryDTO dto) {
        Page<MonadPreliminary> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MonadPreliminary> result = monadPreliminaryService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MonadPreliminary.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MonadPreliminaryVO.class, result));
    }

    @ApiOperation(value = "初审/复审/终审报告单添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MonadPreliminaryDTO dto) {
        MonadPreliminary entity = BeanUtil.copyProperties(dto, MonadPreliminary.class);
        monadPreliminaryService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "初审/复审/终审报告单添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MonadPreliminaryDTO dto) {
        MonadPreliminary entity = BeanUtil.copyProperties(dto, MonadPreliminary.class);
        return Result.ok(monadPreliminaryService.save(entity));
    }

    @ApiOperation(value = "初审/复审/终审报告单更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MonadPreliminaryDTO dto) {
        MonadPreliminary entity = BeanUtil.copyProperties(dto, MonadPreliminary.class);
        return Result.ok(monadPreliminaryService.updateById(entity));
    }

    @ApiOperation(value = "初审/复审/终审报告单删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(monadPreliminaryService.removeById(id));
    }

    @ApiOperation(value = "初审/复审/终审报告单详情")
    @GetMapping("/{id}")
    public Result<MonadPreliminaryVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(monadPreliminaryService.getById(id), MonadPreliminaryVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(monadPreliminaryService.removeByIds(ids));
    }


}

