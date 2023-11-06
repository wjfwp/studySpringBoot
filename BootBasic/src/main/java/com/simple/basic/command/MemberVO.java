package com.simple.basic.command;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	
	@Pattern(message = "아이디는 영문자,숫자 8자 이상입니다.", regexp = "[a-zA-Z0-9]{8,}")
	private String id;
	
	@Pattern(message = "비밀번호 영문자,숫자,특수문자 조합 8글자 이상입니다.", regexp = "^(?=.*\\d)(?=.*[a-zA-Z!@#$%^&*()_+{}|:\"<>?\\[\\]\\\\;',./]).{8,}$")
	private String pw;
}
