package com.simple.basic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.SimpleVO;

@Controller
@RequestMapping("/view")
public class ViewController {

	//@RequestMapping(value = "/ex01", method = RequestMethod.GET)
	@GetMapping("/ex01")
	public String ex01() {
		return "view/ex01"; //템플릿 폴더 밑이 기준
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		SimpleVO vo = SimpleVO.builder()
				              .sno(1)
				              .first("홍길동")
				              .regdate(LocalDateTime.now())
				              .build();
		
		ArrayList<SimpleVO> list = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			SimpleVO simpleVO = SimpleVO.builder()
						              .sno(i)
						              .first("홍길동" + i)
						              .regdate(LocalDateTime.now())
						              .build();
		
			list.add(simpleVO);
		}
		
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		
		return "view/ex02";
	}
	
	//ex03 - a링크의 사용
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		ArrayList<SimpleVO> list = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			SimpleVO simpleVO = SimpleVO.builder()
						              .sno(i)
						              .first("홍길동" + i)
						              .regdate(LocalDateTime.now())
						              .build();
		
			list.add(simpleVO);
		}
		
		model.addAttribute("list", list);
		
		return "view/ex03";
	}
	
	//키를 받는 첫번째 방법 - 쿼리스트링
	@GetMapping("/result")
	public String ex03_result(@RequestParam("sno") int sno,
							  @RequestParam("first") String first) {
		
		System.out.println("넘어온값:" + sno + ", " + first);
		
		return "view/ex03_result";
	}
	
	//키를 받는 두번째 방법 - URL파람
	@GetMapping("/result02/{a}/{b}")
	public String ex03_result02(@PathVariable("a") String name,
								@PathVariable("b") int age) {
		
		System.out.println("넘어온값:" + name + ", " + age);
		
		return "view/ex03_result";
	}
	
}
