package com.example.facebook_challenge.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainParams {

    private Long temp;
    private Long feels_like;
    private Long temp_min;
    private Long temp_max;
    private Long pressure;
    private Long humidity;
}
