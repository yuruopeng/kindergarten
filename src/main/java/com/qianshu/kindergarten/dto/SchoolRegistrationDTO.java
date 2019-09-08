package com.qianshu.kindergarten.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SchoolRegistrationDTO implements Serializable{
    private static final long serialVersionUID = 1838619877855156018L;
    private int id;
    private String name;//学校名称
    private String address;//学校地址
    private int people;//容纳人数
    private String province;//所在省
    private String city;//所在市
    private String county;//所在县
    private String logourl;//学校logoURL
    private int registration_not;//是否可以报名
    private BigDecimal price;//学费金额

    @Override
    public String toString() {
        return "SchoolRegistrationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", people=" + people +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", logourl='" + logourl + '\'' +
                ", registration_not=" + registration_not +
                ", price=" + price +
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

    public int getRegistration_not() {
        return registration_not;
    }

    public void setRegistration_not(int registration_not) {
        this.registration_not = registration_not;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
