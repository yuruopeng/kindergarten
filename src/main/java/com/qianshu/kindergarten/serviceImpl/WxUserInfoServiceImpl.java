package com.qianshu.kindergarten.serviceImpl;

import com.qianshu.kindergarten.Mapper.WxUserInfoMapper;
import com.qianshu.kindergarten.Utils.RedisUtil;
import com.qianshu.kindergarten.entity.WxUserInfo;
import com.qianshu.kindergarten.service.WxUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WxUserInfoServiceImpl implements WxUserInfoService{
    private static final Logger logger = LoggerFactory.getLogger(WxUserInfoServiceImpl.class);

    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private WxUserInfoMapper wxUserInfoMapper;

    @Override
    public int insertWxUser(WxUserInfo wxUserInfo) {
        return wxUserInfoMapper.insertWxUser(wxUserInfo);
    }

    @Override
    public WxUserInfo selectwxUserByOpenid(String openid) {
        return wxUserInfoMapper.selectwxUserByOpenid(openid);
    }
}
