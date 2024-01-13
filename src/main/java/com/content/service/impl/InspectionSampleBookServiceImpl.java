package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.InspectionSampleBook;
import com.content.vo.InspectionSampleBookVO;
import com.content.mapper.InspectionSampleBookMapper;
import com.content.service.IInspectionSampleBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【检查样书表】实现层
 *
 * @author sml
 * @date 2023-08-15
 */
@Slf4j
@Service
public class InspectionSampleBookServiceImpl extends ServiceImpl<InspectionSampleBookMapper, InspectionSampleBook> implements IInspectionSampleBookService {
}
