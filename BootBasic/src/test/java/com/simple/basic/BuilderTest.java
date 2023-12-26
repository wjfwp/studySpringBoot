package com.simple.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.BuilderVO;

@SpringBootTest
public class BuilderTest {

	@Test
	public void testcode() {
		BuilderVO vo = BuilderVO.builder().age(33).name("di").build();
		System.out.println(vo.toString());
	}
}
