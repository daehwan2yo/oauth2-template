package com.dh2y.oauth.core.util.caller;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : 
 **/
public class RestTemplateRestRequestCaller implements RestRequestCaller {
	private final RestTemplate restTemplate;

	public RestTemplateRestRequestCaller(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public <T> Object call(HttpMethod httpMethod, HttpHeaders httpHeaders, URI uri, Class<T> resultType) {
		return restTemplate.exchange(uri, httpMethod, entity(httpHeaders), resultType).getBody();
	}

	@Override
	public <T> T getAsBlocking(HttpHeaders httpHeaders, URI uri, Class<T> resultType) {
		return (T) call(HttpMethod.GET, httpHeaders, uri, resultType);
	}

	@Override
	public Object post() {
		return null;
	}

	private HttpEntity<Object> entity(HttpHeaders httpHeaders) {
		return new HttpEntity<>(httpHeaders);
	}
}
