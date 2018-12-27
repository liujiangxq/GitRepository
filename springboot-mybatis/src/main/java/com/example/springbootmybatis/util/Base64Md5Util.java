package com.example.springbootmybatis.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Base64Md5Util {
	@SuppressWarnings("unused")
	//BASE64转码
	public static String base64(String str, String charset) throws UnsupportedEncodingException{
		//str要转义的内容，charset为编码集
        String encoded = Base64.encode(str.getBytes(charset));
        return encoded;   
    }   
    @SuppressWarnings("unused")
    //MD5加密
    public static String MD5(String str, String charset) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(charset));
        byte[] result = md.digest();
        StringBuffer sb = new StringBuffer(32);
        for (int i = 0; i < result.length; i++) {
            int val = result[i] & 0xff;
            if (val <= 0xf) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }
    @SuppressWarnings("unused")
    public static String urlEncoder(String str, String charset) throws UnsupportedEncodingException{
        String result = URLEncoder.encode(str, charset);
        return result;
    }
}
