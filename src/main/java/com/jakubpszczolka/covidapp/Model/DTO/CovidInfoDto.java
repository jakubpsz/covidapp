package com.jakubpszczolka.covidapp.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CovidInfoDto {

    private String country;
    private long confirmed;
    private long recovered;
    private long critical;
    private long deaths;
    private String lastChange;
    private String lastUpdate;
}
