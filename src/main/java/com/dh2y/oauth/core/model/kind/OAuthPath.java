package com.dh2y.oauth.core.model.kind;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : static path for various OAuth Type
 **/
public enum OAuthPath {
	KAKAO("https://kapi.kakao.com/v2/user/me"),
	NAVER("https://"),
	APPLE("https://"),
	GOOGLE("https://"),
	EMPTY("");

	private final String detail;

	OAuthPath(String detail) {
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}
}
