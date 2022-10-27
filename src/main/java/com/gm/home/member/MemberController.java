package com.gm.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//회원가입	
	@GetMapping("add")
	public void setAdd() throws Exception {}
	
	@PostMapping("add")
	public String setAdd(MemberVO memberVO) throws Exception {
		int result = memberService.setAdd(memberVO);
		
		return "redirect:../";
	}
	
	//로그인
	@GetMapping("login")
	public void getLogin() throws Exception {}
	
	@PostMapping("login")
	public String getLogin(MemberVO memberVO, HttpSession session) throws Exception {
		
		memberVO = memberService.getLogin(memberVO);
		
		session.setAttribute("member", memberVO);
		
		return "redirect:../";
	}
	
	//로그아웃
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:../";
	}
	
	//아이디 중복확인
	@GetMapping("idCheck")
	@ResponseBody
	public Integer getIdCheck(MemberVO memberVO) throws Exception {
		
		Integer result = memberService.getIdCheck(memberVO);
		
		return result;
		
	}
	
	@PostMapping("test")
	@ResponseBody
	public MemberVO setTest(MemberVO memberVO, String [] ar) throws Exception {
		log.info("*******************************");
		log.info("ID : {}", memberVO.getId());
		log.info("Name : {}", memberVO.getName());
		for(String s : ar) {
			log.info("ar : {}", s);
		}
		return memberVO;
	}
}
