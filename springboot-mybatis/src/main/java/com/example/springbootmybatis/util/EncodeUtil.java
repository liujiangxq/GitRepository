package com.example.springbootmybatis.util;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.UnsupportedEncodingException;
/**
 * base64编码
 * */
public class EncodeUtil {
    public String encode(String str) {
        if(str==""||str==null){
            try {
                throw new Exception("string is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  Base64.encode(str.getBytes());
    }
    public String decode(String str)  {
        if(str==""||str==null){
            try {
                throw new Exception("string is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        byte[] decode = Base64.decode(str);
        String s = null;
        try {
            s = new String(decode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  s;
    }
    public static void main(String[] args) throws Exception {
        String str ="{\n" +
                "\t\"goodsNo\": \"JH077\",\n" +
                "\t\"recordTime\": 1539758583657,\n" +
                "\t\"userNo\": \"uzb00006\",\n" +
                "\t\"codeMsg\": \"success\",\n" +
                "\t\"ROWID\": 3,\n" +
                "\t\"statusCode\": \"0\"\n" +
                "}";
        String encode = new EncodeUtil().encode(str);
        String decode = new EncodeUtil().decode(encode);

    }
}
