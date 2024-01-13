package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.ManuscriptStatusDTO;
import com.content.vo.ManuscriptStatusVO;
import com.content.entity.ManuscriptStatus;
import com.content.utils.QueryUtil;
import com.content.service.IManuscriptStatusService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【稿件状态表】控制器层
 *
 * @author sml
 * @date 2023-07-28
 */
@Slf4j
@Api(tags = {"【稿件状态表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/manuscript-status")
public class ManuscriptStatusController {

    private final IManuscriptStatusService  manuscriptStatusService;

    @ApiOperation(value = "稿件状态表列表查询")
    @PostMapping("/list")
    public Result<List<ManuscriptStatusVO>> list(@RequestBody ManuscriptStatusDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ManuscriptStatusVO.class,manuscriptStatusService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, ManuscriptStatus.class)))));
    }

    @ApiOperation(value = "稿件状态表分页查询")
    @PostMapping("/page")
    public Result<Page<ManuscriptStatusVO>> page(@RequestBody ManuscriptStatusDTO dto) {
        Page<ManuscriptStatus> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<ManuscriptStatus> result = manuscriptStatusService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, ManuscriptStatus.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ManuscriptStatusVO.class, result));
    }

    @ApiOperation(value = "稿件状态表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ManuscriptStatusDTO dto) {
        ManuscriptStatus entity = BeanUtil.copyProperties(dto, ManuscriptStatus.class);
        manuscriptStatusService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "稿件状态表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ManuscriptStatusDTO dto) {
        ManuscriptStatus entity = BeanUtil.copyProperties(dto, ManuscriptStatus.class);
        return Result.ok(manuscriptStatusService.save(entity));
    }

    @ApiOperation(value = "稿件状态表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ManuscriptStatusDTO dto) {
        ManuscriptStatus entity = BeanUtil.copyProperties(dto, ManuscriptStatus.class);
        return Result.ok(manuscriptStatusService.updateById(entity));
    }

    @ApiOperation(value = "稿件状态表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(manuscriptStatusService.removeById(id));
    }

    @ApiOperation(value = "稿件状态表详情")
    @GetMapping("/{id}")
    public Result<ManuscriptStatusVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(manuscriptStatusService.getById(id), ManuscriptStatusVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(manuscriptStatusService.removeByIds(ids));
    }


}

