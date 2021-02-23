package com.jakubpszczolka.covidapp.Repositories;

import com.jakubpszczolka.covidapp.Model.CovidInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CovidInfoRepository extends JpaRepository<CovidInfo, UUID> {
}
