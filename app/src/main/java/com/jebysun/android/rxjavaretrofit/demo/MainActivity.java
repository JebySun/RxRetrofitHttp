package com.jebysun.android.rxjavaretrofit.demo;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.jebysun.android.rxjavaretrofit.R;
import com.jebysun.android.rxjavaretrofit.base.BaseActivity;
import com.jebysun.android.rxjavaretrofit.base.BasePresenter;

public class MainActivity extends BaseActivity implements MainIView {

    private TextView tvInfo;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tv_info);

        presenter.getPage();
        presenter.getGiftList();
//        presenter.getCSDNPage();
//        presenter.getJson();

    }

    @Override
    public BasePresenter initPresenter() {
        presenter = new MainPresenter(this);
        return presenter;
    }


    @Override
    public void onSuccess(String msg) {
        tvInfo.setText(msg);
    }

    @Override
    public void onFailure(int errCode, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
