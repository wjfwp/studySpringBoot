package com.coding404.myweb.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.ProductVO;
@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public int productRegist(ProductVO vo) {
		return productMapper.productRegist(vo);
	}

	@Override
	public ArrayList<ProductVO> getList(String writer) {
		return productMapper.getList(writer);
	}

}
