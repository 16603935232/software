package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.DataPushDTO;
import com.datasource.vo.DataPushVO;
import com.datasource.entity.DataPush;
import com.datasource.utils.QueryUtil;
import com.datasource.service.IDataPushService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【数据更新情况推送表】控制器层
 *
 * @author shangml
 * @date 2023-12-13
 */
@Slf4j
@Api(tags = {"【数据更新情况推送表】接口"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/data-push")
public class DataPushController {

    private final IDataPushService  dataPushService;

    @ApiOperation(value = "数据更新情况推送表列表查询")
    @PostMapping("/list")
    public Result<List<DataPushVO>> list(@RequestBody DataPushDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(DataPushVO.class,dataPushService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, DataPush.class)))));
    }

    @ApiOperation(value = "数据更新情况推送表分页查询")
    @PostMapping("/page")
    public Result<Page<DataPushVO>> page(@RequestBody DataPushDTO dto) {
        Page<DataPush> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<DataPush> result = dataPushService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, DataPush.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(DataPushVO.class, result));
    }

    @ApiOperation(value = "数据更新情况推送表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody DataPushDTO dto) {
        DataPush entity = BeanUtil.copyProperties(dto, DataPush.class);
        dataPushService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "数据更新情况推送表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody DataPushDTO dto) {
        DataPush entity = BeanUtil.copyProperties(dto, DataPush.class);
        return Result.ok(dataPushService.save(entity));
    }

    @ApiOperation(value = "数据更新情况推送表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody DataPushDTO dto) {
        DataPush entity = BeanUtil.copyProperties(dto, DataPush.class);
        return Result.ok(dataPushService.updateById(entity));
    }

    @ApiOperation(value = "数据更新情况推送表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(dataPushService.removeById(id));
    }

    @ApiOperation(value = "数据更新情况推送表详情")
    @GetMapping("/{id}")
    public Result<DataPushVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(dataPushService.getById(id), DataPushVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(dataPushService.removeByIds(ids));
    }


}

