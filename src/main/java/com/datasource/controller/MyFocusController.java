package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.MyFocusDTO;
import com.datasource.vo.MyFocusVO;
import com.datasource.entity.MyFocus;
import com.datasource.utils.QueryUtil;
import com.datasource.service.IMyFocusService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【我的关注表】控制器层
 *
 * @author shangml
 * @date 2023-12-06
 */
@Slf4j
@Api(tags = {"【我的关注表】接口"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/my-focus")
public class MyFocusController {

    private final IMyFocusService  myFocusService;

    @ApiOperation(value = "我的关注表列表查询")
    @PostMapping("/list")
    public Result<List<MyFocusVO>> list(@RequestBody MyFocusDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MyFocusVO.class,myFocusService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MyFocus.class)))));
    }

    @ApiOperation(value = "我的关注表分页查询")
    @PostMapping("/page")
    public Result<Page<MyFocusVO>> page(@RequestBody MyFocusDTO dto) {
        Page<MyFocus> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MyFocus> result = myFocusService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MyFocus.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MyFocusVO.class, result));
    }

    @ApiOperation(value = "我的关注表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MyFocusDTO dto) {
        MyFocus entity = BeanUtil.copyProperties(dto, MyFocus.class);
        myFocusService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "我的关注表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MyFocusDTO dto) {
        MyFocus entity = BeanUtil.copyProperties(dto, MyFocus.class);
        return Result.ok(myFocusService.save(entity));
    }

    @ApiOperation(value = "我的关注表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MyFocusDTO dto) {
        MyFocus entity = BeanUtil.copyProperties(dto, MyFocus.class);
        return Result.ok(myFocusService.updateById(entity));
    }

    @ApiOperation(value = "我的关注表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(myFocusService.removeById(id));
    }

    @ApiOperation(value = "我的关注表详情")
    @GetMapping("/{id}")
    public Result<MyFocusVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(myFocusService.getById(id), MyFocusVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(myFocusService.removeByIds(ids));
    }


}

