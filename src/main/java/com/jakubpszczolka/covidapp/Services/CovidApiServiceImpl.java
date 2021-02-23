package com.jakubpszczolka.covidapp.Services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CovidApiServiceImpl implements CovidApiService {

    private final RestTemplate restTemplate;

    public CovidApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getCovidInfo(String country) {
        String url =  "https://covid-19-data.p.rapidapi.com/country?name=" + country;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-rapidapi-key", "8112b02f25mshe599c7cd4323d07p14779ajsn5613d2018835");
        httpHeaders.set("x-rapidapi-host", "covid-19-data.p.rapidapi.com");
        HttpEntity<HttpHeaders> request = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> result = restTemplate
                .exchange(url, HttpMethod.GET, request, String.class);
        if(result.getStatusCode() == HttpStatus.OK) {
            return result.getBody();
        } else {
            return null;
        }
    }
}
