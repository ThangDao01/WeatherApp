package com.example.ss6;

import java.util.Date;

public class WeatherByHour {
    private int id;
    private int WeatherIcon;
    private String IconPhrase;
    private Boolean IsDaylight;
    private Date DateTime;
    private String EpochDateTime;
    private int PrecipitationProbability;
    private TemperatureModel Temperature;

    public WeatherByHour() {
    }

    public WeatherByHour(int id, int weatherIcon, String iconPhrase, Boolean isDaylight, Date dateTime, String epochDateTime, int precipitationProbability, TemperatureModel temperature) {
        this.id = id;
        WeatherIcon = weatherIcon;
        IconPhrase = iconPhrase;
        IsDaylight = isDaylight;
        DateTime = dateTime;
        EpochDateTime = epochDateTime;
        PrecipitationProbability = precipitationProbability;
        Temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public Boolean getDaylight() {
        return IsDaylight;
    }

    public void setDaylight(Boolean daylight) {
        IsDaylight = daylight;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public String getEpochDateTime() {
        return EpochDateTime;
    }

    public void setEpochDateTime(String epochDateTime) {
        EpochDateTime = epochDateTime;
    }

    public int getPrecipitationProbability() {
        return PrecipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        PrecipitationProbability = precipitationProbability;
    }

    public TemperatureModel getTemperature() {
        return Temperature;
    }

    public void setTemperature(TemperatureModel temperature) {
        Temperature = temperature;
    }
}
