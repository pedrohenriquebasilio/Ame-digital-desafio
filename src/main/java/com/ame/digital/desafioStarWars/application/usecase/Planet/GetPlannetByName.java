package com.ame.digital.desafioStarWars.application.usecase.Planet;

import com.ame.digital.desafioStarWars.application.gateway.PlanetGateway;
import com.ame.digital.desafioStarWars.application.usecase.UseCase;
import com.ame.digital.desafioStarWars.domain.entity.Planet;

public class GetPlannetByName implements UseCase<String, Planet> {

    private final PlanetGateway planetGateway;

    public GetPlannetByName(PlanetGateway planetGateway) {
        this.planetGateway = planetGateway;
    }

    @Override
    public Planet execute(String name) {
        return this.planetGateway.getByName(name);
    }
}
