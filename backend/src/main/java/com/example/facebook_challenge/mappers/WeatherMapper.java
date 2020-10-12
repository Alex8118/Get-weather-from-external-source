package com.example.facebook_challenge.mappers;

import com.example.facebook_challenge.dto.WeatherDto;
import com.example.facebook_challenge.models.Weather;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class WeatherMapper {

    @Mapping(source = "main.temp", target = "temp")
    @Mapping(source = "main.pressure", target = "pressure")
    @Mapping(source = "main.humidity", target = "humidity")
    public abstract WeatherDto fromWeather(Weather source);

}
