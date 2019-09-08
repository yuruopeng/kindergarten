package com.qianshu.kindergarten.service;

import com.qianshu.kindergarten.entity.StudentInfo;

import java.util.List;

public interface StudentInfoService {
    StudentInfo findStudent(int id);

    List<StudentInfo> findStudentsList();

    int insertStudent(StudentInfo studentInfo);

    int deleteStudent(int id);
}
