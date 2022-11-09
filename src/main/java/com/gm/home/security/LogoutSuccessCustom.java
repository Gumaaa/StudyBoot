package com.gm.home.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.gm.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogoutSuccessCustom implements LogoutSuccessHandler {
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	private String kakaoId;

	@Value("${kakao.redirect-uri.logout}")
	private String redirect_uri;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		log.info("===== logout 성공 시 실행 =====");
		// 1. 일반 로그인인지 or 소셜 로그인인지
		log.info("auth : {}", authentication);

		MemberVO memberVO = (MemberVO) authentication.getPrincipal(); // memberVO
		String social = memberVO.getSocial();

		if (social != null) {
			if (social.equals("kakao")) {
				
				// https://developers.kakao.com/logout
				// response.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id=" + kakaoId + "&logout_redirect_uri=" + redirect_uri);
//				RestTemplate restTemplate = new RestTemplate();
//				// header X
//				// parameter X
//				MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//				map.add("client_id", "9f9e4e51747cf98c72c57370f2401889");
//				
//				HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String,String>>(map);
//				
//				log.info("KaKao Logout");
//				ResponseEntity<String> res = restTemplate.getForEntity("https://developers.kakao.com/logout", null, String.class);
//				log.info("res : {}", res);
//				
//				response.sendRedirect("/");

				try {
					response.sendRedirect(
							"https://kauth.kakao.com/oauth/logout?client_id=" + kakaoId + "&logout_redirect_uri=" + redirect_uri);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			} else if (social.equals("google")) {

			}
		} else {
			response.sendRedirect("/");
		}

//				if(social != null && social.equals("kakao")) {
//					
//				} else if(social != null && social.equals("google")) {
//					
//				} else {
//					
//				}

	}
}
