package com.simple.basic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.basic.command.SimpleVO;

@RestController //@ResponseBody + @Controller
public class RestBasicContoller {

	@GetMapping("/basic")
	public String basic() {
		return "<h3>hello world</h3>";
	}
	
	//데이터를 보내는 방법 -> @ResponseBody = 자바의 객체를 JSON형식으로 자동 변환
	@GetMapping("getObject")
	public SimpleVO getObject() {
		SimpleVO vo = new SimpleVO(1, "홍", "길동", LocalDateTime.now() );
		return vo;
	}
	
	@GetMapping("/getMap")
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "홍길동");
		
		return map;
	}
	
	@GetMapping("/getList")
	public List<SimpleVO> getList() {
		List<SimpleVO> list = new ArrayList<>();
		list.add(new SimpleVO(1, "홍", "길동", LocalDateTime.now()));
		list.add(new SimpleVO(2, "이", "순신", LocalDateTime.now()));
		
		return list;
	}
	
	//데이터를 받는 방법
	//get => 쿼리스트링 or 쿼리파라미터 이용해서 주소에 담아서 넘김
	//post => 폼형식 or json을 이용해서 body에 담아서 넘김
	//http://localhost:8181/getData?sno=1&first=홍길동
	@GetMapping("/getData")
	public SimpleVO getData(SimpleVO vo) {
		
		System.out.println(vo.toString());
		
		return new SimpleVO(2, "이", "순신", LocalDateTime.now());
	}
	
	//http://localhost:8181/getData2?sno=1&first=홍길동
	//@RequestParam은 필수값이 된다. sno, first는 필수
	@GetMapping("/getData2")
	public SimpleVO getData2(@RequestParam("sno") int sno,
							 @RequestParam("first") String first) {
		
		System.out.println(sno);
		System.out.println(first);
		
		return new SimpleVO(2, "이", "순신", LocalDateTime.now());
	}
	
	//http://localhost:8181/getData3/2/이순신
	@GetMapping("/getData3/{sno}/{first}")
	public SimpleVO getData3(@PathVariable("sno") int sno,
							 @PathVariable("first") String first) {
		
		System.out.println(sno);
		System.out.println(first);
		
		return new SimpleVO(2, "이", "순신", LocalDateTime.now());
	}
	
	//////////////////////////////////////////////////////
	//post방식의 데이터 받기
	
	//보내는 입장에서 form형식의 데이터를 써줘야함
	@PostMapping("/getForm")
	public SimpleVO getForm(SimpleVO vo) {
		
		System.out.println(vo.toString());
		
		return new SimpleVO(2, "이", "순신", LocalDateTime.now());
	}
	
	//보내는 입장에서 JSON형식의 데이터를 써줘야함
	//받는 입장에서는 @RequestBody 적용하기
	//{"sno" : 1, "first" : "홍길동", "last" : "이순신신" }
	@PostMapping("/getJSON")
	public SimpleVO getJson(@RequestBody SimpleVO vo) {
		System.out.println(vo.toString());
		return new SimpleVO(2, "이", "순신", LocalDateTime.now());
	}

	//JSON형식은 Map과 같기 때문에 받을 수 있음
	@PostMapping("/getJSON2")
	public SimpleVO getJson2(@RequestBody Map<String, Object> map) {

		System.out.println(  map.toString() );
		return new SimpleVO(2, "이", "순신", LocalDateTime.now());
	}
	
	
	/////////////////////////////////////////////////////////////
	//consumer = 반드시 이 타입으로 보내라! 명시
	//producer = 내가 이 타입으로 줄게! 명시 (default = json), xml을 사용하려면 xml데이터바인딩 라이브러리가 필요함
	
	//보내는 타입은 text로 줄게, 너는 json데이터로 보내라
	@PostMapping(value = "/getResult", produces = "text/plain", consumes = "application/json")
	public String getResult(@RequestBody String str) {
		
		System.out.println(str);
		
		return "<h3>문자열</h3>";
	}
	
	
	
	
	
	
	
	
	
	
			
}
