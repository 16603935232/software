package com.sci.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.result.Result;

import com.sci.dto.DocumentQuestionsAnswersDTO;
import com.sci.vo.DocumentQuestionsAnswersVO;
import com.sci.entity.DocumentQuestionsAnswers;
import com.sci.utils.QueryUtil;
import com.sci.service.IDocumentQuestionsAnswersService;
import com.sci.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【文档问答】控制器层
 *
 * @author sml
 * @date 2023-11-17
 */
@Slf4j
@Api(tags = {"【文档问答】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/document-questions-answers")
public class DocumentQuestionsAnswersController {

    private final IDocumentQuestionsAnswersService  documentQuestionsAnswersService;

    @ApiOperation(value = "文档问答列表查询")
    @PostMapping("/list")
    public Result<List<DocumentQuestionsAnswersVO>> list(@RequestBody DocumentQuestionsAnswersDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(DocumentQuestionsAnswersVO.class,documentQuestionsAnswersService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, DocumentQuestionsAnswers.class)))));
    }

    @ApiOperation(value = "文档问答分页查询")
    @PostMapping("/page")
    public Result<Page<DocumentQuestionsAnswersVO>> page(@RequestBody DocumentQuestionsAnswersDTO dto) {
        Page<DocumentQuestionsAnswers> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<DocumentQuestionsAnswers> result = documentQuestionsAnswersService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, DocumentQuestionsAnswers.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(DocumentQuestionsAnswersVO.class, result));
    }

    @ApiOperation(value = "文档问答添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody DocumentQuestionsAnswersDTO dto) {
        DocumentQuestionsAnswers entity = BeanUtil.copyProperties(dto, DocumentQuestionsAnswers.class);
        documentQuestionsAnswersService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "文档问答添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody DocumentQuestionsAnswersDTO dto) {
        DocumentQuestionsAnswers entity = BeanUtil.copyProperties(dto, DocumentQuestionsAnswers.class);
        return Result.ok(documentQuestionsAnswersService.save(entity));
    }

    @ApiOperation(value = "文档问答更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody DocumentQuestionsAnswersDTO dto) {
        DocumentQuestionsAnswers entity = BeanUtil.copyProperties(dto, DocumentQuestionsAnswers.class);
        return Result.ok(documentQuestionsAnswersService.updateById(entity));
    }

    @ApiOperation(value = "文档问答删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(documentQuestionsAnswersService.removeById(id));
    }

    @ApiOperation(value = "文档问答详情")
    @GetMapping("/{id}")
    public Result<DocumentQuestionsAnswersVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(documentQuestionsAnswersService.getById(id), DocumentQuestionsAnswersVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(documentQuestionsAnswersService.removeByIds(ids));
    }


}

