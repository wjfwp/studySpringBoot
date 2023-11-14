package com.coding404.myweb.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;
@Data //getter, setter, toString
public class PageVO {

	private int start; //시작페이지 네이션
	private int end; //끝페이지 네이션
	private boolean prev; //이전버튼 활성화여부
	private boolean next; //다음버튼 활성화여부
	private int total; //전체 게시글 개수
	private int realEnd; //실제 보여지는 끝번호
	
	//
	private int page; //cri에 있는 현재 조회하는 페이지
	private int amount; //cri에 있는 데이터 개수
	private Criteria cri; //페이지 기준
	
	private List<Integer> pageList; //페이지네이션을 리스트로 저장할 용도
	
	//페이지네이션 클래스는 cri와 total을 매개변후로 받음
	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.page = cri.getPage();
		this.amount = cri.getAmount();
		this.total = total;
		
		//end페이지 계산
		//page가 1을 가리킬 때, end = 10
		//page가 11을 가리킬 때, end = 20
		//this.end = (int)(Math.ceil( 현재조회하는 페이지 / 페이지네이션 개수) ) * 페이지네이션 개수;
		this.end = (int)(Math.ceil( this.page / 10.0) ) * 10;
		
		//start페이지 계산
		//this.start = this.end - 페이지네이션개수 + 1;
		this.start = this.end - 10 + 1;
		
		//실제끝번호의 계산 -> 데이터개수 10개 기준
		//총 게시글 수가 53개 -> 마지막 번호는 6
		//총 게시글 수가 232개 -> 마지막 번호는 24개
		//this.realEnd = (int)(Math.ceil( 전체게시글 / (double)데이터개수 ) );
		this.realEnd = (int)(Math.ceil( total / (double)this.amount ) );
		
		//end페이지 재결정
		//데이터가 25개 -> end = 10, realEnd = 3 (실제끝번호를 따라감)
		//데이터가 153개 -> end = 20, realEnd = 16 (실제끝번호를 따라감)
		//데이터가 153개(3번 페이지 조회시) -> end = 10, realEnd = 16(페이지네이션을 따라감)
		if(this.end > this.realEnd) {
			this.end = this.realEnd;
		}
		
		//prev활성화 여부
		//start페이지의 결정은 1, 11, 21, 31 ......
		this.prev = this.start > 1;
		
		//next활성화 여부
		//end = 10, realEnd = 16 이라고 할때, next버튼이 있다는 의미 
		this.next = this.realEnd > this.end;
		
		//타임리프 - 리스트에 페이지네이션을 담음
		this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().collect(Collectors.toList());
		
	}
	
}
