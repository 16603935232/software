package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.InfoSourceStatisticsDTO;
import com.datasource.vo.InfoSourceStatisticsVO;
import com.datasource.entity.InfoSourceStatistics;
import com.datasource.utils.QueryUtil;
import com.datasource.service.IInfoSourceStatisticsService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【信源数据统计】控制器层
 *
 * @author shangml
 * @date 2023-12-06
 */
@Slf4j
@Api(tags = {"【信源数据统计】接口"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/info-source-statistics")
public class InfoSourceStatisticsController {

    private final IInfoSourceStatisticsService  infoSourceStatisticsService;

    @ApiOperation(value = "信源数据统计列表查询")
    @PostMapping("/list")
    public Result<List<InfoSourceStatisticsVO>> list(@RequestBody InfoSourceStatisticsDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(InfoSourceStatisticsVO.class,infoSourceStatisticsService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InfoSourceStatistics.class)))));
    }

    @ApiOperation(value = "信源数据统计分页查询")
    @PostMapping("/page")
    public Result<Page<InfoSourceStatisticsVO>> page(@RequestBody InfoSourceStatisticsDTO dto) {
        Page<InfoSourceStatistics> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InfoSourceStatistics> result = infoSourceStatisticsService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InfoSourceStatistics.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(InfoSourceStatisticsVO.class, result));
    }

    @ApiOperation(value = "信源数据统计添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InfoSourceStatisticsDTO dto) {
        InfoSourceStatistics entity = BeanUtil.copyProperties(dto, InfoSourceStatistics.class);
        infoSourceStatisticsService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "信源数据统计添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InfoSourceStatisticsDTO dto) {
        InfoSourceStatistics entity = BeanUtil.copyProperties(dto, InfoSourceStatistics.class);
        return Result.ok(infoSourceStatisticsService.save(entity));
    }

    @ApiOperation(value = "信源数据统计更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InfoSourceStatisticsDTO dto) {
        InfoSourceStatistics entity = BeanUtil.copyProperties(dto, InfoSourceStatistics.class);
        return Result.ok(infoSourceStatisticsService.updateById(entity));
    }

    @ApiOperation(value = "信源数据统计删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(infoSourceStatisticsService.removeById(id));
    }

    @ApiOperation(value = "信源数据统计详情")
    @GetMapping("/{id}")
    public Result<InfoSourceStatisticsVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(infoSourceStatisticsService.getById(id), InfoSourceStatisticsVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(infoSourceStatisticsService.removeByIds(ids));
    }


}

