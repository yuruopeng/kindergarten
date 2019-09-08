package com.qianshu.kindergarten.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 学校信息表
 */
public class SchoolsInfo implements Serializable{
    private static final long serialVersionUID = 5843991800212262705L;
    private int id;
    private String name;//学校名称
    private String address;//学校地址
    private int people;//容纳人数
    private String province;//所在省
    private String city;//所在市
    private String county;//所在县
    private String logourl;//学校logoURL
    private byte[] pay_image;//支付微信二维码
    private LocalDateTime create_time;//创建时间
    private String phone;//学校电话
    private LocalDateTime signup_time;//报名截止时间

    @Override
    public String toString() {
        return "SchoolsInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", people=" + people +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", logourl='" + logourl + '\'' +
                ", pay_image=" + Arrays.toString(pay_image) +
                ", create_time=" + create_time +
                ", phone='" + phone + '\'' +
                ", signup_time=" + signup_time +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    public byte[] getPay_image() {
        return pay_image;
    }

    public void setPay_image(byte[] pay_image) {
        this.pay_image = pay_image;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getSignup_time() {
        return signup_time;
    }

    public void setSignup_time(LocalDateTime signup_time) {
        this.signup_time = signup_time;
    }
}
