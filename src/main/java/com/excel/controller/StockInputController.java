package com.excel.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.excel.result.Result;

import com.excel.dto.StockInputDTO;
import com.excel.vo.StockInputVO;
import com.excel.entity.StockInput;
import com.excel.utils.QueryUtil;
import com.excel.service.IStockInputService;
import com.excel.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【新增产业能耗设定输入表】控制器层
 *
 * @author shangml
 * @date 2023-01-15
 */
@Slf4j
@Api(tags = {"【新增产业能耗设定输入表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/stock-input")
public class StockInputController {

    private final IStockInputService  stockInputService;

    @ApiOperation(value = "新增产业能耗设定输入表列表查询")
    @PostMapping("/list")
    public Result<List<StockInputVO>> list(@RequestBody StockInputDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(StockInputVO.class,stockInputService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, StockInput.class)))));
    }

    @ApiOperation(value = "新增产业能耗设定输入表分页查询")
    @PostMapping("/page")
    public Result<Page<StockInputVO>> page(@RequestBody StockInputDTO dto) {
        Page<StockInput> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<StockInput> result = stockInputService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, StockInput.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(StockInputVO.class, result));
    }

    @ApiOperation(value = "新增产业能耗设定输入表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody StockInputDTO dto) {
        StockInput entity = BeanUtil.copyProperties(dto, StockInput.class);
        stockInputService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "新增产业能耗设定输入表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody StockInputDTO dto) {
        StockInput entity = BeanUtil.copyProperties(dto, StockInput.class);
        return Result.ok(stockInputService.save(entity));
    }

    @ApiOperation(value = "新增产业能耗设定输入表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody StockInputDTO dto) {
        StockInput entity = BeanUtil.copyProperties(dto, StockInput.class);
        return Result.ok(stockInputService.updateById(entity));
    }

    @ApiOperation(value = "新增产业能耗设定输入表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(stockInputService.removeById(id));
    }

    @ApiOperation(value = "新增产业能耗设定输入表详情")
    @GetMapping("/{id}")
    public Result<StockInputVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(stockInputService.getById(id), StockInputVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(stockInputService.removeByIds(ids));
    }


}

