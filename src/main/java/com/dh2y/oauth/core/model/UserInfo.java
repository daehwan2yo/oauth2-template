package com.dh2y.oauth.core.model;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : 
 **/
public interface UserInfo<T> {
	T getInfo();

	String getEmail();
}
