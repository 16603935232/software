package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.ManuscriptStatus;
import com.content.vo.ManuscriptStatusVO;
import com.content.mapper.ManuscriptStatusMapper;
import com.content.service.IManuscriptStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【稿件状态表】实现层
 *
 * @author sml
 * @date 2023-07-28
 */
@Slf4j
@Service
public class ManuscriptStatusServiceImpl extends ServiceImpl<ManuscriptStatusMapper, ManuscriptStatus> implements IManuscriptStatusService {
}
