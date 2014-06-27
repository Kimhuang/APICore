package com.lifeix.androidmvcsturts.command;

import com.lifeix.androidmvcsturts.request.IRequest;
import com.lifeix.androidmvcsturts.response.IResponse;
import com.lifeix.androidmvcsturts.response.IResponseListener;

public class LoginCommand extends BaseCommand {

	private String name;
	private String password;

	public LoginCommand(String name, String password, IRequest iRequest,
			IResponseListener iResponseListener) {
		super(iRequest, iResponseListener);
		this.name = name;
		this.password = password;
		setInUIThread(false);
	}

	public LoginCommand(String name, String password,
			IResponseListener iResponseListener) {
		super(iResponseListener);
		this.name = name;
		this.password = password;
	}

	@Override
	public void execute() {

		if (isInUIThread()) {
			
		} else {

		}

		getResponseListener().onSuccess(new IResponse() {

			@Override
			public void setSuccess(boolean isSuccess) {

			}

			@Override
			public void setResonseData(Object resonseData) {

			}

			@Override
			public void setRequestTag(Object requestTag) {

			}

			@Override
			public void setRequestId(int requestId) {

			}

			@Override
			public boolean isSuccess() {
				return false;
			}

			@Override
			public Object getResonseData() {
				return null;
			}

			@Override
			public Object getRequestTag() {
				return null;
			}

			@Override
			public int getRequestId() {
				return 0;
			}
		});
	}

}
