package com.gm.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.gm.home.util.Pager;

@Controller
public class QnaController {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute
	public String getBoard() {
		
		return "qna";
	}
	
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
