package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.ManuscriptResponsibleEditor;
import com.content.vo.ManuscriptResponsibleEditorVO;
import com.content.mapper.ManuscriptResponsibleEditorMapper;
import com.content.service.IManuscriptResponsibleEditorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【稿件责编表】实现层
 *
 * @author sml
 * @date 2023-07-28
 */
@Slf4j
@Service
public class ManuscriptResponsibleEditorServiceImpl extends ServiceImpl<ManuscriptResponsibleEditorMapper, ManuscriptResponsibleEditor> implements IManuscriptResponsibleEditorService {
}
