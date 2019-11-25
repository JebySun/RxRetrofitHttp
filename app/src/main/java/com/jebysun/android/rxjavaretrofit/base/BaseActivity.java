package com.jebysun.android.rxjavaretrofit.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private BasePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = initPresenter();
    }


    public abstract BasePresenter initPresenter();

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.dispose();
        }
        super.onDestroy();
    }
}
