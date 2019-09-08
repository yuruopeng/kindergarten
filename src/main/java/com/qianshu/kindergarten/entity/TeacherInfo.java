package com.qianshu.kindergarten.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 老师信息表
 */
public class TeacherInfo implements Serializable{
    private static final long serialVersionUID = 1025130211087960271L;
    private int id;
    private String name;//老师姓名
    private int school_info_id;//学校ID
    private String openid;//OpenId
    private String username;//用户名
    private String password;//密码
    private LocalDateTime create_time;//创建时间
    private String phone;//老师电话
    private int teacher_position_id;//老师职位Id

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school_info_id=" + school_info_id +
                ", openid='" + openid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                ", phone='" + phone + '\'' +
                ", teacher_position_id=" + teacher_position_id +
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

    public int getSchool_info_id() {
        return school_info_id;
    }

    public void setSchool_info_id(int school_info_id) {
        this.school_info_id = school_info_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public int getTeacher_position_id() {
        return teacher_position_id;
    }

    public void setTeacher_position_id(int teacher_position_id) {
        this.teacher_position_id = teacher_position_id;
    }
}
