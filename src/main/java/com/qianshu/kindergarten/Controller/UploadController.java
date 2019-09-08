package com.qianshu.kindergarten.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
@Api(value = "文件上传接口",description = "文件上传接口")
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传", notes = "文件上传")
    public Map<String, Object> upload(HttpServletRequest request, HttpServletResponse response, @RequestParam("file")MultipartFile file) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            //上传目录地址
            //String uploadDir = request.getSession().getServletContext().getRealPath("/") + "/upload/";
            String uploadDir = "E://上传测试文件夹/";
            //如果目录不存在，自动创建目录
            /*File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }*/
            //调用上传方法
            executeUpload(uploadDir, file);
            hashMap.put("status",200);
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            hashMap.put("status",201);
            return hashMap;
        }
        return hashMap;
    }

    /**
     * 提取文件上传的公用代码
     *
     * @param uploadDir //文件储存路径
     * @param file      //要上传的文件
     */
    private void executeUpload(String uploadDir, MultipartFile file) {

        //文件后缀名
        //String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        //String fileName = UUID.randomUUID() + suffix;
        //文件名为当前日期，如2018101310243010（2018年10月13日10时24分。。。），再加上studentId
        String fileName = file.getOriginalFilename();
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + fileName);
        //将上传的文件写入到服务器端文件内
        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ApiOperation(value = "文件下载", notes = "文件下载")
    public void download( HttpServletResponse response) throws UnsupportedEncodingException {
        //要上传的文件名字  error.2019-06-01.log  商户-微信电子会员卡合作方案介绍(1).docx
        String fileName = "商户-微信电子会员卡合作方案介绍(1).docx";
        String tempFileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
        //通过文件的保存文件夹路径加上文件的名字来获得文件 E://var//log//tomcat//sell/  E://上传测试文件夹/
        File file = new File("E://上传测试文件夹/", fileName);
        //当文件存在
        if (file.exists()) {
            //首先设置响应的内容格式是force-download，那么你一旦点击下载按钮就会自动下载文件了
            response.setContentType("application/force-download");
            //通过设置头信息给文件命名，也即是，在前端，文件流被接受完还原成原文件的时候会以你传递的文件名来命名
            response.addHeader("Content-Disposition", String.format("attachment; filename=\"%s\"",java.net.URLEncoder.encode(fileName, "UTF-8")));
            //进行读写操作
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                //从源文件中读
                int i = bis.read(buffer);
                while (i != -1) {
                    //写到response的输出流中
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //善后工作，关闭各种流
                try {
                    if (bis != null) {
                        bis.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
