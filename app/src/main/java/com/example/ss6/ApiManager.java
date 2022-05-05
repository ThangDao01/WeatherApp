package com.example.ss6;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiManager {
    String key = "bvOwHfnPlV9bJsGC3wvEdgAVwqV7S3z0";
    String leng = "vi-vn";
    String location = "353412";
    String URL_SERVER = "https://dataservice.accuweather.com/forecasts/v1/";
//    Call<Item> getData(@Query("id") String id, @Query("name") String name);

//    @GET("hourly/12hour/"+location+"/?apikey="+key+"&language="+leng+"&metric=true")
    @GET("hourly/12hour/"+location+"?apikey="+key+"&language=vi-vn&metric=true")
    Call<List<WeatherByHour>> getWeatherByHour();
}
