package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.DemandAssessmentDTO;
import com.datasource.vo.DemandAssessmentVO;
import com.datasource.entity.DemandAssessment;
import com.datasource.utils.QueryUtil;
import com.datasource.service.IDemandAssessmentService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【需求单退回表】控制器层
 *
 * @author shangmingliang
 * @date 2023-01-04
 */
@Slf4j
@Api(tags = {"【需求单退回表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/demand-assessment")
public class DemandAssessmentController {

    private final IDemandAssessmentService  demandAssessmentService;

    @ApiOperation(value = "需求单退回表列表查询")
    @PostMapping("/list")
    public Result<List<DemandAssessmentVO>> list(@RequestBody DemandAssessmentDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(DemandAssessmentVO.class,demandAssessmentService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, DemandAssessment.class)))));
    }

    @ApiOperation(value = "需求单退回表分页查询")
    @PostMapping("/page")
    public Result<Page<DemandAssessmentVO>> page(@RequestBody DemandAssessmentDTO dto) {
        Page<DemandAssessment> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<DemandAssessment> result = demandAssessmentService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, DemandAssessment.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(DemandAssessmentVO.class, result));
    }

    @ApiOperation(value = "需求单退回表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody DemandAssessmentDTO dto) {
        DemandAssessment entity = BeanUtil.copyProperties(dto, DemandAssessment.class);
        demandAssessmentService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "需求单退回表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody DemandAssessmentDTO dto) {
        DemandAssessment entity = BeanUtil.copyProperties(dto, DemandAssessment.class);
        return Result.ok(demandAssessmentService.save(entity));
    }

    @ApiOperation(value = "需求单退回表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody DemandAssessmentDTO dto) {
        DemandAssessment entity = BeanUtil.copyProperties(dto, DemandAssessment.class);
        return Result.ok(demandAssessmentService.updateById(entity));
    }

    @ApiOperation(value = "需求单退回表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(demandAssessmentService.removeById(id));
    }

    @ApiOperation(value = "需求单退回表详情")
    @GetMapping("/{id}")
    public Result<DemandAssessmentVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(demandAssessmentService.getById(id), DemandAssessmentVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(demandAssessmentService.removeByIds(ids));
    }


}

