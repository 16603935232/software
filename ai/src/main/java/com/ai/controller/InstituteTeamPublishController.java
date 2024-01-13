package com.ai.controller.feign;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ai.result.Result;

import com.ai.dto.InstituteTeamPublishDTO;
import com.ai.vo.InstituteTeamPublishVO;
import com.ai.entity.InstituteTeamPublish;
import com.ai.util.QueryUtils;
import com.ai.service.IInstituteTeamPublishService;
import com.ai.util.MapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import com.ai.excel.InstituteTeamPublishExcelDTO;
import com.ai.util.ExcelUtil;
import org.springframework.web.bind.annotation.*;



import java.util.Arrays;
import java.util.List;


/**
 * 【研究机构-团队发布表】控制器层
 *
 * @author sml
 * @date 2023-10-18
 */
@Slf4j
@Api(tags = {"【研究机构-团队发布表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/institute-team-publish")
public class InstituteTeamPublishController {

    private final IInstituteTeamPublishService  instituteTeamPublishService;

    @ApiOperation(value = "研究机构-团队发布表列表查询")
    @PostMapping("/list")
    public Result<List<InstituteTeamPublishVO>> list(@RequestBody InstituteTeamPublishDTO dto) {
        return Result.ok(MapperUtils.INSTANCE.mapAsList(InstituteTeamPublishVO.class,instituteTeamPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InstituteTeamPublish.class)))));
    }

    @ApiOperation(value = "研究机构-团队发布表分页查询")
    @PostMapping("/page")
    public Result<Page<InstituteTeamPublishVO>> page(@RequestBody InstituteTeamPublishDTO dto) {
        Page<InstituteTeamPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InstituteTeamPublish> result = instituteTeamPublishService.page(page, QueryUtils.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InstituteTeamPublish.class))));
        return Result.ok(MapperUtils.INSTANCE.mapAsPage(InstituteTeamPublishVO.class, result));
    }

    @ApiOperation(value = "研究机构-团队发布表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InstituteTeamPublishDTO dto) {
        InstituteTeamPublish entity = BeanUtil.copyProperties(dto, InstituteTeamPublish.class);
        instituteTeamPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "研究机构-团队发布表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InstituteTeamPublishDTO dto) {
        InstituteTeamPublish entity = BeanUtil.copyProperties(dto, InstituteTeamPublish.class);
        return Result.ok(instituteTeamPublishService.save(entity));
    }

    @ApiOperation(value = "研究机构-团队发布表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InstituteTeamPublishDTO dto) {
        InstituteTeamPublish entity = BeanUtil.copyProperties(dto, InstituteTeamPublish.class);
        return Result.ok(instituteTeamPublishService.updateById(entity));
    }

    @ApiOperation(value = "研究机构-团队发布表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(instituteTeamPublishService.removeById(id));
    }

    @ApiOperation(value = "研究机构-团队发布表详情")
    @GetMapping("/{id}")
    public Result<InstituteTeamPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(instituteTeamPublishService.getById(id), InstituteTeamPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(instituteTeamPublishService.removeByIds(ids));
    }

    @ApiOperation(value = "研究机构-团队发布表-导入Excel")
    @PostMapping("/importExcel")
    public Result<Boolean> importExcel(@RequestParam(value = "file") MultipartFile file){
        return Result.ok(instituteTeamPublishService.importExcel(file));
    }

    @ApiOperation(value = "研究机构-团队发布表-导出Excel")
    @GetMapping("/downloadExcel")
    public void downloadExcel(@RequestBody List<Long> ids, HttpServletResponse response) {
        List<InstituteTeamPublishExcelDTO> list = instituteTeamPublishService.downloadExcel(ids);
        ExcelUtil.downloadExcel(response,list,InstituteTeamPublishExcelDTO.class);
    }

}

