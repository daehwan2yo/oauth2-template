package com.dh2y.oauth.core.model;

import com.dh2y.oauth.core.api.KakaoOAuthResponse;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : 
 **/
public class OAuthUserInfo<T> implements UserInfo<T> {
	private final T info;

	private OAuthUserInfo(T info) {
		this.info = info;
	}

	public static <T> OAuthUserInfo<T> from(T info) {
		return new OAuthUserInfo<>(info);
	}

	@Override
	public T getInfo() {
		return null;
	}

	@Override
	public String getEmail() {
		return ((KakaoOAuthResponse)info).getKakao_account().getProfile().getNickname();
	}
}
