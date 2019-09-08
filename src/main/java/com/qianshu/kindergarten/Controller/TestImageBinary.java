package com.qianshu.kindergarten.Controller;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;

public class TestImageBinary {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    static String getImageBinary(){
        File f = new File("C://Users//Administrator//Desktop//图片//qrcode.png");
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);
            byte[] bytes = baos.toByteArray();
            baos.close();

            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void base64StringToImage(String base64String){
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);

            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 =ImageIO.read(bais);
            File w2 = new File("C://Users//Administrator//Desktop//图片//qrcode111111.png");//可以是jpg,png,gif格式
            ImageIO.write(bi1, "png", w2);//不管输出什么格式图片，此处不需改动
            bais.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*--------------------------------------------------------------------------------------------------------*/

    public static void image() throws IOException {
        File f = new File("C://Users//Administrator//Desktop//图片//qrcode.png");
        FileInputStream fis = new FileInputStream(f); //创建输入流
        byte[] byt = new byte[fis.available()]; //字节数据      available() 返回的实际可读字节数，也就是总大小
        StringBuilder str = new StringBuilder();// 不建议用String
        fis.read(byt); // 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b  中。以整数形式返回实际读取的字节数。
        for (byte bs : byt) {
            // 将字节数组byte[] 转换为二进制,在以字符串的形式显示出来
            //Integer.toBinaryString(bs)返回无符号整数的二进制的字符串表示形式
            str.append(Integer.toBinaryString(bs));
        }
        fis.close();
        str.toString();

        System.out.println("输出二进制字符串+==="+str);

        //把字节数组的图片写到另一个地方
        /*File apple = new File("C://Users//Administrator//Desktop//图片//qrcode111111.png");
        FileOutputStream fos = new FileOutputStream(apple);
        fos.write(byt);
        fos.flush();
        fos.close();*/
    }

    /*--------------------------------------------------------------------------------------------------------*/

    //图片到byte数组
    public static byte[] image2byte(){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File("C://Users//Administrator//Desktop//图片//qrcode.png"));
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
        return data;
    }
    //byte数组到图片
    public void byte2image(byte[] data,String path){
        if(data.length<3||path.equals("")) return;
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }
    //byte数组到16进制字符串
    public String byte2string(byte[] data){
        if(data==null||data.length<=1) return "0x";
        if(data.length>200000) return "0x";
        StringBuffer sb = new StringBuffer();
        int buf[] = new int[data.length];
        //byte数组转化成十进制
        for(int k=0;k<data.length;k++){
            buf[k] = data[k]<0?(data[k]+256):(data[k]);
        }
        //十进制转化成十六进制
        for(int k=0;k<buf.length;k++){
            if(buf[k]<16) sb.append("0"+Integer.toHexString(buf[k]));
            else sb.append(Integer.toHexString(buf[k]));
        }
        return "0x"+sb.toString().toUpperCase();
    }

    /*--------------------------------------------------------------------------------------------------------*/

    public static void main(String[] args) throws IOException {
        //System.out.println(getImageBinary());

        //base64StringToImage(getImageBinary());

        //image();

        byte[] bytes = image2byte();
        System.out.println(bytes.length);
    }
}
