package com.gm.home.member;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void setAdd(@ModelAttribute MemberVO memberVO) throws Exception {
//		MemberVO memberVO = new MemberVO();
//		
//		model.addAttribute(memberVO);
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv) throws Exception {
//		int result = memberService.setAdd(memberVO);
		
//		if(bindingResult.hasErrors()) {
//			// 검증에 실패하면 회원가입하는 jsp로 foward
//			log.info("===== 비상비상-! 검증 에러 =====");
//			mv.setViewName("member/add");
//			
//			return mv;
//		}
		
		boolean check = memberService.getMemberCheck(memberVO, bindingResult);
		if(check) {
			log.info("===== 비상비상-! 검증22 에러 =====");
			mv.setViewName("member/add");
			//====================================
			List<FieldError> errors = bindingResult.getFieldErrors();
			
			 for(FieldError fieldError : errors) {
	            log.info("fieldError: {}", fieldError);
	            log.info("Field: {}", fieldError.getField());
	            log.info("Message: {}", fieldError.getRejectedValue());
	            log.info("Defalut: {}", fieldError.getDefaultMessage());
	            log.info("Code: {}", fieldError.getCode());
	            log.info("============================================");
	            mv.addObject(fieldError.getField(), fieldError.getDefaultMessage());
	         }
			
			return mv;
		}
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	//로그인
	@GetMapping("login")
	public void getLogin(@RequestParam(defaultValue = "false", required = false) Boolean error, String message, Model model) throws Exception {
		if(error) {
			model.addAttribute("msg", "ID 또는 PW를 확인하세요.");
		}
		//Controller에서 받아서 JSP로 다시 보내도 됨
	}
	
	@PostMapping("login")
	public String getLogin() throws Exception {
		
		log.info("===== LOGIN POST =====");
		
		return "member/login";
	}
	
	//로그아웃
//	@GetMapping("logout")
//	public String getLogout(HttpSession session) throws Exception {
//		log.info("----- 내가 만든 로그아웃 -----");
//		session.invalidate();
//		
//		return "redirect:../";
//	}
	
	//아이디 중복확인
	@GetMapping("idCheck")
	@ResponseBody
	public Integer getIdCheck(MemberVO memberVO) throws Exception {
		
		Integer result = memberService.getIdCheck(memberVO);
		
		return result;
		
	}
	
	@GetMapping("mypage")
	public void getMyPage() throws Exception {
		
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
