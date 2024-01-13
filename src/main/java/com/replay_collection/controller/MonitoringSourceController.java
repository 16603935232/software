package com.replay_collection.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.replay_collection.result.Result;

import com.replay_collection.dto.MonitoringSourceDTO;
import com.replay_collection.vo.MonitoringSourceVO;
import com.replay_collection.entity.MonitoringSource;
import com.replay_collection.utils.QueryUtil;
import com.replay_collection.service.IMonitoringSourceService;
import com.replay_collection.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【监测源】控制器层
 *
 * @author sml
 * @date 2023-03-23
 */
@Slf4j
@Api(tags = {"【监测源】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/monitoring-source")
public class MonitoringSourceController {

    private final IMonitoringSourceService  monitoringSourceService;

    @ApiOperation(value = "监测源列表查询")
    @PostMapping("/list")
    public Result<List<MonitoringSourceVO>> list(@RequestBody MonitoringSourceDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MonitoringSourceVO.class,monitoringSourceService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MonitoringSource.class)))));
    }

    @ApiOperation(value = "监测源分页查询")
    @PostMapping("/page")
    public Result<Page<MonitoringSourceVO>> page(@RequestBody MonitoringSourceDTO dto) {
        Page<MonitoringSource> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MonitoringSource> result = monitoringSourceService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MonitoringSource.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MonitoringSourceVO.class, result));
    }

    @ApiOperation(value = "监测源添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MonitoringSourceDTO dto) {
        MonitoringSource entity = BeanUtil.copyProperties(dto, MonitoringSource.class);
        monitoringSourceService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "监测源添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MonitoringSourceDTO dto) {
        MonitoringSource entity = BeanUtil.copyProperties(dto, MonitoringSource.class);
        return Result.ok(monitoringSourceService.save(entity));
    }

    @ApiOperation(value = "监测源更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MonitoringSourceDTO dto) {
        MonitoringSource entity = BeanUtil.copyProperties(dto, MonitoringSource.class);
        return Result.ok(monitoringSourceService.updateById(entity));
    }

    @ApiOperation(value = "监测源删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(monitoringSourceService.removeById(id));
    }

    @ApiOperation(value = "监测源详情")
    @GetMapping("/{id}")
    public Result<MonitoringSourceVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(monitoringSourceService.getById(id), MonitoringSourceVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(monitoringSourceService.removeByIds(ids));
    }


}

