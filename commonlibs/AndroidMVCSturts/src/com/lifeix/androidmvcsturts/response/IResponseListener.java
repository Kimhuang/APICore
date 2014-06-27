package com.lifeix.androidmvcsturts.response;

public interface IResponseListener {
	void onSuccess(IResponse response);

	void onError(IResponse response);
}
