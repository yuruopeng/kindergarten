package com.qianshu.kindergarten.service;

import com.github.pagehelper.PageInfo;
import com.qianshu.kindergarten.dto.SchoolRegistrationDTO;
import com.qianshu.kindergarten.entity.SchoolsInfo;

import java.util.List;

public interface SchoolsInfoService {
    SchoolsInfo findSchool(int id);

    List<SchoolsInfo> findSchoolsList();

    int insertSchool(SchoolsInfo schoolsInfo);

    int deleteSchool(int id);

    List<SchoolRegistrationDTO> findKindergartenList(int sort);

    PageInfo<SchoolRegistrationDTO> findKindergartenListLimit(int page, int rows);

    List<SchoolRegistrationDTO> findKindergarten(String name);
}
