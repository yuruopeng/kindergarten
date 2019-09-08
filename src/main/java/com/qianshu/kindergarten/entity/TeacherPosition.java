package com.qianshu.kindergarten.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 老师职位表
 */
public class TeacherPosition implements Serializable{
    private static final long serialVersionUID = 2190856541353885100L;
    private int id;
    private String name;//职位名称
    private String code;//唯一code
    private LocalDateTime create_time;//创建时间
}
