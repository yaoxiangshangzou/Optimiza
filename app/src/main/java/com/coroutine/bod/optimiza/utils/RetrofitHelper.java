package com.coroutine.bod.optimiza.utils;

import com.coroutine.bod.optimiza.ApiService;
import com.coroutine.bod.optimiza.BookBean;
import com.coroutine.bod.optimiza.DynamicUrlInterceptor;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {


    // http://gank.io/api/xiandu/categories

    private
    static final String BASE_URL_USER = "https://www.222.com";

    private static OkHttpClient okHttpClient;
    private final Retrofit mRetrofitManager;

    public RetrofitHelper() {
        mRetrofitManager = new Retrofit.Builder()
                .baseUrl(BASE_URL_USER)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    private OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().retryOnConnectionFailure(true)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new DynamicUrlInterceptor())
                    .build();
        }
        return okHttpClient;
    }

    public Call<BookBean> getBook() {
        return mRetrofitManager.create(ApiService.class)
                .getBook(1);
    }

}
