package com.gm.home.aop.test;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Transeport {
	
	public void takeBus() {
		log.info("----- 버스 타기 -----");
	}
	
	public void takeSubway() {
		log.info("----- 지하철 타기 -----");
	}
	public void getTax() {
		log.info("----- 택시 타기 -----");
	}
	public void airPlane() {
		log.info("----- 신발 벗고 비행기 타기 ----- ");
	}
}
