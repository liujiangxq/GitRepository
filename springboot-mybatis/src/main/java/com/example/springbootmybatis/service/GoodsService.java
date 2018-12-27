package com.example.springbootmybatis.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
public interface GoodsService {
    public Map queryGoodsById(String goodsId);
    public JSONObject queryPublishRecord(int page, int limit,String username,String type);
}
