package com.gm.home;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gm.home.aop.test.Card;
import com.gm.home.aop.test.Transeport;

@SpringBootTest
class TranseportTest {

	@Autowired
	private Transeport transeport;
	
	@Autowired
	private Card card;
	
	@Test
	void test() {
		transeport.takeBus();
		transeport.takeSubway();
		transeport.getTax();
		transeport.airPlane();
	}

}
