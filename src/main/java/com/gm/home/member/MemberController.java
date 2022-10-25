package com.gm.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//회원가입	
	@GetMapping("/member/add")
	public void setAdd() throws Exception {}
	
	@PostMapping("/member/add")
	public String setAdd(MemberVO memberVO) throws Exception {
		int result = memberService.setAdd(memberVO);
		
		return "redirect:../";
	}
	
	//로그인
	@GetMapping("/member/login")
	public void getLogin() throws Exception {}
	
	@PostMapping("member/login")
	public String getLogin(MemberVO memberVO, HttpSession session) throws Exception {
		
		memberVO = memberService.getLogin(memberVO);
		session.setAttribute("member", memberVO);
		
		return "redirect:../";
	}
	
	//로그아웃
	@GetMapping("/member/logout")
	public String getLogout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:../";
	}
}
