package weatherService;

import models.CurrentWeather;
import models.Weather;
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

    @GetMapping("/moscow")
    public Weather getWeatherInfo(@PathVariable("city") String city) {
        ResponseEntity<CurrentWeather> currentWeather = restTemplate.getForEntity(
                "api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey, CurrentWeather.class);
        return new Weather(currentWeather.getBody().getTemp(), currentWeather.getBody().getPressure());
    }

}
