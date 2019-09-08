package com.qianshu.kindergarten.entity;

import java.io.Serializable;

public class WXGetUserInfo implements Serializable {
    private static final long serialVersionUID = 2916900627148274485L;
    private String encryptedData;//完整用户信息的加密数据
    private String errMsg;//状态信息
    private String iv;//加密算法的初始向量
    private String rawData;//不包括敏感信息的原始数据字符串，用于计算签名
    private String signature;//使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息
    private WxUserInfo userInfo;//用户信息对象
    private String cloudID;//敏感数据对应的云 ID，开通云开发的小程序才会返回

    @Override
    public String toString() {
        return "WXGetUserInfo{" +
                "encryptedData='" + encryptedData + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", iv='" + iv + '\'' +
                ", rawData='" + rawData + '\'' +
                ", signature='" + signature + '\'' +
                ", userInfo=" + userInfo +
                ", cloudID='" + cloudID + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public WxUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(WxUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getCloudID() {
        return cloudID;
    }

    public void setCloudID(String cloudID) {
        this.cloudID = cloudID;
    }
}
