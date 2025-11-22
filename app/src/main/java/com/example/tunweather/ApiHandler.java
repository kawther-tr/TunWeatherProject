package com.example.tunweather;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;


public interface ApiHandler {

    @FormUrlEncoded
    @POST("webservicestunweather/sbg.php")
    Call<temphum> getAlldata(@Field("Gouvernorat") String Gouvernorat);

    @FormUrlEncoded
    @POST("webservicestunweather/alldata3.php")
    Call<List<temphum>> getAlldata3(@Field("Gouvernorat") String Gouvernorat);

}
