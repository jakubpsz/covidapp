package com.jakubpszczolka.covidapp.Model.converters;

import com.jakubpszczolka.covidapp.Model.CovidInfo;
import com.jakubpszczolka.covidapp.Model.DTO.CovidInfoDto;
import org.springframework.stereotype.Component;

@Component
public class CovidInfoConverterImpl implements CovidInfoConverter {
    @Override
    public CovidInfo covidInfoDtoToCovidInfo(CovidInfoDto covidInfoDto) {
        CovidInfo covidInfo = new CovidInfo();
        covidInfo.setCountry(covidInfoDto.getCountry());
        covidInfo.setLastChange(covidInfoDto.getLastChange());
        covidInfo.setLastUpdate(covidInfoDto.getLastUpdate());
        covidInfo.setConfirmed(covidInfoDto.getConfirmed());
        covidInfo.setRecovered(covidInfoDto.getRecovered());
        covidInfo.setCritical(covidInfoDto.getCritical());
        covidInfo.setDeaths(covidInfoDto.getDeaths());
        return covidInfo;
    }

    @Override
    public CovidInfoDto covidInfoToCovidInfoDto(CovidInfo covidInfo) {
        CovidInfoDto covidInfoDto = new CovidInfoDto();
        covidInfoDto.setCountry(covidInfo.getCountry());
        covidInfoDto.setLastChange(covidInfo.getLastChange());
        covidInfoDto.setLastUpdate(covidInfo.getLastUpdate());
        covidInfoDto.setConfirmed(covidInfo.getConfirmed());
        covidInfoDto.setRecovered(covidInfo.getRecovered());
        covidInfoDto.setCritical(covidInfo.getCritical());
        covidInfoDto.setDeaths(covidInfo.getDeaths());
        return covidInfoDto;
    }
}
