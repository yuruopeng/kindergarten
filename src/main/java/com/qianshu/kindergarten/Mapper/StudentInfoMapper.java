package com.qianshu.kindergarten.Mapper;

import com.qianshu.kindergarten.entity.StudentInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInfoMapper {
    StudentInfo findStudent(int id);

    List<StudentInfo> findStudentsList();

    int insertStudent(StudentInfo studentInfo);

    int deleteStudent(int id);
}
