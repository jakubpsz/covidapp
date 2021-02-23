package com.jakubpszczolka.covidapp.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class covidApiServiceImpl implements covidApiService {

    private final RestTemplate restTemplate;

    public covidApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void getCovidInfo(String country) {
        ResponseEntity
    }
}
