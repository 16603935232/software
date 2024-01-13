package com.excel.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.excel.result.Result;

import com.excel.dto.NewInputDTO;
import com.excel.vo.NewInputVO;
import com.excel.entity.NewInput;
import com.excel.utils.QueryUtil;
import com.excel.service.INewInputService;
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
@RequestMapping("/new-input")
public class NewInputController {

    private final INewInputService  newInputService;

    @ApiOperation(value = "新增产业能耗设定输入表列表查询")
    @PostMapping("/list")
    public Result<List<NewInputVO>> list(@RequestBody NewInputDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(NewInputVO.class,newInputService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, NewInput.class)))));
    }

    @ApiOperation(value = "新增产业能耗设定输入表分页查询")
    @PostMapping("/page")
    public Result<Page<NewInputVO>> page(@RequestBody NewInputDTO dto) {
        Page<NewInput> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<NewInput> result = newInputService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, NewInput.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(NewInputVO.class, result));
    }

    @ApiOperation(value = "新增产业能耗设定输入表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody NewInputDTO dto) {
        NewInput entity = BeanUtil.copyProperties(dto, NewInput.class);
        newInputService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "新增产业能耗设定输入表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody NewInputDTO dto) {
        NewInput entity = BeanUtil.copyProperties(dto, NewInput.class);
        return Result.ok(newInputService.save(entity));
    }

    @ApiOperation(value = "新增产业能耗设定输入表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody NewInputDTO dto) {
        NewInput entity = BeanUtil.copyProperties(dto, NewInput.class);
        return Result.ok(newInputService.updateById(entity));
    }

    @ApiOperation(value = "新增产业能耗设定输入表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(newInputService.removeById(id));
    }

    @ApiOperation(value = "新增产业能耗设定输入表详情")
    @GetMapping("/{id}")
    public Result<NewInputVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(newInputService.getById(id), NewInputVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(newInputService.removeByIds(ids));
    }


}

