package com.gm.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.gm.home.util.Pager;

//@Repository 생략 가능
@Mapper
public interface QnaMapper {
	
	public List<QnaVO> getList(Pager pager) throws Exception;
	
	public int setWrite(QnaVO qnaVO) throws Exception;
}
