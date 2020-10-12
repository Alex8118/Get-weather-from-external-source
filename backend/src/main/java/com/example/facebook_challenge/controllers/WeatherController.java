package com.example.facebook_challenge.controllers;

import com.example.facebook_challenge.dto.WeatherDto;
import com.example.facebook_challenge.mappers.WeatherMapper;
import com.example.facebook_challenge.models.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherMapper weatherMapper;

    @GetMapping("/{city}")
    public WeatherDto getWeatherInfo(@PathVariable() String city) {
        Weather weather = restTemplate.getForObject(
                "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apikey}",
                    Weather.class, city,apiKey);
        return weatherMapper.fromWeather(weather);
    }

}
