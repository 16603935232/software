package com.ai.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ai.result.Result;

import com.ai.dto.InstituteTeamDTO;
import com.ai.vo.InstituteTeamVO;
import com.ai.entity.InstituteTeam;
import com.ai.utils.QueryUtil;
import com.ai.service.IInstituteTeamService;
import com.ai.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【研究机构-团队】控制器层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Api(tags = {"【研究机构-团队】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/institute-team")
public class InstituteTeamController {

    private final IInstituteTeamService  instituteTeamService;

    @ApiOperation(value = "研究机构-团队列表查询")
    @PostMapping("/list")
    public Result<List<InstituteTeamVO>> list(@RequestBody InstituteTeamDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(InstituteTeamVO.class,instituteTeamService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InstituteTeam.class)))));
    }

    @ApiOperation(value = "研究机构-团队分页查询")
    @PostMapping("/page")
    public Result<Page<InstituteTeamVO>> page(@RequestBody InstituteTeamDTO dto) {
        Page<InstituteTeam> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InstituteTeam> result = instituteTeamService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InstituteTeam.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(InstituteTeamVO.class, result));
    }

    @ApiOperation(value = "研究机构-团队添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InstituteTeamDTO dto) {
        InstituteTeam entity = BeanUtil.copyProperties(dto, InstituteTeam.class);
        instituteTeamService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "研究机构-团队添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InstituteTeamDTO dto) {
        InstituteTeam entity = BeanUtil.copyProperties(dto, InstituteTeam.class);
        return Result.ok(instituteTeamService.save(entity));
    }

    @ApiOperation(value = "研究机构-团队更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InstituteTeamDTO dto) {
        InstituteTeam entity = BeanUtil.copyProperties(dto, InstituteTeam.class);
        return Result.ok(instituteTeamService.updateById(entity));
    }

    @ApiOperation(value = "研究机构-团队删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(instituteTeamService.removeById(id));
    }

    @ApiOperation(value = "研究机构-团队详情")
    @GetMapping("/{id}")
    public Result<InstituteTeamVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(instituteTeamService.getById(id), InstituteTeamVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(instituteTeamService.removeByIds(ids));
    }


}

