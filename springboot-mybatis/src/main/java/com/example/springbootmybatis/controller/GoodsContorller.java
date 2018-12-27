package com.example.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootmybatis.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//cross跨域
@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class GoodsContorller {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @RequestMapping("/getUser")
    public String getUser(HttpServletResponse response) throws IOException {
        String sql = "select top 1 * from Goods";
        HashMap map = new HashMap<>();
        Map map1 = jdbcTemplate.queryForMap(sql, map);
        System.out.println(map1);
        response.getWriter().print("1");
        return "";
    }
    @RequestMapping("/getGoods")
    public String queryGoods() {
        Map map = goodsService.queryGoodsById("500");
        String str = JSON.toJSONString(map);
        System.out.println(str);
        JSONObject object = new JSONObject();
        ArrayList<Object> objects = new ArrayList<>();
        HashMap<Object, Object> hashMap = new HashMap<>();
        for (Object o : objects) {
            System.out.println(o);
        }
        return str;
    }

    @RequestMapping("/publishRecord")
    public JSONObject queryPublishRecord(int page, int limit, String username, String type) {
        System.out.println(username);
        JSONObject object = goodsService.queryPublishRecord(page, limit, username, type);
        System.out.println(object);
        String str = "123456";
        StringBuffer stringBuffer = new StringBuffer("123456");
        stringBuffer.reverse();
        return object;
    }
}