package com.jakubpszczolka.covidapp.Model.converters;

import com.jakubpszczolka.covidapp.Model.CovidInfo;
import com.jakubpszczolka.covidapp.Model.DTO.CovidInfoDto;

public interface CovidInfoConverter {
    CovidInfo covidInfoDtoToCovidInfo(CovidInfoDto covidInfoDto);
}
