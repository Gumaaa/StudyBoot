package com.gm.home.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MemberTest  {
	
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	void test() throws Exception{
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("111");
		
//		int result = memberMapper.getIdCheck(memberVO);
		log.info("요구르트 : {}", memberVO.getId());
//		log.info("맞나요 : {}", result);
		
		
	}

}
