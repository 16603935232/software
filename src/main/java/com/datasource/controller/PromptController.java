package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.PromptDTO;
import com.datasource.vo.PromptVO;
import com.datasource.entity.Prompt;
import com.datasource.utils.QueryUtil;
import com.datasource.service.IPromptService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【不再提示表】控制器层
 *
 * @author shangml
 * @date 2023-01-31
 */
@Slf4j
@Api(tags = {"【不再提示表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/prompt")
public class PromptController {

    private final IPromptService  promptService;

    @ApiOperation(value = "不再提示表列表查询")
    @PostMapping("/list")
    public Result<List<PromptVO>> list(@RequestBody PromptDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(PromptVO.class,promptService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, Prompt.class)))));
    }

    @ApiOperation(value = "不再提示表分页查询")
    @PostMapping("/page")
    public Result<Page<PromptVO>> page(@RequestBody PromptDTO dto) {
        Page<Prompt> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<Prompt> result = promptService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, Prompt.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(PromptVO.class, result));
    }

    @ApiOperation(value = "不再提示表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody PromptDTO dto) {
        Prompt entity = BeanUtil.copyProperties(dto, Prompt.class);
        promptService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "不再提示表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody PromptDTO dto) {
        Prompt entity = BeanUtil.copyProperties(dto, Prompt.class);
        return Result.ok(promptService.save(entity));
    }

    @ApiOperation(value = "不再提示表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody PromptDTO dto) {
        Prompt entity = BeanUtil.copyProperties(dto, Prompt.class);
        return Result.ok(promptService.updateById(entity));
    }

    @ApiOperation(value = "不再提示表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(promptService.removeById(id));
    }

    @ApiOperation(value = "不再提示表详情")
    @GetMapping("/{id}")
    public Result<PromptVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(promptService.getById(id), PromptVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(promptService.removeByIds(ids));
    }


}

