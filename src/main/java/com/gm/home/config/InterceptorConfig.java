package com.gm.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gm.home.interceptors.StudyInterceptor;
import com.gm.home.interceptors.TestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired //IOC(Inversion Of Controll)
	private TestInterceptor testInterceptor;
	
	@Autowired
	private StudyInterceptor studyInterceptor;
	
	@Override
		public void addInterceptors(InterceptorRegistry registry) {
		
			//method chaining
			//적용할 Interceptor 등록
			registry.addInterceptor(testInterceptor)
			//Interceptor를 적용할 URL 등록
			.addPathPatterns("/qna/**")
			//제외할 URL 등록
			.excludePathPatterns("/qna/detail")
			.excludePathPatterns("/qna/write");
		
			
			// 추가 Interceptor 등록
			registry.addInterceptor(studyInterceptor)
			.addPathPatterns("/qna/**");
			//WebMvcConfigurer.super.addInterceptors(registry);
		}
}
