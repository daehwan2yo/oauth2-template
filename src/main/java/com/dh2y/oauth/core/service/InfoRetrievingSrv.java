package com.dh2y.oauth.core.service;

import java.net.URI;

import com.dh2y.oauth.core.model.OAuthUserInfo;
import com.dh2y.oauth.core.model.Refreshable;
import com.dh2y.oauth.core.model.kind.OAuthType;
import com.dh2y.oauth.core.util.caller.RestRequestCaller;
import com.dh2y.oauth.core.util.provider.HttpHeaderProvider;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : 
 **/
public class InfoRetrievingSrv {
	private final HttpHeaderProvider httpHeaderProvider;
	private final RestRequestCaller restRequestCaller;

	public InfoRetrievingSrv(final HttpHeaderProvider httpHeaderProvider, final RestRequestCaller restRequestCaller) {
		this.httpHeaderProvider = httpHeaderProvider;
		this.restRequestCaller = restRequestCaller;
	}

	public OAuthUserInfo<Refreshable> request(String kind,
											  String accessToken,
											  String refreshToken,
											  Class<? extends Refreshable> responseType) {
		OAuthType oAuthType = OAuthType.get(kind);

		Refreshable response = restRequestCaller.getAsBlocking(httpHeaderProvider.header(accessToken),
															   URI.create(oAuthType.getPath()),
															   responseType);

		if (response.needRefresh()) {
			response = restRequestCaller.getAsBlocking(httpHeaderProvider.header(refresh(kind, refreshToken)),
													   URI.create(oAuthType.getPath()),
													   responseType);
		}

		return OAuthUserInfo.from(response);
	}

	public String refresh(String kind, String refreshToken) {
		return null;
	}
}
