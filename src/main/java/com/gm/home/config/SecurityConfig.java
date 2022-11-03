package com.gm.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	//public 선언하면 default로 바꾸라는 메세지 출력
	WebSecurityCustomizer webSecurityCustomizer() {
		
		// Security에서 무시해야하는 URL 패턴 등록
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/favicon/**")
				.antMatchers("/resources/**");
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
					.cors()
					.and()
					.csrf()
					.disable() // cors, and, csrf를 disable 시키겠다
				.authorizeRequests() // 구분하기 위해 앞으로 땡김
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/manager").hasRole("MANAGER")
					.antMatchers("/qna/list").permitAll()
					.antMatchers("/qna/**").hasRole("MEMBER")
					//.anyRequest().authenticated() // admin, manager도 아닌 그외 나머지들은 로그인 했을 때만
					.anyRequest().permitAll() // 그외 나머지는 모두 허용
					.and()
				.formLogin() //로그인 폼 인증 설정
					.loginPage("/member/login") // 내장된 로그인폼을 사용하지 않고 개발자가 만든 로그인폼 요청URL
					//.loginProcessingUrl("login") // 로그인을 진행 요청할 form 태그의 action의 주소 지정, 필요없음
					.passwordParameter("pw") // 패스워드 파라미터는 password이지만, 개발자가 다른 이름으로 파라미터 이름을 사용할 때
					.usernameParameter("id") // 아이디 파라미터는 username이지만, 개발자가 다른 이름으로 파라미터 이름을 사용할 때
					.defaultSuccessUrl("/") // 인증에 성공할 경우 요청할 URL, 로그인에 성공했을 경우
					.failureUrl("/member/login") // 인증에 실패했을 경우 요청할 URL, 로그인에 실패했을 경우
					.permitAll()
					.and()
				.logout()
					.permitAll();
					
		return httpSecurity.build();
	}

}
