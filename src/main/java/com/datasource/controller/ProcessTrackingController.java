package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.ProcessTrackingDTO;
import com.datasource.vo.ProcessTrackingVO;
import com.datasource.entity.ProcessTracking;
import com.datasource.utils.QueryUtil;
import com.datasource.service.IProcessTrackingService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【过程跟踪表】控制器层
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
@Slf4j
@Api(tags = {"【过程跟踪表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/process-tracking")
public class ProcessTrackingController {

    private final IProcessTrackingService  processTrackingService;

    @ApiOperation(value = "过程跟踪表列表查询")
    @PostMapping("/list")
    public Result<List<ProcessTrackingVO>> list(@RequestBody ProcessTrackingDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ProcessTrackingVO.class,processTrackingService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, ProcessTracking.class)))));
    }

    @ApiOperation(value = "过程跟踪表分页查询")
    @PostMapping("/page")
    public Result<Page<ProcessTrackingVO>> page(@RequestBody ProcessTrackingDTO dto) {
        Page<ProcessTracking> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<ProcessTracking> result = processTrackingService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, ProcessTracking.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ProcessTrackingVO.class, result));
    }

    @ApiOperation(value = "过程跟踪表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ProcessTrackingDTO dto) {
        ProcessTracking entity = BeanUtil.copyProperties(dto, ProcessTracking.class);
        processTrackingService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "过程跟踪表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ProcessTrackingDTO dto) {
        ProcessTracking entity = BeanUtil.copyProperties(dto, ProcessTracking.class);
        return Result.ok(processTrackingService.save(entity));
    }

    @ApiOperation(value = "过程跟踪表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ProcessTrackingDTO dto) {
        ProcessTracking entity = BeanUtil.copyProperties(dto, ProcessTracking.class);
        return Result.ok(processTrackingService.updateById(entity));
    }

    @ApiOperation(value = "过程跟踪表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(processTrackingService.removeById(id));
    }

    @ApiOperation(value = "过程跟踪表详情")
    @GetMapping("/{id}")
    public Result<ProcessTrackingVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(processTrackingService.getById(id), ProcessTrackingVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(processTrackingService.removeByIds(ids));
    }


}

