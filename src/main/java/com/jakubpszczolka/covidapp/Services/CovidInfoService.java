package com.jakubpszczolka.covidapp.Services;

import com.jakubpszczolka.covidapp.Model.CovidInfo;
import com.jakubpszczolka.covidapp.Model.DTO.CovidInfoDto;

public interface CovidInfoService {
    CovidInfo saveCovidInfo(CovidInfoDto covidInfoDto);
}
