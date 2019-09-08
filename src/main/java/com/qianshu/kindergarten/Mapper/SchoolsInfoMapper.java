package com.qianshu.kindergarten.Mapper;

import com.qianshu.kindergarten.dto.SchoolRegistrationDTO;
import com.qianshu.kindergarten.entity.SchoolsInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolsInfoMapper {
    SchoolsInfo findSchool(int id);

    List<SchoolsInfo> findSchoolsList();

    int insertSchool(SchoolsInfo schoolsInfo);

    int deleteSchool(int id);

    List<SchoolRegistrationDTO> findKindergartenList(@Param("sort")int sort);

    List<SchoolRegistrationDTO> findKindergarten(@Param("name")String name);

    List<SchoolRegistrationDTO> findKindergartenListLimit();
}
