package com.qianshu.kindergarten.serviceImpl;

import com.qianshu.kindergarten.Utils.RedisUtil;
import com.qianshu.kindergarten.service.TeacherInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {
    private static final Logger logger = LoggerFactory.getLogger(TeacherInfoServiceImpl.class);
    @Resource
    private RedisUtil redisUtil;

}
