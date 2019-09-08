package com.qianshu.kindergarten.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

public class SellerInfo implements Serializable{
    private static final long serialVersionUID = 8096256044505758368L;
    private int id;
    private String username;
    private String password;
    private String openid;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private byte[] image;
    private String img;

    @Override
    public String toString() {
        return "SellerInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", openid='" + openid + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", image=" + Arrays.toString(image) +
                ", img='" + img + '\'' +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
