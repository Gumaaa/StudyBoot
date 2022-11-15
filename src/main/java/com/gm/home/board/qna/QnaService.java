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
	
	public boolean setSummerFileDelete(String fileName) throws Exception {
		fileName = fileName.substring(fileName.lastIndexOf("/")+1);
		log.info("DeleteFileName : {}", fileName);
		
		File file = new File(path, fileName);
		
		
		return file.delete();
	}
	
	public String setSummerFile(MultipartFile file) throws Exception {
		String fileName = fileManager.saveFile(file, path);
		
		fileName = "/file/qna/" + fileName;
		
		return fileName;
	}
	
	// 글쓰기 + 첨부파일
	public int setWrite(QnaVO qnaVO) throws Exception {
		
		int result = qnaMapper.setWrite(qnaVO);
//		String realPath = session.getServletContext().getRealPath("/static/upload/qna2");
		log.info("realPath : {}", path);
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
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
	
	// 파일 다운로드
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO) throws Exception {
		
		return qnaMapper.getFileDetail(qnaFileVO);
	}
	
	// 글수정
	public int setUpdate(QnaVO qnaVO) throws Exception {
		
		return qnaMapper.setUpdate(qnaVO);
	}
	
	// 글수정 시 파일삭제
	public int setFileDelete(QnaFileVO qnaFileVO) throws Exception {
		qnaFileVO = qnaMapper.getFileDetail(qnaFileVO);
		int result = qnaMapper.setFileDelete(qnaFileVO);
		
		
		if (result > 0) {
			fileManager.DeleteFile(path, qnaFileVO);
		} 
		
		return result;
	}
}
