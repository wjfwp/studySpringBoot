package com.project.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.basic.controller.HomeController;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	ApplicationContext applicationContext;

	@Value("${spring.datasource.hikari.url}")
	String url;
	
	@Bean
	public void test() {
		System.out.println(1);
		
		TestBean tb = applicationContext.getBean(TestBean.class);
		System.out.println(tb);
		
		HomeController hc = applicationContext.getBean(HomeController.class);
		System.out.println(hc);
		
		int a = applicationContext.getBeanDefinitionCount();
		System.out.println(a);
		
		System.out.println(url);
	}
	
	@Bean
	public TestBean test02() {
		TestBean b = new TestBean();
		return b;
	}
	
}
