package com.qianshu.kindergarten.service;

import com.qianshu.kindergarten.entity.WxUserInfo;

public interface WxUserInfoService {
    int insertWxUser(WxUserInfo wxUserInfo);

    WxUserInfo selectwxUserByOpenid(String openid);
}
