package com.ame.digital.desafioStarWars.infraestructure.data.repository;

import com.ame.digital.desafioStarWars.infraestructure.data.entitiyDB.PlanetDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<PlanetDB, Integer> {

    PlanetDB findPlanetDBById(int id);

    PlanetDB findPlanetDBByName(String name);
}
