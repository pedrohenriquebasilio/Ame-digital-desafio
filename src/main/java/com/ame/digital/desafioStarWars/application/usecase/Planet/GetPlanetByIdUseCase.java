package com.ame.digital.desafioStarWars.application.usecase.Planet;

import com.ame.digital.desafioStarWars.application.gateway.PlanetGateway;
import com.ame.digital.desafioStarWars.application.usecase.UseCase;
import com.ame.digital.desafioStarWars.domain.entity.Planet;

public class GetPlanetByIdUseCase implements UseCase<Integer, Planet> {

    private final PlanetGateway planetGateway;

    public GetPlanetByIdUseCase(PlanetGateway planetGateway) {
        this.planetGateway = planetGateway;
    }

    @Override
    public Planet execute(Integer integer) {
        return this.planetGateway.getId(integer);
    }
}
