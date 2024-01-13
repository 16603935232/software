package com.content-backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content-backend.entity.ManuscriptBrief;
import com.content-backend.vo.ManuscriptBriefVO;
import com.content-backend.mapper.ManuscriptBriefMapper;
import com.content-backend.service.IManuscriptBriefService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【稿件简表】实现层
 *
 * @author sml
 * @date 2023-07-28
 */
@Slf4j
@Service
public class ManuscriptBriefServiceImpl extends ServiceImpl<ManuscriptBriefMapper, ManuscriptBrief> implements IManuscriptBriefService {
}
