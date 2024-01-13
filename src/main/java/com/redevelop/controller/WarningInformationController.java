package com.redevelop.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redevelop.result.Result;

import com.redevelop.dto.WarningInformationDTO;
import com.redevelop.vo.WarningInformationVO;
import com.redevelop.entity.WarningInformation;
import com.redevelop.utils.QueryUtil;
import com.redevelop.service.IWarningInformationService;
import com.redevelop.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【预警信息表】控制器层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Api(tags = {"【预警信息表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/warning-information")
public class WarningInformationController {

    private final IWarningInformationService  warningInformationService;

    @ApiOperation(value = "预警信息表列表查询")
    @PostMapping("/list")
    public Result<List<WarningInformationVO>> list(@RequestBody WarningInformationDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(WarningInformationVO.class,warningInformationService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, WarningInformation.class)))));
    }

    @ApiOperation(value = "预警信息表分页查询")
    @PostMapping("/page")
    public Result<Page<WarningInformationVO>> page(@RequestBody WarningInformationDTO dto) {
        Page<WarningInformation> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<WarningInformation> result = warningInformationService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, WarningInformation.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(WarningInformationVO.class, result));
    }

    @ApiOperation(value = "预警信息表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody WarningInformationDTO dto) {
        WarningInformation entity = BeanUtil.copyProperties(dto, WarningInformation.class);
        warningInformationService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "预警信息表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody WarningInformationDTO dto) {
        WarningInformation entity = BeanUtil.copyProperties(dto, WarningInformation.class);
        return Result.ok(warningInformationService.save(entity));
    }

    @ApiOperation(value = "预警信息表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody WarningInformationDTO dto) {
        WarningInformation entity = BeanUtil.copyProperties(dto, WarningInformation.class);
        return Result.ok(warningInformationService.updateById(entity));
    }

    @ApiOperation(value = "预警信息表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(warningInformationService.removeById(id));
    }

    @ApiOperation(value = "预警信息表详情")
    @GetMapping("/{id}")
    public Result<WarningInformationVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(warningInformationService.getById(id), WarningInformationVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(warningInformationService.removeByIds(ids));
    }


}

