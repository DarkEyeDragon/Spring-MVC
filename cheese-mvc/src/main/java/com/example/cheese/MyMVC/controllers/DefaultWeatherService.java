package com.example.cheese.MyMVC.controllers;

import java.math.BigDecimal;

public class DefaultWeatherService {

    public CurrentWeather getCurrentWeather(){
        return new CurrentWeather("Default Weather Text", BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }
}
