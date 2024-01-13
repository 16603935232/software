package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.BecomeBookDTO;
import com.content.vo.BecomeBookVO;
import com.content.entity.BecomeBook;
import com.content.utils.QueryUtil;
import com.content.service.IBecomeBookService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【成书表】控制器层
 *
 * @author sml
 * @date 2023-08-16
 */
@Slf4j
@Api(tags = {"【成书表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/become-book")
public class BecomeBookController {

    private final IBecomeBookService  becomeBookService;

    @ApiOperation(value = "成书表列表查询")
    @PostMapping("/list")
    public Result<List<BecomeBookVO>> list(@RequestBody BecomeBookDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(BecomeBookVO.class,becomeBookService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, BecomeBook.class)))));
    }

    @ApiOperation(value = "成书表分页查询")
    @PostMapping("/page")
    public Result<Page<BecomeBookVO>> page(@RequestBody BecomeBookDTO dto) {
        Page<BecomeBook> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<BecomeBook> result = becomeBookService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, BecomeBook.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(BecomeBookVO.class, result));
    }

    @ApiOperation(value = "成书表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody BecomeBookDTO dto) {
        BecomeBook entity = BeanUtil.copyProperties(dto, BecomeBook.class);
        becomeBookService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "成书表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody BecomeBookDTO dto) {
        BecomeBook entity = BeanUtil.copyProperties(dto, BecomeBook.class);
        return Result.ok(becomeBookService.save(entity));
    }

    @ApiOperation(value = "成书表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody BecomeBookDTO dto) {
        BecomeBook entity = BeanUtil.copyProperties(dto, BecomeBook.class);
        return Result.ok(becomeBookService.updateById(entity));
    }

    @ApiOperation(value = "成书表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(becomeBookService.removeById(id));
    }

    @ApiOperation(value = "成书表详情")
    @GetMapping("/{id}")
    public Result<BecomeBookVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(becomeBookService.getById(id), BecomeBookVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(becomeBookService.removeByIds(ids));
    }


}

