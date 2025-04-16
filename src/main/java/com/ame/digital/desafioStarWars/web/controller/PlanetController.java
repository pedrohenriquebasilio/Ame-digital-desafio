package com.ame.digital.desafioStarWars.web.controller;


import com.ame.digital.desafioStarWars.application.usecase.Planet.*;
import com.ame.digital.desafioStarWars.infraestructure.data.core.mapper.PlannetMapper;
import com.ame.digital.desafioStarWars.infraestructure.dto.PlanetRequestDTO;
import com.ame.digital.desafioStarWars.infraestructure.dto.PlanetResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetController {
    private final CreatePlanetUseCase planetUseCase;

    private final GetAllPlanetsUseCase allPlanetsUseCase;

    private final GetPlanetByIdUseCase planetByIdUseCase;

    private final GetPlannetByName plannetByName;

    private final UpdatePlanetUseCase updatePlanetUseCase;

    private final DeletePlanetUseCase deletePlanetUseCase;

    private final PlannetMapper plannetMapper;

    public PlanetController(CreatePlanetUseCase planetUseCase, GetAllPlanetsUseCase allPlanetsUseCase, GetPlanetByIdUseCase planetByIdUseCase, GetPlannetByName plannetByName, UpdatePlanetUseCase updatePlanetUseCase, DeletePlanetUseCase deletePlanetUseCase, PlannetMapper plannetMapper) {
        this.planetUseCase = planetUseCase;
        this.allPlanetsUseCase = allPlanetsUseCase;
        this.planetByIdUseCase = planetByIdUseCase;
        this.plannetByName = plannetByName;
        this.updatePlanetUseCase = updatePlanetUseCase;
        this.deletePlanetUseCase = deletePlanetUseCase;
        this.plannetMapper = plannetMapper;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createPlanet(@RequestBody PlanetRequestDTO requestDTO){
        this.planetUseCase.execute(this.plannetMapper.requestDTOToDomainObject(requestDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updatePlanet(@RequestBody PlanetResponseDTO responseDTO){
        this.planetUseCase.execute(this.plannetMapper.responseDTOToDomainObject(responseDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deletePlanet(@RequestBody PlanetResponseDTO responseDTO){
        this.deletePlanetUseCase.execute(this.plannetMapper.responseDTOToDomainObject(responseDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/All")
    public ResponseEntity<List<PlanetResponseDTO>> getAllPlanet(){
       List<PlanetResponseDTO> responseDTOList = this.allPlanetsUseCase.execute(null).stream().map(this.plannetMapper::domainObjectToResponseDTO).toList();
       return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }

    @GetMapping("{/planetid}")
    public ResponseEntity<PlanetResponseDTO> getPlanetById(@PathVariable Integer planetId){
        return new ResponseEntity<>(this.plannetMapper.domainObjectToResponseDTO(this.planetByIdUseCase.execute(planetId)), HttpStatus.OK);
    }
    @GetMapping("{/planetname}")
    public ResponseEntity<PlanetResponseDTO> getPlanetByName(@PathVariable String name){
        return new ResponseEntity<>(this.plannetMapper.domainObjectToResponseDTO(this.plannetByName.execute(name)), HttpStatus.OK);
    }
}
