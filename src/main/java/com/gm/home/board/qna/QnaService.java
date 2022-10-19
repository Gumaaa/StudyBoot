package com.gm.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gm.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	// 글쓰기
	public int setWrite(QnaVO qnaVO) throws Exception {
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info("Filename : {}", f.getOriginalFilename());
			}
		}
		
		return 1;//qnaMapper.setWrite(qnaVO);
	}
	
	// 글목록	
	public List<QnaVO> getList(Pager pager) throws Exception {
		pager.getRowNum();
		
		return qnaMapper.getList(pager);
	}
}
