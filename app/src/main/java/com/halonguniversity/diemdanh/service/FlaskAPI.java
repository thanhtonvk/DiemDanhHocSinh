package com.halonguniversity.diemdanh.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface FlaskAPI {
    String BASE_URL = "http://192.168.1.106:1234/";
    Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS).writeTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).build();
    FlaskAPI api = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(FlaskAPI.class);
    @Multipart
    @POST("/upload/{mahocsinh}")
    Call<String> addFace(@Path("mahocsinh") String idHS, @Part MultipartBody.Part file);

    @Multipart
    @POST("/face_reg")
    Call<String> searchFace(@Part MultipartBody.Part file);

}
