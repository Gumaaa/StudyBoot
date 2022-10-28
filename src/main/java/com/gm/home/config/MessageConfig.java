package com.gm.home.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageConfig implements WebMvcConfigurer {
	
	@Bean // 내가 선언한 클래스를 사용하는 게 아니라 라이브러리 클래스를 사용해서? Bean 선언
	public LocaleResolver locale() { //session, cookie 둘 중 하나만 사용하면 됨
		//1. session
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREAN);
		
		//2. Cookie
		CookieLocaleResolver cResolver = new CookieLocaleResolver();
		cResolver.setDefaultLocale(Locale.KOREAN);
		cResolver.setCookieName("lang");
		
		// session
		//return resolver;
		
		// Cookie
		return cResolver;
	}
	
	// Interceptor 객체
	@Bean
	public LocaleChangeInterceptor changeInterceptor() {
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		// parameter를 받아서 언어 구분
		// url?lang=en
		changeInterceptor.setParamName("lang");
		
		return changeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
	}

	//***-context.xnl
	// <bean class="" id=""> - new 생성자(객체 생성 코드)	
	//@Bean("my")
	//public String getString() {
	//		
	//	return new String();
	//}
	
}
