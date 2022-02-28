package com.example.what_next;

import android.annotation.SuppressLint;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonClass {

    @SuppressLint("StaticFieldLeak")
    private static SingletonClass instance;
    private RequestQueue requestQueue;
    @SuppressLint("StaticFieldLeak")
    private static Context ctx;

    private SingletonClass(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();

    }

    public static synchronized SingletonClass getInstance(Context context) {
        if (instance == null) {
            instance = new SingletonClass(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
