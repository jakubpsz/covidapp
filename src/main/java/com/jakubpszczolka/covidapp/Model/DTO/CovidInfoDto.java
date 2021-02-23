package com.jakubpszczolka.covidapp.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
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

    @Override
    public String toString() {
        return  "country='" + country + '\'' +
                ", confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", critical=" + critical +
                ", deaths=" + deaths +
                ", lastChange='" + lastChange + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}
