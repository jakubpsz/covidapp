package com.jakubpszczolka.covidapp.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakubpszczolka.covidapp.Model.DTO.CovidInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@Slf4j
public class CovidApiServiceImpl implements CovidApiService {

    private final RestTemplate restTemplate;

    public CovidApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CovidInfoDto getCovidInfo(String country) throws IOException {
        String url =  "https://covid-19-data.p.rapidapi.com/country?name=" + country;

        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.GET, createRequest(), String.class);

        if(response.getStatusCode() == HttpStatus.OK) {
            return parseJSONtoCovidInfo(parseResponseToJSON(response.getBody()));
        } else {
            log.error("Could not get covid info for " + country);
            return null;
        }
    }

    private HttpEntity<HttpHeaders> createRequest() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-rapidapi-key", "8112b02f25mshe599c7cd4323d07p14779ajsn5613d2018835");
        httpHeaders.set("x-rapidapi-host", "covid-19-data.p.rapidapi.com");
        HttpEntity<HttpHeaders> request = new HttpEntity<>(httpHeaders);
        return request;
    }

    private JsonNode parseResponseToJSON(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        root = mapper.readTree(response);
        return root;
    }

    private CovidInfoDto parseJSONtoCovidInfo(JsonNode jsonNode){
        CovidInfoDto covidInfoDto = new CovidInfoDto();
        covidInfoDto.setCountry(jsonNode.get(0).get("country").asText());
        covidInfoDto.setLastChange(jsonNode.get(0).get("lastChange").asText());
        covidInfoDto.setLastUpdate(jsonNode.get(0).get("lastUpdate").asText());
        covidInfoDto.setConfirmed(jsonNode.get(0).get("confirmed").asLong());
        covidInfoDto.setRecovered(jsonNode.get(0).get("recovered").asLong());
        covidInfoDto.setCritical(jsonNode.get(0).get("critical").asLong());
        covidInfoDto.setDeaths(jsonNode.get(0).get("deaths").asLong());
        return covidInfoDto;
    }
}
