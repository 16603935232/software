package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.MonadRecordAndScheduleNotification;
import com.content.vo.MonadRecordAndScheduleNotificationVO;
import com.content.mapper.MonadRecordAndScheduleNotificationMapper;
import com.content.service.IMonadRecordAndScheduleNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【录排通知单】实现层
 *
 * @author sml
 * @date 2023-08-02
 */
@Slf4j
@Service
public class MonadRecordAndScheduleNotificationServiceImpl extends ServiceImpl<MonadRecordAndScheduleNotificationMapper, MonadRecordAndScheduleNotification> implements IMonadRecordAndScheduleNotificationService {
}
