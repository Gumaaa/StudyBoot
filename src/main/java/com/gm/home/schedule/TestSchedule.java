package com.gm.home.schedule;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gm.home.member.MemberMapper;
import com.gm.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestSchedule {
	
	@Autowired
	private MemberMapper mapper;
	
	@Scheduled(cron = "30 * * * * *")
	public void cron() throws Exception{
		log.info("Cron 매초 실행");
//		log.info(Calendar.getInstance().getTime().toString());
		MemberVO memberVO = new MemberVO();
		memberVO.setId("AutoId" + Calendar.getInstance().getTimeInMillis());
		memberVO.setPw("123");
		memberVO.setName("뚱이");
		memberVO.setEmail("Email");
//		mapper.setAdd(memberVO);
		
		log.info("Result : {}", mapper.setAdd(memberVO));
	}
	
	//@Scheduled(fixedRate = 3000, initialDelayString = "1000") // 3초 간격으로 log 출력
	public void ts1() {
		log.info("Schedule 실행");
	}
}
