package com.qianshu.kindergarten.entity;

import java.io.Serializable;

public class WaterMark implements Serializable{
    private static final long serialVersionUID = 4098066001048887393L;
    private String timestamp;
    private String appid;

    @Override
    public String toString() {
        return "WaterMark{" +
                "timestamp='" + timestamp + '\'' +
                ", appid='" + appid + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
