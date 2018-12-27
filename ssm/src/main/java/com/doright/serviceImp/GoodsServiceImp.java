package com.doright.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doright.dao.GoodsDao;
import com.doright.service.GoodsService;
@Service
public class GoodsServiceImp implements GoodsService{
	@Autowired
	private GoodsDao goodsDao;
	public String queryGoods(){
		
		return goodsDao.queryGoods();
	}
}
