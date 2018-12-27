package com.example.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootmybatis.util.PostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ShangFan {
    public String refundInStorage(){
        String str = "{"+
       " \"data\": {"+
       "     \"signinfo\": {"+
        "          \"method\": \"com.bizvane.sun.wx.method.outdoor.refund.InStorage\","+
        "        \"sign\": \"4556D50C61328D6623FD9069CD8633AB\","+
        "        \"customcode\": \"wx44031a94f68ba97e\","+
        "        \"ts\": \"1531103595118\""+
        "   },"+
        "    \" refund_no \": \"OR2017010514510147870\","+
        "    \"isexamine\": \"Y\""+
        "}";

        String resp =  PostUtil.SendPosts("http://www.dev-wechat.bizvane.com/new/outdoor",str);
        System.out.println(resp);

        return "";
    }

    public String refund(){

        String str = "{"+
                "	\"data\": {"+
                "		\"ltconfig\": \"WX_REFUND\","+
                "		\"pagenow\": 0,"+
                "		\"pagesize\": 10,"+
                "		\"columns\": \"TRACKING_NUMBER\","+
                "		\"condition\": \"state==1\","+
                "		\"mask\": 7,"+
                "		\"intables\": [{"+
                "			\"ltconfig\": \"WX_REFUNDITEM\","+
                "			\"refcolumn\": \"WX_REFUND_ID\","+
                "			\"type\": \"list\","+
                "			\"columns\": \"WX_PRODUCT_ID;NAME,WX_ORDERITEM_ID;RETIRED_COUNT\","+
                "			\"condition\": \"\","+
                "			\"pagenow\": 0,"+
                "			\"pagesize\": 10"+
                "		}],"+
                "		\"signinfo\": {"+
                "			\"customcode\": \"wx44031a94f68ba97e\","+
                "			\"ts\": \"1531103595118\","+
                "			\"sign\": \"4556D50C61328D6623FD9069CD8633AB\","+
                "			\"method\": \"com.bizvane.sun.wx.method.GetJSONArray\""+
                "		}"+
                "	}"+
                "}";
        String resp = PostUtil.SendPosts("http://www.dev-wechat.bizvane.com/new/outdoor",str);
        System.out.println(resp);
        return "";
    }

    public static void main(String[] args) {
        ShangFan shangFan = new ShangFan();
        shangFan.refundInStorage();
        shangFan.refund();
    }
}
