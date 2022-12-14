package com.gm.home.board.qna;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gm.home.util.Pager;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private QnaService qnaService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ModelAttribute
	public String getBoard() {
		
		return "qna";
	}
	
	@PostMapping("summerFileDelete")
	@ResponseBody
	public boolean setSummerFileDelete(String fileName) throws Exception {
		log.info("fileNAme : {}", fileName);
		
		
		return qnaService.setSummerFileDelete(fileName); 
	}
	@PostMapping("summerFile")
	@ResponseBody
	public String setSummerFile(MultipartFile file) throws Exception {
		log.info("File => {}", file);
		
		String result = qnaService.setSummerFile(file);
		
		return result;
	}
	
	@GetMapping("hack")
	@ResponseBody
	public int hack(QnaVO qnaVO) throws Exception{
		
		qnaService.setWrite(qnaVO);
		
		return 1;
	}
	
	// 글쓰기	
	@GetMapping("write")
	public String setWrite(@ModelAttribute QnaVO qnaVO) throws Exception {
		
		return "board/write";
	}
	
	@PostMapping("write")
	public ModelAndView setWrite(@Valid QnaVO qnaVO,BindingResult bindingResult,ModelAndView mv, RedirectAttributes redirectAttributes) throws Exception {
		
		if(bindingResult.hasErrors()) {
			log.info("======= qna 검증 에러 =======");
			mv.setViewName("board/write");
			return mv;
		}
		
		int result = qnaService.setWrite(qnaVO);
		redirectAttributes.addAttribute("result", result);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	// 글목록
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<QnaVO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	// 상세보기
//	@GetMapping("/qna/detail")
//	public String getDetail(QnaVO qnaVO) throws Exception {
//		
//		return "board/detail";
//	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		qnaVO = qnaService.getDetail(qnaVO);
		
		log.info("qr : {}", qnaVO);
		mv.addObject("detail", qnaVO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView SetUpdate(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();

		qnaVO = qnaService.getDetail(qnaVO);
		mv.addObject("update", qnaVO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	public int fileDelete(QnaFileVO qnaFileVO) throws Exception {
		QnaVO qnaVO = new QnaVO();
		
		int result = qnaService.setFileDelete(qnaFileVO);
		
		return result;
	}

}
