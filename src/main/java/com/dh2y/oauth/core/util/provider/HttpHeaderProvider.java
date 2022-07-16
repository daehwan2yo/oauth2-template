package com.dh2y.oauth.core.util.provider;

import org.springframework.http.HttpHeaders;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : provide http header
 **/
public interface HttpHeaderProvider {
	Object header();

	HttpHeaders header(String bearerToken);
}
