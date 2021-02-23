package com.jakubpszczolka.covidapp.Services;

import com.jakubpszczolka.covidapp.Model.DTO.CovidInfoDto;

import java.io.IOException;

public interface CovidApiService {
    CovidInfoDto getCovidInfo(String country) throws IOException;
}
