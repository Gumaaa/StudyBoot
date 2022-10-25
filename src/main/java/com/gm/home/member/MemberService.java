package com.gm.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	//회원가입
	public int setAdd(MemberVO memberVO) throws Exception {
		int result = memberMapper.setAdd(memberVO);
		memberMapper.setRole(memberVO);
		
		return result;
	}
	
	//로그인
	public MemberVO getLogin(MemberVO memberVO) throws Exception {
		
		return memberMapper.getLogin(memberVO);
	}
}

