package com.hsuaxo.rxtube;

import io.reactivex.Single;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RXTube {

    private final String API_URL = "https://www.googleapis.com/youtube/v3/";
    private final String API_KEY_PARAM = "key";
    private final String apiKey;
    private final Retrofit retrofit;
    private final YTService endpoint;

    public RXTube(final String apiKey) {
        this.apiKey = apiKey;
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient())
                .build();
        endpoint = retrofit.create(YTService.class);
    }

    private OkHttpClient httpClient() {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {

            @Override
            public Response intercept(final Chain chain) throws IOException {
                final Request original = chain.request();
                final HttpUrl originalHttpUrl = original.url();
                final HttpUrl url = originalHttpUrl.newBuilder().addQueryParameter(API_KEY_PARAM, apiKey).build();
                final Request.Builder requestBuilder = original.newBuilder().url(url);
                final Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        return httpClient.build();
    }

    public Single<YTResponse> search(String type, String searchText) {
        return endpoint.search(type, searchText);
    }
}
