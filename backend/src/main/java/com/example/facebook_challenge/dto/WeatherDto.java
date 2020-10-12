package com.example.facebook_challenge.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto {

    private Long timezone;
    private Long temp;
    private Long pressure;
    private Long humidity;

}
