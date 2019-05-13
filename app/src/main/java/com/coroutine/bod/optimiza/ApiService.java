package com.coroutine.bod.optimiza;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiService {

    @Headers({"dynamic-url:test"})
    @GET("/v2/book/{id}")
    Call<BookBean> getBook(@Path("id") int id);

}
