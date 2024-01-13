package com.redevelop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redevelop.entity.WarningInformation;
import com.redevelop.vo.WarningInformationVO;
import com.redevelop.mapper.WarningInformationMapper;
import com.redevelop.service.IWarningInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【预警信息表】实现层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Slf4j
@Service
public class WarningInformationServiceImpl extends ServiceImpl<WarningInformationMapper, WarningInformation> implements IWarningInformationService {
}
