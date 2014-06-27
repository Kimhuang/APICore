package com.lifeix.androidmvcsturts.request;

import java.io.Serializable;

public interface IRequest extends Serializable {

	public Object getRequestData();

	public void setRequestData(Object requestData);

	public Object getRequestTag();

	public void setRequestTag(Object requestTag);

	public int getRequestId();

	public void setRequestId(int requestId);
}
