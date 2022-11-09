package com.gm.home.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Data;

@Data
public class MemberVO implements UserDetails, OAuth2User{
	
	@NotBlank(message = "아이디 입력해라;;;")
	private String id;
	@NotBlank
	private String pw;
	private String pwCheck;
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@Range(max=100, min=1)
	private int age;
	@Past
	private Date birth;
	private boolean enabled;
	
	private List<RoleVO> roleVOs;
	
	// ##### Socoal Login #####
	// Kakao, Naver, Google 
	private String social;
	
	//OAuth2User, Token, ...등 정보 저장
	private Map<String, Object> attributes;
	
	
	@Override
	public Map<String, Object> getAttributes() {
		
		return this.attributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// ?는 any 를 뜻함, extends GrantedAuthority 를 상속받는 아무타입이면 된다.
		// <? super T> T나 T의 부모타입을 허용하겠다 라는 뜻
		
		// List는 interface여서 객체 생성 불가 
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
			
		}
		
		return authorities;
	}
	
	// return 값 VO에 지정한 아이디, 비밀번호로 수정
	@Override
	public String getPassword() {
		// PW 반환
		return this.pw;
	}
	
	// return 값 VO에 지정한 아이디, 비밀번호로 수정
	@Override
	public String getUsername() {
		// ID 반환
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired() { // 계정이 만료되지 않았습니까?
		// 계정의 만료 여부
		// true  : 만료 안 됨
		// false : 만료 됨, 로그인 불가
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 계정이 잠기지 않았습니까?
		// 계정의 잠김 여부
		// true  : 계정이 잠기지 않음
		// false : 계정이 잠김, 로그인 불가
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 만료
		// 비밀번호 만료 여부
		// true  : 만료 안 됨
		// false : 만료 됨, 사용 불가, 로그인 안 됨
		return true;
	}
	
	// isEnabled
	public boolean isEnabled() {
		// 계정 사용 여부
		// true  : 계정 활성화(계정 사용 가능)
		// false : 계정 비활성화(계정 사용 불가능, 로그인 불가)		
		return true;
	}

	
}
