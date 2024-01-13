package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.ManuscriptEventNeedDTO;
import com.content.vo.ManuscriptEventNeedVO;
import com.content.entity.ManuscriptEventNeed;
import com.content.utils.QueryUtil;
import com.content.service.IManuscriptEventNeedService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【稿件待办事项表】控制器层
 *
 * @author sml
 * @date 2023-08-09
 */
@Slf4j
@Api(tags = {"【稿件待办事项表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/manuscript-event-need")
public class ManuscriptEventNeedController {

    private final IManuscriptEventNeedService  manuscriptEventNeedService;

    @ApiOperation(value = "稿件待办事项表列表查询")
    @PostMapping("/list")
    public Result<List<ManuscriptEventNeedVO>> list(@RequestBody ManuscriptEventNeedDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(ManuscriptEventNeedVO.class,manuscriptEventNeedService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, ManuscriptEventNeed.class)))));
    }

    @ApiOperation(value = "稿件待办事项表分页查询")
    @PostMapping("/page")
    public Result<Page<ManuscriptEventNeedVO>> page(@RequestBody ManuscriptEventNeedDTO dto) {
        Page<ManuscriptEventNeed> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<ManuscriptEventNeed> result = manuscriptEventNeedService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, ManuscriptEventNeed.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(ManuscriptEventNeedVO.class, result));
    }

    @ApiOperation(value = "稿件待办事项表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody ManuscriptEventNeedDTO dto) {
        ManuscriptEventNeed entity = BeanUtil.copyProperties(dto, ManuscriptEventNeed.class);
        manuscriptEventNeedService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "稿件待办事项表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody ManuscriptEventNeedDTO dto) {
        ManuscriptEventNeed entity = BeanUtil.copyProperties(dto, ManuscriptEventNeed.class);
        return Result.ok(manuscriptEventNeedService.save(entity));
    }

    @ApiOperation(value = "稿件待办事项表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody ManuscriptEventNeedDTO dto) {
        ManuscriptEventNeed entity = BeanUtil.copyProperties(dto, ManuscriptEventNeed.class);
        return Result.ok(manuscriptEventNeedService.updateById(entity));
    }

    @ApiOperation(value = "稿件待办事项表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(manuscriptEventNeedService.removeById(id));
    }

    @ApiOperation(value = "稿件待办事项表详情")
    @GetMapping("/{id}")
    public Result<ManuscriptEventNeedVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(manuscriptEventNeedService.getById(id), ManuscriptEventNeedVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(manuscriptEventNeedService.removeByIds(ids));
    }


}

