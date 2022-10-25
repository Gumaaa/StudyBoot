package com.gm.home.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Component // 해당 클래스의 객체를 만들어 저장
@Configuration // servlet context 같은 역할 - 객체 저장하고 실행함
public class WebConfig implements WebMvcConfigurer {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Value("${app.upload.base}")
	private String filePath;

	@Value("${app.url.path}")
	private String urlPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("-------------------------------");
		log.info("filePath: {}", filePath);
		log.info("urlPath: {}", urlPath);
		log.info("-------------------------------");

		registry.addResourceHandler(urlPath) // 요청 url 사용
				.addResourceLocations(filePath);
	}
}