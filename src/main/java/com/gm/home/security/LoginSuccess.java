package com.gm.home.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccess implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		
		log.info("#=#=#=#=#=#=#=# 로그인 성공 #=#=#=#=#=#=#=#=");
		log.info("Auth : {}", authentication);
		log.info("id : {}", request.getParameter("id"));
		
		String check = request.getParameter("rememberId");
		
		if(check != null) {
			Cookie cookie = new Cookie("userId", request.getParameter("id"));
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60); // 60초동안 쿠키를 유지하겠다.
			cookie.setPath("/"); // 쿠키를 어느 도메인에서 사용가능하냐 "/member"면 member에서만 사용하겠다 // 같은 도메인 내에서 어느 URL에서 사용 가능한가
			
			response.addCookie(cookie);
		} else {
			Cookie [] cookies = request.getCookies();
			
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("userId")) {
					cookie.setMaxAge(0);
					cookie.setPath("/"); // cookie 삭제 시 cookie를 만들 때의 path와 동일해야 됨 아니면 안 지워짐
					response.addCookie(cookie);
					
					break;
				}
			}
		}
		
		response.sendRedirect("/");
		
		
	}
}
