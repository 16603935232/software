package com.excel.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.excel.result.Result;

import com.excel.dto.ModelOutputDTO;
import com.excel.vo.ModelOutputVO;
import com.excel.entity.ModelOutput;
import com.excel.utils.QueryUtil;
import com.excel.service.IModelOutputService;
import com.excel.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【模型输出表】控制器层
 *
 * @author shangml
 * @date 2023-01-15
 */
@Slf4j
@Api(tags = {"【模型输出表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/model-output")
public class ModelOutputController {

    private final IModelOutputService  modelOutputService;

    @ApiOperation(value = "模型输出表列表查询")
    @PostMapping("/list")
    public Result<List<ModelOutputVO>> list(@RequestBody ModelOutputDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ModelOutputVO.class,modelOutputService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, ModelOutput.class)))));
    }

    @ApiOperation(value = "模型输出表分页查询")
    @PostMapping("/page")
    public Result<Page<ModelOutputVO>> page(@RequestBody ModelOutputDTO dto) {
        Page<ModelOutput> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<ModelOutput> result = modelOutputService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, ModelOutput.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ModelOutputVO.class, result));
    }

    @ApiOperation(value = "模型输出表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ModelOutputDTO dto) {
        ModelOutput entity = BeanUtil.copyProperties(dto, ModelOutput.class);
        modelOutputService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "模型输出表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ModelOutputDTO dto) {
        ModelOutput entity = BeanUtil.copyProperties(dto, ModelOutput.class);
        return Result.ok(modelOutputService.save(entity));
    }

    @ApiOperation(value = "模型输出表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ModelOutputDTO dto) {
        ModelOutput entity = BeanUtil.copyProperties(dto, ModelOutput.class);
        return Result.ok(modelOutputService.updateById(entity));
    }

    @ApiOperation(value = "模型输出表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(modelOutputService.removeById(id));
    }

    @ApiOperation(value = "模型输出表详情")
    @GetMapping("/{id}")
    public Result<ModelOutputVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(modelOutputService.getById(id), ModelOutputVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(modelOutputService.removeByIds(ids));
    }


}

