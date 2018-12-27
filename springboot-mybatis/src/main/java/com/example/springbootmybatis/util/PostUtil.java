package com.example.springbootmybatis.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PostUtil {
	public static String sendPost(String urlStr) {
	    PrintWriter out = null;  
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(urlStr);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("charsert", "UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
            	result += line;
            }
        } catch (Exception e) {
        	System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        finally{
            try{
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
	
	public static String SendPosts(String Url,String JsonXml){
		String Result = "";
        try {
            	URL url = new URL(Url);
            	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
//	            conn.setRequestMethod("Post");
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            conn.setRequestProperty("Content-Type", "application/json");
	            conn.connect();
	            OutputStreamWriter writer = new OutputStreamWriter((conn.getOutputStream()), "UTF-8");
	            writer.write(new String(JsonXml.getBytes("UTF-8")));
	            writer.flush();
	            StringBuffer answer = new StringBuffer();
	            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
	            BufferedReader reader = new BufferedReader(isr);
	            String line="";
	            while ((line = reader.readLine()) != null) {
	                answer.append(line);
	            }
	            Result = answer.toString();
	            reader.close();
	            writer.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return Result;
	}
}
