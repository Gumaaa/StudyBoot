package com.gm.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

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
	
	// 로그인 처리는 MemberSecurityService에서 처리함
	//로그인
//	public MemberVO getLogin(MemberVO memberVO) throws Exception {
//		
//		return memberMapper.getLogin(memberVO);
//	}
	
	//아이디 중복확인
	public Integer getIdCheck(MemberVO memberVO) throws Exception {
		
		return memberMapper.getIdCheck(memberVO);
	}
	
	//사용자 정의 검증 메서드
	public boolean getMemberCheck(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean check = false;
		//check = false : 검증 성공(error 없음)
		//check = true  : 검증 실패(error 있음)
		
		//1. annotation 검증
		check = bindingResult.hasErrors(); //error가 있으면 true, 없으면 false
		
		//2. password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {
			check=true;
			
			//에러메시지
			//bindingResult.rejectValue("멤버변수명(path)", "properties의 key(코드)");
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
		}
		
		//3. ID가 중복인지 검증
		int result = memberMapper.getIdCheck(memberVO);
		
		if(result > 0) {
			check=true;
			bindingResult.rejectValue("id", "member.id.equal");
		}
		
		return check; 
	}
}

