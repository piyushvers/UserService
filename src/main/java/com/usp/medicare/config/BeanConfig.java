package com.usp.medicare.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.usp.medicare.util.MailUtil;
import com.usp.medicare.util.OtpGenerator;

@Configuration
public class BeanConfig {

	@Bean
	public MailUtil mailUtil() {
		return new MailUtil();
	}
	
	@Bean
	public OtpGenerator otpGenerator() {
		return new OtpGenerator();
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}
}
