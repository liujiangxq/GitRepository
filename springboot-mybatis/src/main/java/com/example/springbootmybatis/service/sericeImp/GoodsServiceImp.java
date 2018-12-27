package com.example.springbootmybatis.service.sericeImp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootmybatis.dao.GoodsDao;
import com.example.springbootmybatis.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class GoodsServiceImp implements GoodsService {
    @Resource
    private GoodsDao goodsDao;
    @Override
    public Map queryGoodsById(String goodsId) {
        System.out.println(goodsId);
        return goodsDao.queryGoodsById(goodsId);
    }

    @Override
    public JSONObject queryPublishRecord(int page, int limit,String username,String type) {
        int top = page*limit;
        int rowNum = (page-1)*10;
        JSONArray jsonArray = goodsDao.queryPublishRecord(top,rowNum,type,username);
        int count = goodsDao.queryPublishRecordCount(type,username);
        JSONObject object = new JSONObject();
        object.put("code",0);
        object.put("message","success");
        object.put("count",count);
        object.put("data",jsonArray);
        return  object;
    }
}
