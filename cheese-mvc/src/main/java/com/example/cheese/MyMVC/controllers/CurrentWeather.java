package com.example.cheese.MyMVC.controllers;


import java.io.Serializable;
import java.math.BigDecimal;

public class CurrentWeather implements Serializable {

    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal windSpeed;

    // Constructor
    CurrentWeather(String description, BigDecimal temperature, BigDecimal feelsLike, BigDecimal windSpeed){
        this.description = description;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.windSpeed = windSpeed;
    }

    public String getDescription(){return description;}
    public BigDecimal getTemperature(){return temperature;}
    public BigDecimal getFeelsLike(){return feelsLike;}
    public BigDecimal getWindSpeed(){return windSpeed;}
}
