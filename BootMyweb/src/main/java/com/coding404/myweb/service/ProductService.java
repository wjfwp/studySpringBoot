package com.coding404.myweb.service;

import java.util.ArrayList;

import com.coding404.myweb.command.ProductVO;

public interface ProductService {

	public int productRegist(ProductVO vo);
	public ArrayList<ProductVO> getList(String writer);
	
}
