package com.qianshu.kindergarten.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class WxUserInfo implements Serializable{
    private static final long serialVersionUID = 1536057891263324759L;

    private int id;
    private String openid;
    private String avatarurl;//用户头像图片的 URL
    private String city;//所在城市
    private String country;//所在国家
    private int gender;//用户性别 0未知  1男性  2女性
    private String language;//语言
    private String nickname;//用户昵称
    private String province;//所在省份
    private LocalDateTime create_time;
    private WaterMark watermark;//水印

    @Override
    public String toString() {
        return "WxUserInfo{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", avatarurl='" + avatarurl + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", language='" + language + '\'' +
                ", nickname='" + nickname + '\'' +
                ", province='" + province + '\'' +
                ", create_time=" + create_time +
                ", watermark=" + watermark +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public WaterMark getWatermark() {
        return watermark;
    }

    public void setWatermark(WaterMark watermark) {
        this.watermark = watermark;
    }
}
