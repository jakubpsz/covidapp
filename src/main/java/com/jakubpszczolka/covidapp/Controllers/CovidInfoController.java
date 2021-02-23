package com.jakubpszczolka.covidapp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jakubpszczolka.covidapp.Services.CovidApiService;
@RestController
public class CovidInfoController {
    private final CovidApiService covidApiService;

    public CovidInfoController(CovidApiService covidApiService) {
        this.covidApiService = covidApiService;
    }

    @GetMapping("/covid")
    public String getInfo(@RequestParam String country) {
        return covidApiService.getCovidInfo(country);
    }
}
