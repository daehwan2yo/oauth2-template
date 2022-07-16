package com.dh2y.oauth.core.model;

/**
 * Author : daehwan2yo
 * Date : 2022/07/16
 * Info : for check accessToken need to be refreshed
 **/
public interface Refreshable {
	boolean needRefresh();
}
