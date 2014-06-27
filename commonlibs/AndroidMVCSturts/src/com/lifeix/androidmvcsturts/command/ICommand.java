package com.lifeix.androidmvcsturts.command;

import com.lifeix.androidmvcsturts.request.IRequest;
import com.lifeix.androidmvcsturts.response.IResponseListener;
import com.lifeix.androidmvcsturts.response.IResponse;

public interface ICommand {

	public IRequest getRequest();

	public void setRequest(IRequest request);

	public IResponse getResponse();

	public void setResponse(IResponse response);

	public IResponseListener getResponseListener();

	public void setResponseListener(IResponseListener listener);

	public void setTerminated(boolean terminated);

	public boolean isTerminated();

	public void execute();

}
