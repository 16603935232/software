package com.ai.controller.feign;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ai.result.Result;

import com.ai.dto.InstitutePaperRelationPublishDTO;
import com.ai.vo.InstitutePaperRelationPublishVO;
import com.ai.entity.InstitutePaperRelationPublish;
import com.ai.util.QueryUtils;
import com.ai.service.IInstitutePaperRelationPublishService;
import com.ai.util.MapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import com.ai.excel.InstitutePaperRelationPublishExcelDTO;
import com.ai.util.ExcelUtil;
import org.springframework.web.bind.annotation.*;



import java.util.Arrays;
import java.util.List;


/**
 * 【】控制器层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Api(tags = {"【】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/institute-paper-relation-publish")
public class InstitutePaperRelationPublishController {

    private final IInstitutePaperRelationPublishService  institutePaperRelationPublishService;

    @ApiOperation(value = "列表查询")
    @PostMapping("/list")
    public Result<List<InstitutePaperRelationPublishVO>> list(@RequestBody InstitutePaperRelationPublishDTO dto) {
        return Result.ok(MapperUtils.INSTANCE.mapAsList(InstitutePaperRelationPublishVO.class,institutePaperRelationPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InstitutePaperRelationPublish.class)))));
    }

    @ApiOperation(value = "分页查询")
    @PostMapping("/page")
    public Result<Page<InstitutePaperRelationPublishVO>> page(@RequestBody InstitutePaperRelationPublishDTO dto) {
        Page<InstitutePaperRelationPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InstitutePaperRelationPublish> result = institutePaperRelationPublishService.page(page, QueryUtils.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InstitutePaperRelationPublish.class))));
        return Result.ok(MapperUtils.INSTANCE.mapAsPage(InstitutePaperRelationPublishVO.class, result));
    }

    @ApiOperation(value = "添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InstitutePaperRelationPublishDTO dto) {
        InstitutePaperRelationPublish entity = BeanUtil.copyProperties(dto, InstitutePaperRelationPublish.class);
        institutePaperRelationPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InstitutePaperRelationPublishDTO dto) {
        InstitutePaperRelationPublish entity = BeanUtil.copyProperties(dto, InstitutePaperRelationPublish.class);
        return Result.ok(institutePaperRelationPublishService.save(entity));
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InstitutePaperRelationPublishDTO dto) {
        InstitutePaperRelationPublish entity = BeanUtil.copyProperties(dto, InstitutePaperRelationPublish.class);
        return Result.ok(institutePaperRelationPublishService.updateById(entity));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(institutePaperRelationPublishService.removeById(id));
    }

    @ApiOperation(value = "详情")
    @GetMapping("/{id}")
    public Result<InstitutePaperRelationPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(institutePaperRelationPublishService.getById(id), InstitutePaperRelationPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(institutePaperRelationPublishService.removeByIds(ids));
    }

    @ApiOperation(value = "-导入Excel")
    @PostMapping("/importExcel")
    public Result<Boolean> importExcel(@RequestParam(value = "file") MultipartFile file){
        return Result.ok(institutePaperRelationPublishService.importExcel(file));
    }

    @ApiOperation(value = "-导出Excel")
    @GetMapping("/downloadExcel")
    public void downloadExcel(@RequestBody List<Long> ids, HttpServletResponse response) {
        List<InstitutePaperRelationPublishExcelDTO> list = institutePaperRelationPublishService.downloadExcel(ids);
        ExcelUtil.downloadExcel(response,list,InstitutePaperRelationPublishExcelDTO.class);
    }

}

