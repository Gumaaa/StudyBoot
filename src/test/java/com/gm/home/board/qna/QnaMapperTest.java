package com.gm.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(true)
class QnaMapperTest {
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@BeforeAll
	static void beforeClass() {
		System.out.println("전체 Test 실행 전 !!!");
	}
	
	@AfterAll
	static void afterClass() {
		System.out.println("전체 Test 실행 후 !!!");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Test 메서드 실행 전");

	}
	
	@AfterEach
	void afterEach() {
		System.out.println("Test 메서드 실행 후");
	}
	
//	@Test
	void test2() {
		log.info("Test2 Case");
	}

	void test() throws Exception {
		
//		List<QnaVO> ar = qnaMapper.getList(pager);
//		log.info("List {}", ar);
//		assertNotEquals(0, ar.size());
	}
	
//	@Test
	void addTest() throws Exception {
		QnaVO qnaVO = new QnaVO();
		
		for(int i=1; i<101; i++) {
			qnaVO.setWriter("writer" + i);
			qnaVO.setTitle("title" + i);
			qnaVO.setContents("contents" + i);
			
//			int ar = qnaMapper.setAdd(qnaVO);
			
//			assertNotEquals(0, ar);
		}
		
		
	}
}
