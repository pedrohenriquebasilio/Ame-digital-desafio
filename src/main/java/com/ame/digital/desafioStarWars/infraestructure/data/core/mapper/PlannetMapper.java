package com.ame.digital.desafioStarWars.infraestructure.data.core.mapper;


import com.ame.digital.desafioStarWars.domain.entity.Planet;
import com.ame.digital.desafioStarWars.infraestructure.data.entitiyDB.PlanetDB;
import com.ame.digital.desafioStarWars.infraestructure.dto.PlanetRequestDTO;
import com.ame.digital.desafioStarWars.infraestructure.dto.PlanetResponseDTO;

public class PlannetMapper {

    public PlanetRequestDTO domainObjectToRequestDTO(Planet planet){
        return  new PlanetRequestDTO(planet.getName(), planet.getClimate(), planet.getTerrain(), planet.getFilmAppearences());
    }

    public PlanetResponseDTO domainObjectToResponseDTO(Planet planet){
        return new PlanetResponseDTO(planet.getId(), planet.getName(), planet.getClimate(), planet.getTerrain(), planet.getFilmAppearences());
    }

    public Planet requestDTOToDomainObject(PlanetRequestDTO planetRequestDTO){
        return Planet.withRequestDTO(planetRequestDTO);
    }

    public Planet responseDTOToDomainObject(PlanetResponseDTO planetResponseDTO){
        return  Planet.withResponseDTO(planetResponseDTO);
    }

    public PlanetDB toPlanetDB(Planet planet){
        return new PlanetDB(planet);
    }

    public Planet toPlanet(PlanetDB planetDB){
        return  Planet.withPlanetDB(planetDB);
    }
}
