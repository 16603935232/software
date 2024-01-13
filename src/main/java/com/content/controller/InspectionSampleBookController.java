package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.InspectionSampleBookDTO;
import com.content.vo.InspectionSampleBookVO;
import com.content.entity.InspectionSampleBook;
import com.content.utils.QueryUtil;
import com.content.service.IInspectionSampleBookService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【检查样书表】控制器层
 *
 * @author sml
 * @date 2023-08-15
 */
@Slf4j
@Api(tags = {"【检查样书表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/inspection-sample-book")
public class InspectionSampleBookController {

    private final IInspectionSampleBookService  inspectionSampleBookService;

    @ApiOperation(value = "检查样书表列表查询")
    @PostMapping("/list")
    public Result<List<InspectionSampleBookVO>> list(@RequestBody InspectionSampleBookDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(InspectionSampleBookVO.class,inspectionSampleBookService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InspectionSampleBook.class)))));
    }

    @ApiOperation(value = "检查样书表分页查询")
    @PostMapping("/page")
    public Result<Page<InspectionSampleBookVO>> page(@RequestBody InspectionSampleBookDTO dto) {
        Page<InspectionSampleBook> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InspectionSampleBook> result = inspectionSampleBookService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InspectionSampleBook.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(InspectionSampleBookVO.class, result));
    }

    @ApiOperation(value = "检查样书表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InspectionSampleBookDTO dto) {
        InspectionSampleBook entity = BeanUtil.copyProperties(dto, InspectionSampleBook.class);
        inspectionSampleBookService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "检查样书表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InspectionSampleBookDTO dto) {
        InspectionSampleBook entity = BeanUtil.copyProperties(dto, InspectionSampleBook.class);
        return Result.ok(inspectionSampleBookService.save(entity));
    }

    @ApiOperation(value = "检查样书表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InspectionSampleBookDTO dto) {
        InspectionSampleBook entity = BeanUtil.copyProperties(dto, InspectionSampleBook.class);
        return Result.ok(inspectionSampleBookService.updateById(entity));
    }

    @ApiOperation(value = "检查样书表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(inspectionSampleBookService.removeById(id));
    }

    @ApiOperation(value = "检查样书表详情")
    @GetMapping("/{id}")
    public Result<InspectionSampleBookVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(inspectionSampleBookService.getById(id), InspectionSampleBookVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(inspectionSampleBookService.removeByIds(ids));
    }


}

