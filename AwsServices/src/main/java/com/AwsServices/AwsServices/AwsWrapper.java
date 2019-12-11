package com.AwsServices.AwsServices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AwsWrapper {

	@Value("${cloud.aws.credentials.accessKey}")
	public String accessKey;

	@Value("${cloud.aws.credentials.secretKey}")
	public String secretkey;

	@Value("${region}")
	public String region;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
