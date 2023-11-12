package com.coding404.myweb;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.service.ProductMapper;
import com.coding404.myweb.util.Criteria;

@SpringBootTest
public class PageTest {
	
	@Autowired
	private ProductMapper productMapper;

//	@Test
//	public void testCode() {
//		
//		for(int i = 1; i <= 100; i++) {
//			ProductVO vo = ProductVO.builder()
//					.prod_enddate("2023-05-11")
//					.prod_writer("ccc123")
//					.prod_name("test" + i)
//					.prod_price(1000+ i)
//					.prod_count(100 + i)
//					.prod_discount(1 + i)
//					.prod_purchase_yn("Y")
//					.prod_content("asdf" + i)
//					.prod_comment("test")
//					.build();
//			
//			productMapper.productRegist(vo);
//		
//		}
//		
//	}


	@Test
	public void testCode02() {
		Criteria cri = new Criteria(1, 10); //
		ArrayList<ProductVO> list = productMapper.getList("admin", cri);
		
		System.out.println(list.toString());
	}









}
