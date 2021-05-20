package com.example.cheese.MyMVC.controllers;

import java.math.BigDecimal;

public class LiveWeatherService {

    public CurrentWeather getCurrentWeather(String city, String state, String country){
        return new CurrentWeather("Clear", BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN);
    }
}
