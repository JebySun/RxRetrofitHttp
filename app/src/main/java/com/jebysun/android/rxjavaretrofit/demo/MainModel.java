package com.jebysun.android.rxjavaretrofit.demo;

import com.jebysun.android.rxjavaretrofit.base.BaseModel;
import com.jebysun.android.rxjavaretrofit.http.RequestCallback;
import com.jebysun.android.rxjavaretrofit.http.Result;
import com.jebysun.android.rxjavaretrofit.http.RxHelper;
import com.jebysun.android.rxjavaretrofit.http.RxRetrofitClient;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;


public class MainModel extends BaseModel {

    private XXXHttpService mXXXHttpService;

    public MainModel() {
        mXXXHttpService = RxRetrofitClient.getInstance().createHTTPService(XXXHttpService.class);
    }

    /**
     * 正常网络请求
     * @param callback
     */
    public void giftList(RequestCallback<String> callback) {
        Observable<Result<String>> observable = mXXXHttpService.giftList(null);
        super.doSubscribe(observable, callback);
    }

    /**
     * 特殊网络请求
     * @param callback
     */
    public void getPage(final RequestCallback<String> callback) {
        Disposable disposable = mXXXHttpService.getHTMLPage()
                .compose(RxHelper.<ResponseBody>switchThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody body) throws IOException {
                        String res = body.string();
                        callback.onSuccess(res);
                    }
                }, RxHelper.createThrowableConsumer(callback));

        super.getCompositeDisposable().add(disposable);
    }



}
