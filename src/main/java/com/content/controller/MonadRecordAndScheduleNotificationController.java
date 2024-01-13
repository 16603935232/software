package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.MonadRecordAndScheduleNotificationDTO;
import com.content.vo.MonadRecordAndScheduleNotificationVO;
import com.content.entity.MonadRecordAndScheduleNotification;
import com.content.utils.QueryUtil;
import com.content.service.IMonadRecordAndScheduleNotificationService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【录排通知单】控制器层
 *
 * @author sml
 * @date 2023-08-02
 */
@Slf4j
@Api(tags = {"【录排通知单】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/monad-record-and-schedule-notification")
public class MonadRecordAndScheduleNotificationController {

    private final IMonadRecordAndScheduleNotificationService  monadRecordAndScheduleNotificationService;

    @ApiOperation(value = "录排通知单列表查询")
    @PostMapping("/list")
    public Result<List<MonadRecordAndScheduleNotificationVO>> list(@RequestBody MonadRecordAndScheduleNotificationDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MonadRecordAndScheduleNotificationVO.class,monadRecordAndScheduleNotificationService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MonadRecordAndScheduleNotification.class)))));
    }

    @ApiOperation(value = "录排通知单分页查询")
    @PostMapping("/page")
    public Result<Page<MonadRecordAndScheduleNotificationVO>> page(@RequestBody MonadRecordAndScheduleNotificationDTO dto) {
        Page<MonadRecordAndScheduleNotification> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MonadRecordAndScheduleNotification> result = monadRecordAndScheduleNotificationService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MonadRecordAndScheduleNotification.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MonadRecordAndScheduleNotificationVO.class, result));
    }

    @ApiOperation(value = "录排通知单添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MonadRecordAndScheduleNotificationDTO dto) {
        MonadRecordAndScheduleNotification entity = BeanUtil.copyProperties(dto, MonadRecordAndScheduleNotification.class);
        monadRecordAndScheduleNotificationService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "录排通知单添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MonadRecordAndScheduleNotificationDTO dto) {
        MonadRecordAndScheduleNotification entity = BeanUtil.copyProperties(dto, MonadRecordAndScheduleNotification.class);
        return Result.ok(monadRecordAndScheduleNotificationService.save(entity));
    }

    @ApiOperation(value = "录排通知单更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MonadRecordAndScheduleNotificationDTO dto) {
        MonadRecordAndScheduleNotification entity = BeanUtil.copyProperties(dto, MonadRecordAndScheduleNotification.class);
        return Result.ok(monadRecordAndScheduleNotificationService.updateById(entity));
    }

    @ApiOperation(value = "录排通知单删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(monadRecordAndScheduleNotificationService.removeById(id));
    }

    @ApiOperation(value = "录排通知单详情")
    @GetMapping("/{id}")
    public Result<MonadRecordAndScheduleNotificationVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(monadRecordAndScheduleNotificationService.getById(id), MonadRecordAndScheduleNotificationVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(monadRecordAndScheduleNotificationService.removeByIds(ids));
    }


}

