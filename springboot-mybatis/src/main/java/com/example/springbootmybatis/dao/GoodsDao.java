package com.example.springbootmybatis.dao;


import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
@Mapper
public interface GoodsDao {
    public Map queryGoodsById(String goodsId);
    public JSONArray queryPublishRecord(@Param("top") int top,@Param("rowNum") int rowNum,@Param("type") String type,@Param("username") String username);
    public int queryPublishRecordCount(@Param("type") String type,@Param("username") String username);
}
