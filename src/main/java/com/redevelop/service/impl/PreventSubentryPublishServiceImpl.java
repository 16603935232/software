package com.redevelop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redevelop.entity.PreventSubentryPublish;
import com.redevelop.vo.PreventSubentryPublishVO;
import com.redevelop.mapper.PreventSubentryPublishMapper;
import com.redevelop.service.IPreventSubentryPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【应对措施分项信息发布表】实现层
 *
 * @author shangml
 * @date 2023-04-26
 */
@Slf4j
@Service
public class PreventSubentryPublishServiceImpl extends ServiceImpl<PreventSubentryPublishMapper, PreventSubentryPublish> implements IPreventSubentryPublishService {
}
