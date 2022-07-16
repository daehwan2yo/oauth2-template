package com.dh2y.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.dh2y.oauth.core.service.InfoRetrievingSrv;
import com.dh2y.oauth.core.util.caller.RestRequestCaller;
import com.dh2y.oauth.core.util.caller.RestTemplateRestRequestCaller;
import com.dh2y.oauth.core.util.caller.WebClientRestRequestCaller;
import com.dh2y.oauth.core.util.provider.HttpHeaderProvider;
import com.dh2y.oauth.core.util.provider.SpringHttpHeaderProvider;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : 
 **/
@Configuration
public class TemplateConfig {
	@Bean
	public InfoRetrievingSrv infoRetrievingSrv() {
		return new InfoRetrievingSrv(httpHeaderProvider(), restRequestCaller());
	}
	@Bean
	public HttpHeaderProvider httpHeaderProvider() {
		return new SpringHttpHeaderProvider();
	}

	@Bean
	public RestRequestCaller restRequestCaller() {
		return new RestTemplateRestRequestCaller(restTemplate());
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
