package com.gm.home.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	public int setAdd(MemberVO memberVO) throws Exception;
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	
	public int setRole(MemberVO memberVO) throws Exception;
	
	public int getIdCheck(MemberVO memberVO) throws Exception;
}
