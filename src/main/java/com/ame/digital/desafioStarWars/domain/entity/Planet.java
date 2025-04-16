package com.ame.digital.desafioStarWars.domain.entity;


import com.ame.digital.desafioStarWars.infraestructure.data.entitiyDB.PlanetDB;
import com.ame.digital.desafioStarWars.infraestructure.dto.PlanetRequestDTO;
import com.ame.digital.desafioStarWars.infraestructure.dto.PlanetResponseDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Planet implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String climate;

    private String terrain;

    private String FilmAppearences;

    private Planet(String name, String climate, String terrain, String FilmAppearences) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.FilmAppearences = FilmAppearences;

    }

    private Planet( int id, String name, String climate, String terrain, String FilmAppearences) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.FilmAppearences = FilmAppearences;

    }

    public static Planet withRequestDTO(PlanetRequestDTO planetRequestDTO) {
        return new Planet(
                planetRequestDTO.name(),
                planetRequestDTO.climate(),
                planetRequestDTO.terrain(),
                planetRequestDTO.filmAppearences()
        );
    }

    public static Planet withResponseDTO(PlanetResponseDTO planetResponseDTO) {
        return new Planet(
                planetResponseDTO.id(),
                planetResponseDTO.name(),
                planetResponseDTO.climate(),
                planetResponseDTO.terrain(),
                planetResponseDTO.filmAppearences()
        );
    }

    public static Planet withPlanetDB(PlanetDB planetDB) {
        return  new Planet(
                //planetDB.getId(),
                planetDB.getName(),
                planetDB.getClimate(),
                planetDB.getTerrain(),
                planetDB.getFilmAppearances()
        );
    }
}
