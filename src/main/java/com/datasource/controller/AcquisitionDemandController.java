package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.AcquisitionDemandDTO;
import com.datasource.vo.AcquisitionDemandVO;
import com.datasource.entity.AcquisitionDemand;
import com.datasource.utils.QueryUtil;
import com.datasource.service.IAcquisitionDemandService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【采集提需表】控制器层
 *
 * @author haoxiaoming
 * @date 2022-12-21
 */
@Slf4j
@Api(tags = {"【采集提需表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/acquisition-demand")
public class AcquisitionDemandController {

    private final IAcquisitionDemandService  acquisitionDemandService;

    @ApiOperation(value = "采集提需表列表查询")
    @PostMapping("/list")
    public Result<List<AcquisitionDemandVO>> list(@RequestBody AcquisitionDemandDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(AcquisitionDemandVO.class,acquisitionDemandService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, AcquisitionDemand.class)))));
    }

    @ApiOperation(value = "采集提需表分页查询")
    @PostMapping("/page")
    public Result<Page<AcquisitionDemandVO>> page(@RequestBody AcquisitionDemandDTO dto) {
        Page<AcquisitionDemand> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<AcquisitionDemand> result = acquisitionDemandService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, AcquisitionDemand.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(AcquisitionDemandVO.class, result));
    }

    @ApiOperation(value = "采集提需表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody AcquisitionDemandDTO dto) {
        AcquisitionDemand entity = BeanUtil.copyProperties(dto, AcquisitionDemand.class);
        acquisitionDemandService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "采集提需表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody AcquisitionDemandDTO dto) {
        AcquisitionDemand entity = BeanUtil.copyProperties(dto, AcquisitionDemand.class);
        return Result.ok(acquisitionDemandService.save(entity));
    }

    @ApiOperation(value = "采集提需表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody AcquisitionDemandDTO dto) {
        AcquisitionDemand entity = BeanUtil.copyProperties(dto, AcquisitionDemand.class);
        return Result.ok(acquisitionDemandService.updateById(entity));
    }

    @ApiOperation(value = "采集提需表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(acquisitionDemandService.removeById(id));
    }

    @ApiOperation(value = "采集提需表详情")
    @GetMapping("/{id}")
    public Result<AcquisitionDemandVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(acquisitionDemandService.getById(id), AcquisitionDemandVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(acquisitionDemandService.removeByIds(ids));
    }


}

