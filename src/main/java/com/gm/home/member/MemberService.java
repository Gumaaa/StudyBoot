package com.gm.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	//회원가입
	public int setAdd(MemberVO memberVO) throws Exception {
		int result = memberMapper.setAdd(memberVO);
		
		if(result < 1) {
			throw new Exception();
		}
		
		memberMapper.setRole(memberVO);
		
		if(result < 1) {
			throw new Exception();
		}
		
		return result;
	}
	
	//로그인
	public MemberVO getLogin(MemberVO memberVO) throws Exception {
		
		return memberMapper.getLogin(memberVO);
	}
	
	//아이디 중복확인
	public int getIdCheck(MemberVO memberVO) throws Exception {
		
		return memberMapper.getIdCheck(memberVO);
	}
}

