package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.ManuscriptResponsibleEditorDTO;
import com.content.vo.ManuscriptResponsibleEditorVO;
import com.content.entity.ManuscriptResponsibleEditor;
import com.content.utils.QueryUtil;
import com.content.service.IManuscriptResponsibleEditorService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【稿件责编表】控制器层
 *
 * @author sml
 * @date 2023-07-28
 */
@Slf4j
@Api(tags = {"【稿件责编表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/manuscript-responsible-editor")
public class ManuscriptResponsibleEditorController {

    private final IManuscriptResponsibleEditorService  manuscriptResponsibleEditorService;

    @ApiOperation(value = "稿件责编表列表查询")
    @PostMapping("/list")
    public Result<List<ManuscriptResponsibleEditorVO>> list(@RequestBody ManuscriptResponsibleEditorDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ManuscriptResponsibleEditorVO.class,manuscriptResponsibleEditorService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, ManuscriptResponsibleEditor.class)))));
    }

    @ApiOperation(value = "稿件责编表分页查询")
    @PostMapping("/page")
    public Result<Page<ManuscriptResponsibleEditorVO>> page(@RequestBody ManuscriptResponsibleEditorDTO dto) {
        Page<ManuscriptResponsibleEditor> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<ManuscriptResponsibleEditor> result = manuscriptResponsibleEditorService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, ManuscriptResponsibleEditor.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ManuscriptResponsibleEditorVO.class, result));
    }

    @ApiOperation(value = "稿件责编表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ManuscriptResponsibleEditorDTO dto) {
        ManuscriptResponsibleEditor entity = BeanUtil.copyProperties(dto, ManuscriptResponsibleEditor.class);
        manuscriptResponsibleEditorService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "稿件责编表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ManuscriptResponsibleEditorDTO dto) {
        ManuscriptResponsibleEditor entity = BeanUtil.copyProperties(dto, ManuscriptResponsibleEditor.class);
        return Result.ok(manuscriptResponsibleEditorService.save(entity));
    }

    @ApiOperation(value = "稿件责编表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ManuscriptResponsibleEditorDTO dto) {
        ManuscriptResponsibleEditor entity = BeanUtil.copyProperties(dto, ManuscriptResponsibleEditor.class);
        return Result.ok(manuscriptResponsibleEditorService.updateById(entity));
    }

    @ApiOperation(value = "稿件责编表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(manuscriptResponsibleEditorService.removeById(id));
    }

    @ApiOperation(value = "稿件责编表详情")
    @GetMapping("/{id}")
    public Result<ManuscriptResponsibleEditorVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(manuscriptResponsibleEditorService.getById(id), ManuscriptResponsibleEditorVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(manuscriptResponsibleEditorService.removeByIds(ids));
    }


}

