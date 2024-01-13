package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.SysDept;
import com.content.vo.SysDeptVO;
import com.content.mapper.SysDeptMapper;
import com.content.service.ISysDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【部门表】实现层
 *
 * @author lzy
 * @date 2023-08-03
 */
@Slf4j
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {
}
