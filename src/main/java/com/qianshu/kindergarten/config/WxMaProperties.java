package com.qianshu.kindergarten.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "wechat.miniapp")
public class WxMaProperties {

    /**
     * 设置小程序的appid
     */
    private String appId;

    /**
     * 小程序的 app secret
     */
    private String secret;

    /**
     * 必传写死的参数
     */
    private String grant_type;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
