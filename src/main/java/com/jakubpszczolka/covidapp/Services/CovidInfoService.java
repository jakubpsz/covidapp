package com.jakubpszczolka.covidapp.Services;

import com.jakubpszczolka.covidapp.Model.CovidInfo;
import com.jakubpszczolka.covidapp.Model.DTO.CovidInfoDto;

import java.util.List;

public interface CovidInfoService {
    CovidInfo saveCovidInfo(CovidInfoDto covidInfoDto);
    List<CovidInfoDto> getCovidInfos();
}
