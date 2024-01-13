package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.MyFocus;
import com.datasource.vo.MyFocusVO;
import com.datasource.mapper.MyFocusMapper;
import com.datasource.service.IMyFocusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【我的关注表】实现层
 *
 * @author shangml
 * @date 2023-12-06
 */
@Slf4j
@Service
public class MyFocusServiceImpl extends ServiceImpl<MyFocusMapper, MyFocus> implements IMyFocusService {
}
