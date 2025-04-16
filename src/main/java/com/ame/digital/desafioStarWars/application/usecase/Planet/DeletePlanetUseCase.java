package com.ame.digital.desafioStarWars.application.usecase.Planet;

import com.ame.digital.desafioStarWars.application.gateway.PlanetGateway;
import com.ame.digital.desafioStarWars.application.usecase.UseCase;
import com.ame.digital.desafioStarWars.domain.entity.Planet;

public class DeletePlanetUseCase implements UseCase<Planet, Void> {

    private final PlanetGateway planetGateway;

    public DeletePlanetUseCase(PlanetGateway planetGateway) {
        this.planetGateway = planetGateway;
    }

    @Override
    public Void execute(Planet planet) {
        if(planet == null){
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.planetGateway.delete(planet);
        return null;
    }
}
