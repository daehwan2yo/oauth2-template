package com.dh2y.oauth.core.util.caller;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : 
 **/
public class WebClientRestRequestCaller implements RestRequestCaller {
	private static final String AUTHORIZATION = "Authorization";

	@Override
	public <T> Object call(HttpMethod httpMethod, HttpHeaders httpHeaders, URI uri, Class<T> resultType) {
		return WebClient.create()
						.method(httpMethod)
						.uri(uri)
						.headers(ori -> copyHeader(ori, httpHeaders))
						.retrieve()
						.onStatus(HttpStatus::is4xxClientError, a -> a.bodyToMono(IllegalAccessError.class))
						.bodyToFlux(resultType);
	}

	@Override
	public <T> T getAsBlocking(HttpHeaders httpHeaders, URI uri, Class<T> resultType) {
		return ((Flux<T>)call(HttpMethod.GET, httpHeaders, uri, resultType)).blockFirst();
	}

	private void copyHeader(HttpHeaders ori, HttpHeaders httpHeaders) {
		ori.setContentType(httpHeaders.getContentType());
		ori.setBearerAuth(httpHeaders.getFirst(AUTHORIZATION));
	}

	@Override
	public Object post() {
		return null;
	}
}
