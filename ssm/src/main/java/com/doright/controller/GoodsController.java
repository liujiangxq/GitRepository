package com.doright.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doright.service.GoodsService;

@RestController	//Ïàµ±ÓÚ@controller + responseBody
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/queryGoods")
	public String queryGoods(){
		String queryGoods = goodsService.queryGoods();
		System.out.println(queryGoods);
		return queryGoods;
	}
}
