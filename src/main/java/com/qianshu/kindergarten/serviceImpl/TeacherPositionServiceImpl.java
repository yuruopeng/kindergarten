package com.qianshu.kindergarten.serviceImpl;

import com.qianshu.kindergarten.Utils.RedisUtil;
import com.qianshu.kindergarten.service.TeacherPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherPositionServiceImpl implements TeacherPositionService{
    private static final Logger logger = LoggerFactory.getLogger(TeacherPositionServiceImpl.class);

    @Resource
    private RedisUtil redisUtil;
}
