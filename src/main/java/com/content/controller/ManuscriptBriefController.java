package com.content-backend.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content-backend.result.Result;

import com.content-backend.dto.ManuscriptBriefDTO;
import com.content-backend.vo.ManuscriptBriefVO;
import com.content-backend.entity.ManuscriptBrief;
import com.content-backend.utils.QueryUtil;
import com.content-backend.service.IManuscriptBriefService;
import com.content-backend.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【稿件简表】控制器层
 *
 * @author sml
 * @date 2023-07-28
 */
@Slf4j
@Api(tags = {"【稿件简表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/manuscript-brief")
public class ManuscriptBriefController {

    private final IManuscriptBriefService  manuscriptBriefService;

    @ApiOperation(value = "稿件简表列表查询")
    @PostMapping("/list")
    public Result<List<ManuscriptBriefVO>> list(@RequestBody ManuscriptBriefDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ManuscriptBriefVO.class,manuscriptBriefService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, ManuscriptBrief.class)))));
    }

    @ApiOperation(value = "稿件简表分页查询")
    @PostMapping("/page")
    public Result<Page<ManuscriptBriefVO>> page(@RequestBody ManuscriptBriefDTO dto) {
        Page<ManuscriptBrief> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<ManuscriptBrief> result = manuscriptBriefService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, ManuscriptBrief.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ManuscriptBriefVO.class, result));
    }

    @ApiOperation(value = "稿件简表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ManuscriptBriefDTO dto) {
        ManuscriptBrief entity = BeanUtil.copyProperties(dto, ManuscriptBrief.class);
        manuscriptBriefService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "稿件简表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ManuscriptBriefDTO dto) {
        ManuscriptBrief entity = BeanUtil.copyProperties(dto, ManuscriptBrief.class);
        return Result.ok(manuscriptBriefService.save(entity));
    }

    @ApiOperation(value = "稿件简表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ManuscriptBriefDTO dto) {
        ManuscriptBrief entity = BeanUtil.copyProperties(dto, ManuscriptBrief.class);
        return Result.ok(manuscriptBriefService.updateById(entity));
    }

    @ApiOperation(value = "稿件简表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(manuscriptBriefService.removeById(id));
    }

    @ApiOperation(value = "稿件简表详情")
    @GetMapping("/{id}")
    public Result<ManuscriptBriefVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(manuscriptBriefService.getById(id), ManuscriptBriefVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(manuscriptBriefService.removeByIds(ids));
    }


}

