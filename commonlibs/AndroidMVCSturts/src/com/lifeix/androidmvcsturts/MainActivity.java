package com.lifeix.androidmvcsturts;

import android.os.Bundle;

import com.lifeix.androidmvcsturts.command.ICommand;
import com.lifeix.androidmvcsturts.command.LoginCommand;
import com.lifeix.androidmvcsturts.request.IRequest;
import com.lifeix.androidmvcsturts.request.LoginRequest;
import com.lifeix.androidmvcsturts.response.IResponse;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		doLogin();
	}

	@Override
	public void onSuccess(IResponse response) {
	}

	@Override
	public void onError(IResponse response) {
	}

	private void doLogin() {
		String name = "";
		String password = "";
		IRequest iRequest = new LoginRequest();
		ICommand iCommand = new LoginCommand(name, password, iRequest, this);
		execute(iCommand);
	}

}
