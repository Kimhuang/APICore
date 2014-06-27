package com.lifeix.androidmvcsturts.request;

public class BaseRequest implements IRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1651748057616571390L;

	private Object requestData;
	private Object requestTag;
	private int requestId;

	public BaseRequest() {
		super();
	}

	public BaseRequest(Object requestData, Object requestTag, int requestId) {
		super();
		this.requestData = requestData;
		this.requestTag = requestTag;
		this.requestId = requestId;
	}

	@Override
	public Object getRequestData() {
		return requestData;
	}

	@Override
	public void setRequestData(Object requestData) {
		this.requestData = requestData;
	}

	@Override
	public Object getRequestTag() {
		return requestTag;
	}

	@Override
	public void setRequestTag(Object requestTag) {
		this.requestTag = requestTag;
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
