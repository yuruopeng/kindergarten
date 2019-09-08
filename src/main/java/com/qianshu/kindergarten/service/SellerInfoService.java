package com.qianshu.kindergarten.service;

import com.github.pagehelper.PageInfo;
import com.qianshu.kindergarten.entity.SellerInfo;

import java.util.List;
import java.util.Map;

public interface SellerInfoService {
    List<SellerInfo> findUser(String username,int sort);

    List<SellerInfo> findUserList();

    PageInfo<SellerInfo> findListLimit(int page, int rows);

    int insertUser(SellerInfo sellerInfo);

    int deleteUser(int i);

    int deleteUsers(String i);

    Map<String, String> findUser(String username, String password);
}
