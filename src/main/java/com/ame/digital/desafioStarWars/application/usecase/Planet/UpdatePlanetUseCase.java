package com.ame.digital.desafioStarWars.application.usecase.Planet;

import com.ame.digital.desafioStarWars.application.gateway.PlanetGateway;
import com.ame.digital.desafioStarWars.application.usecase.UseCase;
import com.ame.digital.desafioStarWars.domain.entity.Planet;

public class UpdatePlanetUseCase implements UseCase<Planet, Planet> {

    private final PlanetGateway planetGateway;

    public UpdatePlanetUseCase(PlanetGateway planetGateway) {
        this.planetGateway = planetGateway;
    }

    @Override
    public Planet execute(Planet planet) {
        return this.planetGateway.update(planet);
    }
}
