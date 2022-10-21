 package com.gm.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gm.home.util.FileManager;
import com.gm.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class) //rollbackFor = 언제 롤백할거냐 
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.qna}")
	private String path;
	// 글쓰기
	public int setWrite(QnaVO qnaVO) throws Exception {
		
		int result = qnaMapper.setWrite(qnaVO);
//		String realPath = session.getServletContext().getRealPath("/static/upload/qna2");
		log.info("realPath : {}", path);
		File file = new File(path);
		
		if(!file.exists()) {
			Boolean check = file.mkdirs();
			log.info("check : {}", check);
		}
		
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				
				log.info("Filename : {}", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				qnaMapper.setFileAdd(qnaFileVO);
			}
		}
		
		return result;
	}
	
	// 글목록	
	public List<QnaVO> getList(Pager pager) throws Exception {
		pager.getRowNum();
		
		return qnaMapper.getList(pager);
	}
	
	// 상세보기
	public QnaVO getDetail(QnaVO qnaVO) throws Exception {
		
		return qnaMapper.getDetail(qnaVO);
	}
}
