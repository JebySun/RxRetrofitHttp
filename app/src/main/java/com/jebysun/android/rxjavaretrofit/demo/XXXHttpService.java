package com.jebysun.android.rxjavaretrofit.demo;

import com.jebysun.android.rxjavaretrofit.http.Result;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface XXXHttpService {

    /**
     * 返回OKhttp原始ResponseBody
     * @return
     */
    @GET("https://www.cnblogs.com/babycomeon/p/11895483.html")
    Observable<ResponseBody> getHTMLPage();

    /**
     * 获取礼物列表
     * @param paramHolder 占位参数，本接口业务上不需要参数，但框架代码需要参数。
     * @return
     */
    @FormUrlEncoded
    @POST("http://101.200.63.140/api/Gift/giftList")
    Observable<Result<String>> giftList(@Field("paramholder") String paramHolder);

}
