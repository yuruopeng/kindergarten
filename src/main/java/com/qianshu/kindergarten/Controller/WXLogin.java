package com.qianshu.kindergarten.Controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.fastjson.JSONObject;
import com.qianshu.kindergarten.Utils.RedisUtil;
import com.qianshu.kindergarten.Utils.WechatUtil;
import com.qianshu.kindergarten.dto.UserInfoDTO;
import com.qianshu.kindergarten.entity.SellerInfo;
import com.qianshu.kindergarten.entity.WXGetUserInfo;
import com.qianshu.kindergarten.entity.WxUserInfo;
import com.qianshu.kindergarten.service.SellerInfoService;
import com.qianshu.kindergarten.service.WxUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
@Api(value = "微信登录获取信息接口",description = "微信登录获取信息接口")
public class WXLogin {
    @Autowired
    private WxMaService wxMaService;
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private WxUserInfoService wxUserInfoService;
    @Autowired
    private SellerInfoService sellerInfoService;

    @RequestMapping(value = "/loginByCode", method = RequestMethod.POST)
    @ApiOperation(value = "查询ByCode", notes = "查询ByCode")
    @ApiImplicitParam(name = "code", value = "用户code", required = true, dataType = "String", paramType = "query")
    public Map<String, Object> loginByCode(String code) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<>();
        WxMaJscode2SessionResult result = wxMaService.jsCode2SessionInfo(code);
        //hashMap.put("openid",result.getOpenid());
        //hashMap.put("sessionKey",result.getSessionKey());
        //hashMap.put("unionid",result.getUnionid());

        String filename = RandomStringUtils.randomAlphanumeric(60);
        if(!redisUtil.hasKey(filename)){
            redisUtil.set(filename,result.getOpenid() + "," + result.getSessionKey(),3600);
            hashMap.put("token",filename);
        }else{
            hashMap.put("token",redisUtil.get(filename));
        }
        return hashMap;
    }

    @RequestMapping(value = "/getOpenIdAndSeesionKey", method = RequestMethod.GET)
    @ApiOperation(value = "查询BythirdSession", notes = "查询BythirdSession")
    @ApiImplicitParam(name = "thirdSession", value = "用户thirdSession", required = true, dataType = "String", paramType = "query")
    public Map<String, String> getOpenIdAndSeesionKey(String thirdSession){
        HashMap<String, String> hashMap = new HashMap<>();
        if(redisUtil.hasKey(thirdSession)){
            String string = redisUtil.get(thirdSession).toString();
            redisUtil.expire("thirdSession", 3600);
            String[] split = string.split(",");
            hashMap.put("openId",split[0]);
            hashMap.put("sessionKey",split[1]);
            System.out.println(hashMap);
            return hashMap;
        }
        hashMap.put("code","401");//401：redis中没有用户sessionkey
        return hashMap;
    }

    /**
     * 前提是用户点击授权
     * @param res
     */
    @RequestMapping(value = "/loginAndAddUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "登录并且把用户信息存入", notes = "登录并且把用户信息存入")
    @ApiImplicitParam(name = "微信getUserInfo返回数据", value = "res", required = true, dataType = "String", paramType = "query")
    public void loginAndAddUserInfo(String res,String thirdSession){
        WXGetUserInfo wxGetUserInfo = JSONObject.parseObject(res, WXGetUserInfo.class);
        Map<String, String> openIdAndSeesionKey = getOpenIdAndSeesionKey(thirdSession);
        String result = WechatUtil.decryptData(wxGetUserInfo.getEncryptedData(),openIdAndSeesionKey.get("sessionKey"), wxGetUserInfo.getIv());
        WxUserInfo wxUserInfo = JSONObject.parseObject(result, WxUserInfo.class);
        WxUserInfo wxUser = wxUserInfoService.selectwxUserByOpenid(wxUserInfo.getOpenid());
        if(ObjectUtils.isEmpty(wxUser)){
            wxUserInfoService.insertWxUser(wxUserInfo);
        }
    }

    @RequestMapping(value = "/verificationUser", method = RequestMethod.POST)
    @ApiOperation(value = "上传照片的登录验证", notes = "上传照片的登录验证")
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value="用户名",required=true,paramType="form",dataType="String"),
            @ApiImplicitParam(name="password",value="密码",required=true,paramType="form",dataType="String"),
            @ApiImplicitParam(name="phone",value="phone",required=true,paramType="form",dataType="String")
    })
    public Map<String, String> verificationUser(SellerInfo sellerInfo){
        return sellerInfoService.findUser(sellerInfo.getUsername(), sellerInfo.getPassword());
    }
}
