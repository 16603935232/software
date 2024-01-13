package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.ManuscriptEventNeed;
import com.content.vo.ManuscriptEventNeedVO;
import com.content.mapper.ManuscriptEventNeedMapper;
import com.content.service.IManuscriptEventNeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【稿件待办事项表】实现层
 *
 * @author sml
 * @date 2023-08-09
 */
@Slf4j
@Service
public class ManuscriptEventNeedServiceImpl extends ServiceImpl<ManuscriptEventNeedMapper, ManuscriptEventNeed> implements IManuscriptEventNeedService {
}
