package com.qianshu.kindergarten.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 学生信息表
 */
public class StudentInfo implements Serializable {
    private static final long serialVersionUID = -8836237518453463687L;
    private int id;
    private String name;//学生姓名
    private int sex;//性别
    private int age;//年龄
    private String identity;//身份证
    private String father_name;//父亲姓名
    private String mother_name;//母亲姓名
    private String phone;//联系电话
    private int schools_info_id;//学校ID
    private String openid;//openid
    private String address;//住址
    private LocalDateTime create_time;//创建时间

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", identity='" + identity + '\'' +
                ", father_name='" + father_name + '\'' +
                ", mother_name='" + mother_name + '\'' +
                ", phone='" + phone + '\'' +
                ", schools_info_id=" + schools_info_id +
                ", openid='" + openid + '\'' +
                ", address='" + address + '\'' +
                ", create_time=" + create_time +
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSchools_info_id() {
        return schools_info_id;
    }

    public void setSchools_info_id(int schools_info_id) {
        this.schools_info_id = schools_info_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }
}
