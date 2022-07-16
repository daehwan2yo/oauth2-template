package com.dh2y.oauth.core.model.kind;

import java.util.Arrays;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : static information for various OAuth Type
 **/
public enum OAuthType {
	NAVER("naver", OAuthPath.NAVER),
	KAKAO("kakao", OAuthPath.KAKAO),
	APPLE("apple", OAuthPath.APPLE),
	GOOGLE("google", OAuthPath.GOOGLE),
	EMPTY("", OAuthPath.EMPTY);

	private final String name;
	private final OAuthPath path;

	OAuthType(String name, OAuthPath oAuthPath) {
		this.name = name.toUpperCase();
		this.path = oAuthPath;
	}

	public static OAuthType get(String kind) {
		return Arrays.stream(OAuthType.values())
					 .filter(type -> type.name.equals(kind.toUpperCase()))
					 .findFirst()
					 .orElse(EMPTY);
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path.getDetail();
	}
}
