package com.example.cheese.MyMVC.controllers;


// Not a Controller
public class CurrentWeatherController {

    // Weather Page Variables
    private final DefaultWeatherService defaultWeather;
    //private final LiveWeatherService liveWeatherService;

    // Constructor for class
    public CurrentWeatherController( DefaultWeatherService defaultWeather){
        this.defaultWeather = defaultWeather;

    }

}
