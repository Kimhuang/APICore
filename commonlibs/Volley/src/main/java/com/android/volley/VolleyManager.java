package com.android.volley;

import android.content.Context;

import com.android.volley.toolbox.Volley;

/**
 * volleyManager
 * 
 * @author KimHuang
 * 
 */
public class VolleyManager {

	private static RequestQueue queue;
	private static RequestQueue longQueue;
	private static VolleyManager instance;

	private VolleyManager() {
	}

	private void init(Context context) {
		queue = Volley.newRequestQueue(context);
		longQueue = Volley.newRequestQueue(context);
	}

	/**
	 * Get VolleyManager Instance
	 * 
	 * @param context
	 * @return
	 */
	public static VolleyManager getInstance(Context context) {
		if (instance == null) {
			instance = new VolleyManager();
			instance.init(context);
		}
		return instance;
	}

	/**
	 * add a request to the requestQueue
	 * 
	 * @param request
	 * @param tag
	 * @param context
	 */
	public void add(Request<?> request, Object tag, Context context) {
		synchronized (queue) {
			request.setTag(tag);
			queue.add(request);
			queue.start();
		}
	}

	/**
	 * add a long request to the requestQueue
	 * 
	 * @param request
	 * @param tag
	 */
	public void addLong(Request<?> request, Object tag) {
		synchronized (longQueue) {
			request.setTag(tag);
			longQueue.add(request);
			longQueue.start();
		}
	}

	/**
	 * cancel a request by tag
	 * 
	 * @param tag
	 */
	public void cancel(Object tag) {
		queue.cancelAll(tag);
	}

	/**
	 * cancel a long request by tag
	 * 
	 * @param tag
	 */
	public void cancelLong(Object tag) {
		longQueue.cancelAll(tag);
	}

	/**
	 * stop request queue
	 */
	public void stop() {
		queue.stop();
	}

	/**
	 * stop long request queue
	 */
	public void stopLong() {
		longQueue.stop();
	}

}
