package com.qianshu.kindergarten.Controller;

import com.github.pagehelper.PageInfo;
import com.qianshu.kindergarten.entity.SellerInfo;
import com.qianshu.kindergarten.service.SellerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@Api(value = "给用户提供增删改查的接口",description = "用户增删改查接口")
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    @Autowired
    private SellerInfoService sellerInfoService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "测试", notes = "测试接口")
    public String testHelloWorld(){
        return "Hello World!!!";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户", notes = "查询接口")
    @ApiImplicitParam(name = "username", value = "用户名称", required = true, dataType = "String", paramType = "query")
    public List<SellerInfo> findUser(String username,int sort) {
        List<SellerInfo> sellerInfo = sellerInfoService.findUser(username,sort);
        if(ObjectUtils.isEmpty(sellerInfo)){
            return null;
        }
        return sellerInfo;
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部用户", notes = "查询接口")
    public List<SellerInfo> findUserList() {
        List<SellerInfo> sellerInfos = sellerInfoService.findUserList();
        return sellerInfos;
    }

    @RequestMapping(value = "/selectLimit", method = RequestMethod.GET)
    @ApiOperation(value = "分页", notes = "查询接口")
    public PageInfo<SellerInfo> findListLimit(int page,int rows) {
        PageInfo<SellerInfo> sellerInfos = sellerInfoService.findListLimit(page,rows);
        return sellerInfos;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "添加接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value="用户名",required=true,paramType="form",dataType="String"),
            @ApiImplicitParam(name="password",value="密码",required=true,paramType="form",dataType="String"),
            @ApiImplicitParam(name="openid",value="OpenId",required=true,paramType="form",dataType="String"),
            @ApiImplicitParam(name="create_time",value="创建时间",required=false,paramType="form",dataType="String"),
            @ApiImplicitParam(name="update_time",value="修改时间",required=false,paramType="form",dataType="String")
    })
    public int insertUser(SellerInfo sellerInfo) {
        int i = sellerInfoService.insertUser(sellerInfo);
        return i;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "删除接口")
    public int deleteUser(int i) {
        int a = sellerInfoService.deleteUser(i);
        return a;
    }

    @RequestMapping(value = "/deleteUsers", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "删除接口")
    public int deleteUsers(String i) {
        System.out.println(i);
        int a = sellerInfoService.deleteUsers(i);
        return a;
    }
}
