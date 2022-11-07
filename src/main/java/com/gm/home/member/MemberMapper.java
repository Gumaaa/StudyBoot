package com.gm.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface MemberMapper {
	
	public int setAdd(MemberVO memberVO) throws Exception;
	
	public MemberVO getLogin(String username) throws UsernameNotFoundException;
	
	public int setRole(MemberVO memberVO) throws Exception;
	
	public Integer getIdCheck(MemberVO memberVO) throws Exception;
}
