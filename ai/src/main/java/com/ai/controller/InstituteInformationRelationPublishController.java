package com.ai.controller.feign;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ai.result.Result;

import com.ai.dto.InstituteInformationRelationPublishDTO;
import com.ai.vo.InstituteInformationRelationPublishVO;
import com.ai.entity.InstituteInformationRelationPublish;
import com.ai.util.QueryUtils;
import com.ai.service.IInstituteInformationRelationPublishService;
import com.ai.util.MapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import com.ai.excel.InstituteInformationRelationPublishExcelDTO;
import com.ai.util.ExcelUtil;
import org.springframework.web.bind.annotation.*;



import java.util.Arrays;
import java.util.List;


/**
 * 【研究机构资讯关联表】控制器层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Api(tags = {"【研究机构资讯关联表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/institute-information-relation-publish")
public class InstituteInformationRelationPublishController {

    private final IInstituteInformationRelationPublishService  instituteInformationRelationPublishService;

    @ApiOperation(value = "研究机构资讯关联表列表查询")
    @PostMapping("/list")
    public Result<List<InstituteInformationRelationPublishVO>> list(@RequestBody InstituteInformationRelationPublishDTO dto) {
        return Result.ok(MapperUtils.INSTANCE.mapAsList(InstituteInformationRelationPublishVO.class,instituteInformationRelationPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InstituteInformationRelationPublish.class)))));
    }

    @ApiOperation(value = "研究机构资讯关联表分页查询")
    @PostMapping("/page")
    public Result<Page<InstituteInformationRelationPublishVO>> page(@RequestBody InstituteInformationRelationPublishDTO dto) {
        Page<InstituteInformationRelationPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InstituteInformationRelationPublish> result = instituteInformationRelationPublishService.page(page, QueryUtils.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InstituteInformationRelationPublish.class))));
        return Result.ok(MapperUtils.INSTANCE.mapAsPage(InstituteInformationRelationPublishVO.class, result));
    }

    @ApiOperation(value = "研究机构资讯关联表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InstituteInformationRelationPublishDTO dto) {
        InstituteInformationRelationPublish entity = BeanUtil.copyProperties(dto, InstituteInformationRelationPublish.class);
        instituteInformationRelationPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "研究机构资讯关联表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InstituteInformationRelationPublishDTO dto) {
        InstituteInformationRelationPublish entity = BeanUtil.copyProperties(dto, InstituteInformationRelationPublish.class);
        return Result.ok(instituteInformationRelationPublishService.save(entity));
    }

    @ApiOperation(value = "研究机构资讯关联表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InstituteInformationRelationPublishDTO dto) {
        InstituteInformationRelationPublish entity = BeanUtil.copyProperties(dto, InstituteInformationRelationPublish.class);
        return Result.ok(instituteInformationRelationPublishService.updateById(entity));
    }

    @ApiOperation(value = "研究机构资讯关联表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(instituteInformationRelationPublishService.removeById(id));
    }

    @ApiOperation(value = "研究机构资讯关联表详情")
    @GetMapping("/{id}")
    public Result<InstituteInformationRelationPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(instituteInformationRelationPublishService.getById(id), InstituteInformationRelationPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(instituteInformationRelationPublishService.removeByIds(ids));
    }

    @ApiOperation(value = "研究机构资讯关联表-导入Excel")
    @PostMapping("/importExcel")
    public Result<Boolean> importExcel(@RequestParam(value = "file") MultipartFile file){
        return Result.ok(instituteInformationRelationPublishService.importExcel(file));
    }

    @ApiOperation(value = "研究机构资讯关联表-导出Excel")
    @GetMapping("/downloadExcel")
    public void downloadExcel(@RequestBody List<Long> ids, HttpServletResponse response) {
        List<InstituteInformationRelationPublishExcelDTO> list = instituteInformationRelationPublishService.downloadExcel(ids);
        ExcelUtil.downloadExcel(response,list,InstituteInformationRelationPublishExcelDTO.class);
    }

}

