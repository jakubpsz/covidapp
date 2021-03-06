package com.jakubpszczolka.covidapp.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidInfo {
    @Id
    @GeneratedValue
    private UUID id;

    private String country;
    private long confirmed;
    private long recovered;
    private long critical;
    private long deaths;
    private String lastChange;
    private String lastUpdate;
}
