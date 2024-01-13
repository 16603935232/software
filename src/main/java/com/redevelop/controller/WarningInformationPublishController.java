package com.redevelop.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redevelop.result.Result;

import com.redevelop.dto.WarningInformationPublishDTO;
import com.redevelop.vo.WarningInformationPublishVO;
import com.redevelop.entity.WarningInformationPublish;
import com.redevelop.utils.QueryUtil;
import com.redevelop.service.IWarningInformationPublishService;
import com.redevelop.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预警信息发布表】控制器层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Api(tags = {"【预警信息发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/warning-information-publish")
public class WarningInformationPublishController {

    private final IWarningInformationPublishService  warningInformationPublishService;

    @ApiOperation(value = "预警信息发布表列表查询")
    @PostMapping("/list")
    public Result<List<WarningInformationPublishVO>> list(@RequestBody WarningInformationPublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(WarningInformationPublishVO.class,warningInformationPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, WarningInformationPublish.class)))));
    }

    @ApiOperation(value = "预警信息发布表分页查询")
    @PostMapping("/page")
    public Result<Page<WarningInformationPublishVO>> page(@RequestBody WarningInformationPublishDTO dto) {
        Page<WarningInformationPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<WarningInformationPublish> result = warningInformationPublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, WarningInformationPublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(WarningInformationPublishVO.class, result));
    }

    @ApiOperation(value = "预警信息发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody WarningInformationPublishDTO dto) {
        WarningInformationPublish entity = BeanUtil.copyProperties(dto, WarningInformationPublish.class);
        warningInformationPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预警信息发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody WarningInformationPublishDTO dto) {
        WarningInformationPublish entity = BeanUtil.copyProperties(dto, WarningInformationPublish.class);
        return Result.ok(warningInformationPublishService.save(entity));
    }

    @ApiOperation(value = "预警信息发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody WarningInformationPublishDTO dto) {
        WarningInformationPublish entity = BeanUtil.copyProperties(dto, WarningInformationPublish.class);
        return Result.ok(warningInformationPublishService.updateById(entity));
    }

    @ApiOperation(value = "预警信息发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(warningInformationPublishService.removeById(id));
    }

    @ApiOperation(value = "预警信息发布表详情")
    @GetMapping("/{id}")
    public Result<WarningInformationPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(warningInformationPublishService.getById(id), WarningInformationPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(warningInformationPublishService.removeByIds(ids));
    }


}

