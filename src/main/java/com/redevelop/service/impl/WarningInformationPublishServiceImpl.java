package com.redevelop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redevelop.entity.WarningInformationPublish;
import com.redevelop.vo.WarningInformationPublishVO;
import com.redevelop.mapper.WarningInformationPublishMapper;
import com.redevelop.service.IWarningInformationPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预警信息发布表】实现层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Service
public class WarningInformationPublishServiceImpl extends ServiceImpl<WarningInformationPublishMapper, WarningInformationPublish> implements IWarningInformationPublishService {
}
