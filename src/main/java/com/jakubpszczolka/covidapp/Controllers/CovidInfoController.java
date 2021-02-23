package com.jakubpszczolka.covidapp.Controllers;

import com.jakubpszczolka.covidapp.Model.CovidInfo;
import com.jakubpszczolka.covidapp.Model.DTO.CovidInfoDto;
import com.jakubpszczolka.covidapp.Services.CovidInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jakubpszczolka.covidapp.Services.CovidApiService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class CovidInfoController {
    private final CovidApiService covidApiService;
    private final CovidInfoService covidInfoService;

    public CovidInfoController(CovidApiService covidApiService, CovidInfoService covidInfoService) {
        this.covidApiService = covidApiService;
        this.covidInfoService = covidInfoService;
    }

    @GetMapping("/covid")
    public CovidInfoDto getInfo(@RequestParam String country) {
        try {
            log.info("Requested covid info for " + country);
            return covidApiService.getCovidInfo(country);
        } catch (IOException | NullPointerException e) {
            log.error(e.getMessage());
            return new CovidInfoDto();
        }
    }
    @GetMapping("/covid/save")
    public CovidInfo getInfoAndSave(@RequestParam String country) {
        try {
            log.info("Requested covid info for " + country + " and save it to db");
            return covidInfoService.saveCovidInfo(covidApiService.getCovidInfo(country));
        } catch (IOException | NullPointerException e) {
            log.error(e.getMessage());
            return new CovidInfo();
        }
    }
    @GetMapping("/covid/saved")
    public List<CovidInfoDto> getAllSaved() {
        try {
            log.info("Requested all saved");
            return covidInfoService.getCovidInfos();
        } catch (NullPointerException e) {
            log.error(e.getMessage());
            return new ArrayList<>();
        }
    }
}
