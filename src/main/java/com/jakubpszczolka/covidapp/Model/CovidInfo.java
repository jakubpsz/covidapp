package com.jakubpszczolka.covidapp.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CovidInfo {

    private String country;
    private long confirmed;
    private long recovered;
    private long critical;
    private long deaths;
    private LocalDateTime lastChange;
    private LocalDateTime lastUpdate;
}
