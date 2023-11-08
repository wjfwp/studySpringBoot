package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@GetMapping("/productList")
	public String list(Model model) {
		
		//로그인 기능이 없으므로, admin이라는 계정 기반으로 조회
		String writer = "admin";
		
		ArrayList<ProductVO> list = productService.getList(writer);
		model.addAttribute("list", list);
		
		return "product/productList";
	}
	
	
	@GetMapping("/productReg")
	public String reg() {
		return "product/productReg";
	}
	
	
	@GetMapping("/productDetail")
	public String detail() {
		return "product/productDetail";
	}
	
	@PostMapping("/registForm")
	public String registForm(ProductVO vo, RedirectAttributes ra) {
		
		//System.out.println(vo.toString());
		
		int result = productService.productRegist(vo);
		String msg = result == 1 ? "등록 되었습니다." : "등록 실패, 관리자에게 문의하세요.";
		ra.addFlashAttribute("msg", msg);
		
		return "redirect:/product/productList";
	}
	
}
