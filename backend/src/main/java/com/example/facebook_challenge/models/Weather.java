package com.example.facebook_challenge.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    private Long code;
    private Long dt;
    private Long id;
    private Long timezone;
    private Long visibility;
    private String base;
    private String name;
    private MainParams main;
}
