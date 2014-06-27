package com.lifeix.androidmvcsturts;

import android.app.Activity;

import com.lifeix.androidmvcsturts.command.ICommand;
import com.lifeix.androidmvcsturts.response.IResponseListener;

public abstract class BaseActivity extends Activity implements
		IResponseListener {

	public void execute(ICommand iCommand) {
		iCommand.execute();
	}

}
