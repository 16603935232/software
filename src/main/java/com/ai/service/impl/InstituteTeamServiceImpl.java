package com.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ai.entity.InstituteTeam;
import com.ai.vo.InstituteTeamVO;
import com.ai.mapper.InstituteTeamMapper;
import com.ai.service.IInstituteTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【研究机构-团队】实现层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Service
public class InstituteTeamServiceImpl extends ServiceImpl<InstituteTeamMapper, InstituteTeam> implements IInstituteTeamService {
}
