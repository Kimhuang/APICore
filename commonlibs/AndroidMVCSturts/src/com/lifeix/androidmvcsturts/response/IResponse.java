package com.lifeix.androidmvcsturts.response;

public interface IResponse {

	public Object getRequestTag();

	public void setRequestTag(Object requestTag);

	public Object getResonseData();

	public void setResonseData(Object resonseData);

	public boolean isSuccess();

	public void setSuccess(boolean isSuccess);

	public int getRequestId();

	public void setRequestId(int requestId);
}
