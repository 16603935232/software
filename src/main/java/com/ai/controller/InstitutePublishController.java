package com.ai.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ai.result.Result;

import com.ai.dto.InstitutePublishDTO;
import com.ai.vo.InstitutePublishVO;
import com.ai.entity.InstitutePublish;
import com.ai.utils.QueryUtil;
import com.ai.service.IInstitutePublishService;
import com.ai.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【研究机构-发布表】控制器层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Api(tags = {"【研究机构-发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/institute-publish")
public class InstitutePublishController {

    private final IInstitutePublishService  institutePublishService;

    @ApiOperation(value = "研究机构-发布表列表查询")
    @PostMapping("/list")
    public Result<List<InstitutePublishVO>> list(@RequestBody InstitutePublishDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(InstitutePublishVO.class,institutePublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InstitutePublish.class)))));
    }

    @ApiOperation(value = "研究机构-发布表分页查询")
    @PostMapping("/page")
    public Result<Page<InstitutePublishVO>> page(@RequestBody InstitutePublishDTO dto) {
        Page<InstitutePublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InstitutePublish> result = institutePublishService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InstitutePublish.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(InstitutePublishVO.class, result));
    }

    @ApiOperation(value = "研究机构-发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InstitutePublishDTO dto) {
        InstitutePublish entity = BeanUtil.copyProperties(dto, InstitutePublish.class);
        institutePublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "研究机构-发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InstitutePublishDTO dto) {
        InstitutePublish entity = BeanUtil.copyProperties(dto, InstitutePublish.class);
        return Result.ok(institutePublishService.save(entity));
    }

    @ApiOperation(value = "研究机构-发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InstitutePublishDTO dto) {
        InstitutePublish entity = BeanUtil.copyProperties(dto, InstitutePublish.class);
        return Result.ok(institutePublishService.updateById(entity));
    }

    @ApiOperation(value = "研究机构-发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(institutePublishService.removeById(id));
    }

    @ApiOperation(value = "研究机构-发布表详情")
    @GetMapping("/{id}")
    public Result<InstitutePublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(institutePublishService.getById(id), InstitutePublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(institutePublishService.removeByIds(ids));
    }


}

