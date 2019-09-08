package com.qianshu.kindergarten.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianshu.kindergarten.Utils.RedisUtil;
import com.qianshu.kindergarten.entity.SellerInfo;
import com.qianshu.kindergarten.Mapper.SellerInfoMapper;
import com.qianshu.kindergarten.service.SellerInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {
    private static final Logger logger = LoggerFactory.getLogger(SellerInfoServiceImpl.class);

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private SellerInfoMapper sellerInfoMapper;

    @Override
    public List<SellerInfo> findUser(String username,int sort) {
        List<SellerInfo> sellerInfo = sellerInfoMapper.findUser(username,sort);
        return sellerInfo;
    }

    @Override
    public List<SellerInfo> findUserList() {
        return sellerInfoMapper.findUserList();
    }

    @Override
    public PageInfo<SellerInfo> findListLimit(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<SellerInfo> userList = sellerInfoMapper.findUserList();
        PageInfo<SellerInfo> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public int insertUser(SellerInfo sellerInfo) {
        File f = new File("C://Users//Administrator//Desktop//图片//qrcode.png");

        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(f);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }

        try {

            sellerInfo.setImage(data);

            sellerInfoMapper.insertUser(sellerInfo);
        }catch (Exception e){
            System.out.println(e);
            logger.error(e.toString());
        }
        return sellerInfo.getId();

//        try {
//            bi = ImageIO.read(f);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(bi, "png", baos);
//            byte[] bytes = baos.toByteArray();
//            baos.close();
//
//            sellerInfo.setImage(bytes);
//
//            sellerInfoMapper.insertUser(sellerInfo);
//        }catch (Exception e){
//            System.out.println(e);
//            logger.error(e.toString());
//        }
//        return sellerInfo.getId();
    }

    @Override
    public int deleteUser(int id) {
        int a = sellerInfoMapper.deleteUser(id);
        return a;
    }

    @Override
    public int deleteUsers(String ids) {
        int a = sellerInfoMapper.deleteUsers(ids);
        return a;
    }

    @Override
    public Map<String, String> findUser(String username, String password) {
        SellerInfo sellerInfo = sellerInfoMapper.findUserByUserAndPwd(username,password);
        HashMap<String, String> hashMap = new HashMap<>();
        if(ObjectUtils.isEmpty(sellerInfo)){
            hashMap.put("code","201");
            return hashMap;
        }
        hashMap.put("code","200");
        return hashMap;
    }
}
