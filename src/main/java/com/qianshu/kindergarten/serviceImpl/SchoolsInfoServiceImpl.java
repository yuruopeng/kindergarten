package com.qianshu.kindergarten.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianshu.kindergarten.Mapper.SchoolsInfoMapper;
import com.qianshu.kindergarten.Utils.RedisUtil;
import com.qianshu.kindergarten.dto.SchoolRegistrationDTO;
import com.qianshu.kindergarten.entity.SchoolsInfo;
import com.qianshu.kindergarten.service.SchoolsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchoolsInfoServiceImpl implements SchoolsInfoService {
    private static final Logger logger = LoggerFactory.getLogger(SchoolsInfoServiceImpl.class);

    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private SchoolsInfoMapper schoolsInfoMapper;

    @Override
    public SchoolsInfo findSchool(int id) {
        return schoolsInfoMapper.findSchool(id);
    }

    @Override
    public List<SchoolsInfo> findSchoolsList() {
        return schoolsInfoMapper.findSchoolsList();
    }

    @Override
    public int insertSchool(SchoolsInfo schoolsInfo) {
        return schoolsInfoMapper.insertSchool(schoolsInfo);
    }

    @Override
    public int deleteSchool(int id) {
        return schoolsInfoMapper.deleteSchool(id);
    }

    @Override
    public List<SchoolRegistrationDTO> findKindergartenList(int sort) {
        return schoolsInfoMapper.findKindergartenList(sort);
    }

    @Override
    public PageInfo<SchoolRegistrationDTO> findKindergartenListLimit(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<SchoolRegistrationDTO> Kindergartens = schoolsInfoMapper.findKindergartenListLimit();
        PageInfo<SchoolRegistrationDTO> pageInfo = new PageInfo<>(Kindergartens);
        return pageInfo;
    }

    @Override
    public List<SchoolRegistrationDTO> findKindergarten(String name) {
        return schoolsInfoMapper.findKindergarten(name);
    }
}
