package com.gm.home.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.gm.home.board.qna.QnaFileVO;
import com.gm.home.board.qna.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("/fileDown/{p}") //RestFul, RestAPI
	public ModelAndView fileDown(@PathVariable(name = "p") String path, QnaFileVO qnaFileVO) throws Exception {
		log.info("path : {}", path);
		
		ModelAndView mv = new ModelAndView();
		
		//DB 정보 조회
		if(path.equals("qna")) {
			qnaFileVO = qnaService.getFileDetail(qnaFileVO);
		} else if(path.equals("notice")) {
//			qnaFileVO.setFileName("dfbce689-af1c-4fb7-9346-f354585aa417_겁쟁이 쉼터.png");
//			qnaFileVO.setOriName("겁쟁이 쉼터.png");	
		}
		
		mv.addObject("fileVO", qnaFileVO);	
		mv.addObject("path", path);
		
		mv.setViewName("fileManager");

		return mv;
	}
	
//	@GetMapping("/fileDown/notice")
//	   public ModelAndView fileDownNotice(QnaFileVO qnaFileVO)throws Exception{
//	      
//	      ModelAndView mv= new ModelAndView();
//	      
//	      //DB에서 정보 조회
//	      qnaFileVO.setFileName("SS.jpg");
//	      qnaFileVO.setOriName("SS.jpg");
//	      
//	      mv.addObject("fileVO", qnaFileVO);
//	      mv.addObject("path", "notice");
//	      mv.setViewName("fileManager");
//	      return mv;
//	   }
}
