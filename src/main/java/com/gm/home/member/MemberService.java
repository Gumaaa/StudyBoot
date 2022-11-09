package com.gm.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Value("${social.kakao.admin}")
	private String adminKey;
	
	public int setDelete(MemberVO memberVO) throws Exception {
		
		int rs = 0;
		
		RestTemplate restTemplate = new RestTemplate();
		
		// Header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "KakaoAK " + adminKey);
		
		// parameter
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("target_id_type", "user_id");
		params.add("target_id", memberVO.getId());
		
		// 요청 객체
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(params, headers);
		
		// 전송 후 처리
		ResponseEntity<String> res = restTemplate.postForEntity("https://kapi.kakao.com/v1/user/unlink", req, String.class);
		
		log.info("res : {}", res.getBody());
		
		if (res.getBody() != null)
	      {
	         rs = 1;
	      }

	      return rs; // 탈퇴되면 1 리턴 | 안되면 0 리턴
	}
	
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

