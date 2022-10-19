package com.gm.home.board.qna;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gm.home.util.Pager;

@Controller
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
	
	@GetMapping("/qna/write")
	public String setWrite() throws Exception {
		
		return "board/write";
	}
	
	@PostMapping("/qna/write")
	public String setWrite(QnaVO qnaVO, RedirectAttributes redirectAttributes) throws Exception {
		
		int result = qnaService.setWrite(qnaVO);
		
		redirectAttributes.addAttribute("result", result);
		
		return "redirect:./list";
	}
	
	// 글목록
	@GetMapping("/qna/list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<QnaVO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}

}