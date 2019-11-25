package com.jebysun.android.rxjavaretrofit.http;

public interface RequestCallback<T> {
    void onSuccess(T t);
    void onFailure(int code, String errMsg, Throwable throwable);
}

