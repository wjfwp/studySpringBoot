package com.coding404.myweb.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;

@Mapper
public interface ProductMapper {

	public int productRegist(ProductVO vo);
	
	//public ArrayList<ProductVO> getList(String writer); //조회
	public ArrayList<ProductVO> getList(@Param("writer") String writer, 
										@Param("cri") Criteria cri); //조회 
	
	public ProductVO getDetail(int prod_id);
	public int productUpdate(ProductVO vo);
	public void productDelete(int prod_id);
	
	
}
