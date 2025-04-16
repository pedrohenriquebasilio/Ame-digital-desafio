package com.ame.digital.desafioStarWars.infraestructure.data.core.gateway;

import com.ame.digital.desafioStarWars.application.gateway.PlanetGateway;
import com.ame.digital.desafioStarWars.domain.entity.Planet;
import com.ame.digital.desafioStarWars.infraestructure.data.core.mapper.PlannetMapper;
import com.ame.digital.desafioStarWars.infraestructure.data.entitiyDB.PlanetDB;
import com.ame.digital.desafioStarWars.infraestructure.data.repository.PlanetRepository;

import java.util.List;

public class PlanetRepositoryGateway implements PlanetGateway {

    private final PlanetRepository repository;
    private final PlannetMapper mapper;

    public PlanetRepositoryGateway(PlanetRepository repository, PlannetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Planet save(Planet object) {
        PlanetDB newPlanet = this.repository.save(this.mapper.toPlanetDB(object));
        return this.mapper.toPlanet(newPlanet);
    }

    @Override
    public Planet update(Planet object) {
        this.repository.save(this.mapper.toPlanetDB(object));
        return object;
    }

    @Override
    public void delete(Planet object) {
        this.repository.delete(this.mapper.toPlanetDB(object));
    }

    @Override
    public Planet getId(int ObjectId) {
        return this.mapper.toPlanet(this.repository.findPlanetDBById(ObjectId));
    }

    @Override
    public List<Planet> getAll() {
        return this.repository.findAll().stream().map(this.mapper::toPlanet).toList();
    }

    @Override
    public Planet getByName(String name) {
        return this.mapper.toPlanet(this.repository.findPlanetDBByName(name));
    }
}
