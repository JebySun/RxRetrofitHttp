package com.jebysun.android.rxjavaretrofit.demo;

public interface MainIView {

    void onSuccess(String msg);
    void onFailure(int errCode, String msg);

}
