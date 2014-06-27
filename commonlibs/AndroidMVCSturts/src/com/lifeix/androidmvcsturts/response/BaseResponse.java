package com.lifeix.androidmvcsturts.response;

public class BaseResponse implements IResponse {

	private Object requestTag;
	private Object resonseData;
	private boolean isSuccess;
	private int requestId;

	@Override
	public Object getRequestTag() {
		return requestTag;
	}

	@Override
	public void setRequestTag(Object requestTag) {
		this.requestTag = requestTag;
	}

	@Override
	public Object getResonseData() {
		return resonseData;
	}

	@Override
	public void setResonseData(Object resonseData) {
		this.resonseData = resonseData;
	}

	@Override
	public boolean isSuccess() {
		return isSuccess;
	}

	@Override
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	@Override
	public int getRequestId() {
		return requestId;
	}

	@Override
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

}
