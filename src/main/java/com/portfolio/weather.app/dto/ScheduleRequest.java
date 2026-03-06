package com.kiyotaka.weatherapp.dto;

public record ScheduleRequest(
    String date,
    String location,
    String title,
    String weather,
    String clothes,
    String umbrella
) {}