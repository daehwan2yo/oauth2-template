package com.dh2y.oauth.core.util.provider;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : provide http header
 * depends on Spring
 **/
public class SpringHttpHeaderProvider implements HttpHeaderProvider {
	@Override
	public HttpHeaders header() {
		return new HttpHeaders();
	}

	@Override
	public HttpHeaders header(String bearerToken) {
		return header(MediaType.APPLICATION_FORM_URLENCODED, bearerToken);
	}

	private HttpHeaders header(MediaType mediaType, String bearerToken) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setBearerAuth(bearerToken);
		httpHeaders.setContentType(mediaType);

		return httpHeaders;
	}
}
