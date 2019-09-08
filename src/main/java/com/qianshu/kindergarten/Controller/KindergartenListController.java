package com.qianshu.kindergarten.Controller;

import com.github.pagehelper.PageInfo;
import com.qianshu.kindergarten.dto.SchoolRegistrationDTO;
import com.qianshu.kindergarten.entity.SchoolsInfo;
import com.qianshu.kindergarten.entity.SellerInfo;
import com.qianshu.kindergarten.service.SchoolsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 幼儿园列表 搜索 排序
 */
@RestController
@RequestMapping("/kindergarten")
@Api(value = "幼儿园列表的接口",description = "幼儿园列表的接口")
public class KindergartenListController {
    private static final Logger logger = LoggerFactory.getLogger(KindergartenListController.class);

    @Autowired
    private SchoolsInfoService schoolsInfoService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部学校", notes = "查询接口")
    public List<SchoolRegistrationDTO> findKindergartenList(int sort) {
        return schoolsInfoService.findKindergartenList(sort);
    }

    @RequestMapping(value = "/selectLimit", method = RequestMethod.GET)
    @ApiOperation(value = "分页", notes = "查询接口")
    public PageInfo<SchoolRegistrationDTO> findKindergartenListLimit(int page, int rows) {
        return schoolsInfoService.findKindergartenListLimit(page,rows);
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ApiOperation(value = "模糊查询学校", notes = "查询接口")
    @ApiImplicitParam(name = "name", value = "学校名称", required = true, dataType = "String", paramType = "query")
    public List<SchoolRegistrationDTO> findKindergarten(String name) {
        List<SchoolRegistrationDTO> schoolsInfos = schoolsInfoService.findKindergarten(name);
        if(ObjectUtils.isEmpty(schoolsInfos)){
            return null;
        }
        return schoolsInfos;
    }
}
