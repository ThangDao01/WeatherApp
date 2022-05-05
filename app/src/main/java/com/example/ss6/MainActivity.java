package com.example.ss6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvTem, tvHour, tvStatus;
    RecyclerView rvWeather ;
    WeatherAdapter adapter;
    private List<WeatherByHour> weatherItem = new ArrayList<>();

    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        apiGetData();
//        fetchData();
        //truyền dữ liệu vào weatherItem
        adapter = new WeatherAdapter(MainActivity.this,weatherItem); //weatherItem null
        Log.d(adapter.toString(), "onCreate: ");
        layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        rvWeather = findViewById(R.id.rvWeather);
        rvWeather.setLayoutManager(layoutManager);
        rvWeather.setAdapter(adapter);
    }
    private void initView() {
        tvTem = findViewById(R.id.tvTem);
        tvHour = findViewById(R.id.tvHour);
        tvStatus = findViewById(R.id.tvStatus);
    }

    public void apiGetData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.URL_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiManager service = retrofit.create(ApiManager.class);
        service.getWeatherByHour().enqueue(new Callback<List<WeatherByHour>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<List<WeatherByHour>> call, @NonNull Response<List<WeatherByHour>> response) {
                if (response.body() != null) {
                    weatherItem = response.body();
                    tvStatus.setText(weatherItem.get(0).getIconPhrase());
                    tvTem.setText(weatherItem.get(0).getTemperature().getValue() +"°"+ weatherItem.get(0).getTemperature().getUnit());
                    adapter.reloadData(weatherItem);
                    for (int i = 0; i < weatherItem.size(); i++) {
                        Log.d(weatherItem.get(i).getIconPhrase(), "onResponse: ");
                    }
                }
            }
            @Override
            public void onFailure(Call<List<WeatherByHour>> call, Throwable t) {
                Log.e(t.toString(), "Error: ");
            }
        });
    }
    public void fetchData(){
        weatherItem.add(new WeatherByHour(0,1,"Nắng",true,null,null,0,new TemperatureModel("C",0,27)));
        weatherItem.add(new WeatherByHour(0,1,"Mưa",true,null,null,0,new TemperatureModel("C",0,27)));
        weatherItem.add(new WeatherByHour(0,1,"Bất thường",true,null,null,0,new TemperatureModel("C",0,27)));
        Log.d(weatherItem.get(0).getIconPhrase(), "fetchData: ");
//        adapter.reloadData(weatherItem);
    }
}