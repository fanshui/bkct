package com.bkct.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class CheckEncode {
    private static Logger logger = LoggerFactory.getLogger(CheckEncode.class);
	public static String getEncoding(String str){
        try {
            String encode = "gb2312";
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GB2312
                 logger.info("info com.bkct.util CheckEncode gb2312");
                 logger.debug("debug com.bkct.util CheckEncode gb2312");
                 logger.error("error com.bkct.util CheckEncode gb2312");
                return encode;
            }
            encode = "ISO-8859-1";
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是ISO-8859-1
                return encode;
            }
            encode = "UTF-8";
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是UTF-8
                return encode;
            }
            encode = "GBK";
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GBK
                return encode;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "UNKNOWN"; //如果都不是，说明输入的内容不属于常见的编码格式。
   }

    public static String utf8Togb2312(String data) throws UnsupportedEncodingException{
        if (data != null) {
            byte[] bytes = data.getBytes("utf-8");
            data = new String(bytes, "gb2312");
        }
        else {
            data = "";
        }
        return data;
    }
    public static String gb2312Toutf8(String data) throws UnsupportedEncodingException{
        if (data != null) {
            byte[] bytes = data.getBytes("gb2312");
            data = new String(bytes, "utf-8");
        }
        else {
            data = "";
        }
        return data;
    }
}
