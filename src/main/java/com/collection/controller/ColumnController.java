package com.collection.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.collection.result.Result;

import com.collection.dto.ColumnDTO;
import com.collection.vo.ColumnVO;
import com.collection.entity.Column;
import com.collection.utils.QueryUtil;
import com.collection.service.IColumnService;
import com.collection.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【栏目表】控制器层
 *
 * @author lzy
 * @date 2023-04-06
 */
@Slf4j
@Api(tags = {"【栏目表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/column")
public class ColumnController {

    private final IColumnService  columnService;

    @ApiOperation(value = "栏目表列表查询")
    @PostMapping("/list")
    public Result<List<ColumnVO>> list(@RequestBody ColumnDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ColumnVO.class,columnService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, Column.class)))));
    }

    @ApiOperation(value = "栏目表分页查询")
    @PostMapping("/page")
    public Result<Page<ColumnVO>> page(@RequestBody ColumnDTO dto) {
        Page<Column> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<Column> result = columnService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, Column.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ColumnVO.class, result));
    }

    @ApiOperation(value = "栏目表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ColumnDTO dto) {
        Column entity = BeanUtil.copyProperties(dto, Column.class);
        columnService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "栏目表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ColumnDTO dto) {
        Column entity = BeanUtil.copyProperties(dto, Column.class);
        return Result.ok(columnService.save(entity));
    }

    @ApiOperation(value = "栏目表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ColumnDTO dto) {
        Column entity = BeanUtil.copyProperties(dto, Column.class);
        return Result.ok(columnService.updateById(entity));
    }

    @ApiOperation(value = "栏目表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(columnService.removeById(id));
    }

    @ApiOperation(value = "栏目表详情")
    @GetMapping("/{id}")
    public Result<ColumnVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(columnService.getById(id), ColumnVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(columnService.removeByIds(ids));
    }


}

