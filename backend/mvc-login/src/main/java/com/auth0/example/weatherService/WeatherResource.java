package com.auth0.example.weatherService;

import com.auth0.example.models.CurrentWeather;
import com.auth0.example.models.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherResource {

    @Value("${api.key.for.weather}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{city}")
    public Weather getWeatherInfo(@PathVariable("city") String city) {
        ResponseEntity<Weather> weather = restTemplate.getForEntity(
                "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey, Weather.class);
        return weather.getBody();
    }

}
