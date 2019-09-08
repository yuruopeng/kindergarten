package com.qianshu.kindergarten.Mapper;

import com.qianshu.kindergarten.entity.WxUserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface WxUserInfoMapper {
    int insertWxUser(WxUserInfo wxUserInfo);

    WxUserInfo selectwxUserByOpenid(String openid);
}
