package com.sci.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.entity.DocumentQuestionsAnswers;
import com.sci.vo.DocumentQuestionsAnswersVO;
import com.sci.mapper.DocumentQuestionsAnswersMapper;
import com.sci.service.IDocumentQuestionsAnswersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【文档问答】实现层
 *
 * @author sml
 * @date 2023-11-17
 */
@Slf4j
@Service
public class DocumentQuestionsAnswersServiceImpl extends ServiceImpl<DocumentQuestionsAnswersMapper, DocumentQuestionsAnswers> implements IDocumentQuestionsAnswersService {
}
