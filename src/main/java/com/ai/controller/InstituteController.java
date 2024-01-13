package com.ai.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ai.result.Result;

import com.ai.dto.InstituteDTO;
import com.ai.vo.InstituteVO;
import com.ai.entity.Institute;
import com.ai.utils.QueryUtil;
import com.ai.service.IInstituteService;
import com.ai.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【研究机构表】控制器层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Api(tags = {"【研究机构表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/institute")
public class InstituteController {

    private final IInstituteService  instituteService;

    @ApiOperation(value = "研究机构表列表查询")
    @PostMapping("/list")
    public Result<List<InstituteVO>> list(@RequestBody InstituteDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(InstituteVO.class,instituteService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, Institute.class)))));
    }

    @ApiOperation(value = "研究机构表分页查询")
    @PostMapping("/page")
    public Result<Page<InstituteVO>> page(@RequestBody InstituteDTO dto) {
        Page<Institute> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<Institute> result = instituteService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, Institute.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(InstituteVO.class, result));
    }

    @ApiOperation(value = "研究机构表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InstituteDTO dto) {
        Institute entity = BeanUtil.copyProperties(dto, Institute.class);
        instituteService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "研究机构表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InstituteDTO dto) {
        Institute entity = BeanUtil.copyProperties(dto, Institute.class);
        return Result.ok(instituteService.save(entity));
    }

    @ApiOperation(value = "研究机构表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InstituteDTO dto) {
        Institute entity = BeanUtil.copyProperties(dto, Institute.class);
        return Result.ok(instituteService.updateById(entity));
    }

    @ApiOperation(value = "研究机构表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(instituteService.removeById(id));
    }

    @ApiOperation(value = "研究机构表详情")
    @GetMapping("/{id}")
    public Result<InstituteVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(instituteService.getById(id), InstituteVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(instituteService.removeByIds(ids));
    }


}

