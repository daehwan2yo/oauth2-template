package com.dh2y.oauth.core.util.caller;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : 
 **/
public interface RestRequestCaller {
	<T> Object call(HttpMethod httpMethod, HttpHeaders httpHeaders, URI uri, Class<T> resultType) ;

	<T> T getAsBlocking(HttpHeaders httpHeaders, URI uri, Class<T> resultType);

	Object post();
}
