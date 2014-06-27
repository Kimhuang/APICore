package com.lifeix.androidmvcsturts.command;

import com.lifeix.androidmvcsturts.request.IRequest;
import com.lifeix.androidmvcsturts.response.IResponseListener;
import com.lifeix.androidmvcsturts.response.IResponse;

public abstract class BaseCommand implements ICommand {

	private IRequest iRequest;
	private IResponse iResponse;
	private IResponseListener iResponseListener;
	private boolean isInUIThread;
	private boolean terminated;

	public BaseCommand(IRequest iRequest) {
		this.iRequest = iRequest;
	}

	public BaseCommand(IResponseListener iResponseListener) {
		this.iResponseListener = iResponseListener;
	}

	public BaseCommand(IRequest iRequest, IResponseListener iResponseListener) {
		this.iRequest = iRequest;
		this.iResponseListener = iResponseListener;
	}

	@Override
	public IRequest getRequest() {
		return iRequest;
	}

	@Override
	public void setRequest(IRequest request) {
		this.iRequest = request;
	}

	@Override
	public IResponse getResponse() {
		return iResponse;
	}

	@Override
	public void setResponse(IResponse response) {
		this.iResponse = response;
	}

	@Override
	public IResponseListener getResponseListener() {
		return iResponseListener;
	}

	@Override
	public void setResponseListener(IResponseListener iResponseListener) {
		this.iResponseListener = iResponseListener;
	}

	@Override
	public void setTerminated(boolean terminated) {
		this.terminated = terminated;
	}
	
	public boolean isInUIThread() {
		return isInUIThread;
	}

	public void setInUIThread(boolean isInUIThread) {
		this.isInUIThread = isInUIThread;
	}

	@Override
	public boolean isTerminated() {
		return terminated;
	}
}
