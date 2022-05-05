package com.example.ss6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Callback;

public class WeatherAdapter extends RecyclerView.Adapter {
    private final Activity activity;
    private List<WeatherByHour> weatherList;

    public WeatherAdapter(Activity activity, List<WeatherByHour> weatherList) {
        this.activity = activity;
        this.weatherList = weatherList;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void reloadData(List<WeatherByHour> list){
        this.weatherList.addAll(list);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =activity.getLayoutInflater().inflate(R.layout.item_weather,parent,false);
        WeatherHolder holder = new WeatherHolder(itemView);
         return holder;
    }

    @SuppressLint({"SetTextI18n", "LongLogTag"})
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        WeatherHolder weatherHolder = (WeatherHolder) holder;
        WeatherByHour model = weatherList.get(position);
        weatherHolder.time.setText(model.getDateTime().getHours()+" H");
        String url;
        if (model.getWeatherIcon()<10){
            url = "https://developer.accuweather.com/sites/default/files/0"+model.getWeatherIcon()+"-s.png";
        }else{
            url = "https://developer.accuweather.com/sites/default/files/"+model.getWeatherIcon()+"-s.png";
        }
        Log.d(url, "onBindViewHolder: ");
        weatherHolder.temp.setText(model.getTemperature().getValue() +"°"+ model.getTemperature().getUnit());
        Glide.with(activity).load(url).into(weatherHolder.icon);
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }
    public static class WeatherHolder extends RecyclerView.ViewHolder{
        TextView time,temp;
        ImageView icon;

        public WeatherHolder(@NonNull View itemView){
            super(itemView);
            time = itemView.findViewById(R.id.time);
            icon = itemView.findViewById(R.id.icon);
            temp = itemView.findViewById(R.id.temp);
        }

    }
}
