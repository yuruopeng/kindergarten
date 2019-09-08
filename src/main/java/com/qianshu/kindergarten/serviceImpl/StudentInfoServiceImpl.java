package com.qianshu.kindergarten.serviceImpl;

import com.qianshu.kindergarten.Mapper.StudentInfoMapper;
import com.qianshu.kindergarten.Utils.RedisUtil;
import com.qianshu.kindergarten.entity.StudentInfo;
import com.qianshu.kindergarten.service.StudentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    private static final Logger logger = LoggerFactory.getLogger(StudentInfoServiceImpl.class);

    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Override
    public StudentInfo findStudent(int id) {
        return studentInfoMapper.findStudent(id);
    }

    @Override
    public List<StudentInfo> findStudentsList() {
        return studentInfoMapper.findStudentsList();
    }

    @Override
    public int insertStudent(StudentInfo studentInfo) {
        return studentInfoMapper.insertStudent(studentInfo);
    }

    @Override
    public int deleteStudent(int id) {
        return studentInfoMapper.deleteStudent(id);
    }
}
