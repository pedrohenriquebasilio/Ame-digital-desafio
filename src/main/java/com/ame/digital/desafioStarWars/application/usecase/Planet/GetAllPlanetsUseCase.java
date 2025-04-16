package com.ame.digital.desafioStarWars.application.usecase.Planet;

import com.ame.digital.desafioStarWars.application.gateway.PlanetGateway;
import com.ame.digital.desafioStarWars.application.usecase.UseCase;
import com.ame.digital.desafioStarWars.domain.entity.Planet;

import java.util.List;

public class GetAllPlanetsUseCase implements UseCase<Void, List<Planet>> {

    private final PlanetGateway planetGateway;

    public GetAllPlanetsUseCase(PlanetGateway planetGateway) {
        this.planetGateway = planetGateway;
    }

    @Override
    public List<Planet> execute(Void unused) {
        return this.planetGateway.getAll();
    }
}
