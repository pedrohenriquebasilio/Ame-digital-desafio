package com.ame.digital.desafioStarWars.application.usecase.Planet;

import com.ame.digital.desafioStarWars.application.gateway.PlanetGateway;
import com.ame.digital.desafioStarWars.application.usecase.UseCase;
import com.ame.digital.desafioStarWars.domain.entity.Planet;
import org.springframework.beans.factory.annotation.Autowired;

public class CreatePlanetUseCase implements UseCase<Planet, Planet> {


    private final PlanetGateway planetGateway;

    public CreatePlanetUseCase(PlanetGateway planetGateway) {
        this.planetGateway = planetGateway;
    }

    @Override
    public Planet execute(Planet planet) {

        if(
                planet == null ||
                        planet.getName().isEmpty() ||
                        planet.getClimate().isEmpty()||
                        planet.getTerrain().isEmpty()||
                        planet.getTerrain().isEmpty()
        ){
            throw  new  IllegalArgumentException("Invalid arguments");
        }
        return this.planetGateway.save(planet);
    }
}
