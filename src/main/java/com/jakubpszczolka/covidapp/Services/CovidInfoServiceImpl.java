package com.jakubpszczolka.covidapp.Services;

import com.jakubpszczolka.covidapp.Model.CovidInfo;
import com.jakubpszczolka.covidapp.Model.DTO.CovidInfoDto;
import com.jakubpszczolka.covidapp.Model.converters.CovidInfoConverter;
import com.jakubpszczolka.covidapp.Repositories.CovidInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class CovidInfoServiceImpl implements CovidInfoService {

    private final CovidInfoRepository covidInfoRepository;
    private final CovidInfoConverter covidInfoConverter;

    public CovidInfoServiceImpl(CovidInfoRepository covidInfoRepository, CovidInfoConverter covidInfoConverter) {
        this.covidInfoRepository = covidInfoRepository;
        this.covidInfoConverter = covidInfoConverter;
    }

    @Override
    public CovidInfo saveCovidInfo(CovidInfoDto covidInfoDto) {
        return covidInfoRepository.save(covidInfoConverter.covidInfoDtoToCovidInfo(covidInfoDto));
    }
}
