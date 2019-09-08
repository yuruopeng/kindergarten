package com.qianshu.kindergarten.Mapper;

import com.qianshu.kindergarten.entity.SellerInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SellerInfoMapper{
    List<SellerInfo> findUser(@Param("username")String username,@Param("sort")int sort);

    List<SellerInfo> findUserList();

    int insertUser(SellerInfo sellerInfo);

    int deleteUser(int id);

    int deleteUsers(String ids);

    SellerInfo findUserByUserAndPwd(@Param("username") String username,@Param("password") String password);
}
