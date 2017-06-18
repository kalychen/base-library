package com.devinchen.library.common.net;

import android.os.SystemClock;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Devin Chen on 2017/5/14.
 */

public class NetClient {

    private static Retrofit.Builder builder;
    private static OkHttpClient client;

    public static Retrofit getRetrofit(String baseUrl) {
        if (builder == null) {
            builder = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient());
        }
        return builder.baseUrl(baseUrl).build();
    }

    private static OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            SystemClock.sleep(1000);
                            Response response = chain.proceed(request);
                            return response;
                        }
                    })
                    .build();

        }
        return client;
    }
}
