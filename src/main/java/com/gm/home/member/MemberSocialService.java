package com.gm.home.member;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Service
@Slf4j
public class MemberSocialService extends DefaultOAuth2UserService {
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		log.info("===== social Login 시도 =====");
		log.info("UserRequest {}", userRequest);
		
		log.info("AccessToken : {}", userRequest.getAccessToken());
		log.info("AdditionalParameter : {}", userRequest.getAdditionalParameters());
		log.info("ClientRegistration : {}", userRequest.getClientRegistration());
		
		
		String social = userRequest.getClientRegistration().getRegistrationId();
		
		log.info("Social : {}", social);
		
		OAuth2User auth2User2 = this.socialJoinCheck(userRequest);
		
		return auth2User2;
	}
	
	private OAuth2User socialJoinCheck(OAuth2UserRequest userRequest) {
		
		OAuth2User auth2User = super.loadUser(userRequest);
		log.info("===== 사용자 정보 =====");
		log.info("Name : {}", auth2User.getName());
		log.info("Attr : {}", auth2User.getAttributes());
		log.info("Auth : {}", auth2User.getAuthorities());
		
		Map<String, Object> map = auth2User.getAttributes();
		Iterator<String> keys = map.keySet().iterator(); // map 안에 있는 데이터를 꺼내는 함수, list는 아님
		while(keys.hasNext()) {
			String key = keys.next();
			log.info("Key : {}", key);
		}
		
		Map<String, String> lm = auth2User.getAttribute("properties");
		Map<String, Object> ka = auth2User.getAttribute("kakao_account");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(auth2User.getName()); // id 넣기
		// pw가 없으므로, 랜덤한 값으로 생성
		// memberVO.setPw(null);
		memberVO.setName(lm.get("nickname"));
		memberVO.setEmail(ka.get("email").toString());
		
		memberVO.setSocial(userRequest.getClientRegistration().getRegistrationId());
		
		memberVO.setAttributes(auth2User.getAttributes());
		
		// Role 임의 작성 - 원래는  DB에서 조회 후 작성
		List<RoleVO> list = new ArrayList<>();
		RoleVO roleVO = new RoleVO();
		roleVO.setRoleName("ROLE_MEMBER");
		list.add(roleVO);
		
		memberVO.setRoleVOs(list);
		
		return memberVO;
	}
}