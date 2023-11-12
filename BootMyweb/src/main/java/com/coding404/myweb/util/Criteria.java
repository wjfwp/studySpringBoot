package com.coding404.myweb.util;

import lombok.Data;

@Data //getter, setter, toString
public class Criteria {

	private int page; //조회하는 페이지
	private int amount; //데이터 개수
	
	//기본생성자로 만들어지면 1, 10 이 기본값
	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}
	
	//기본생성자가 아니면 값을 전달 받음
	public Criteria(int page, int amoont) {
		this.page = page;
		this.amount = amount;
	}
	
	
	//페이지 시작을 지정하는 getter
	public int getPageStart() {
		return (page - 1) * amount;
	}
	
	
	
}
