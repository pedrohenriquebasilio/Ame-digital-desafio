package com.ame.digital.desafioStarWars.infraestructure.data.entitiyDB;

import com.ame.digital.desafioStarWars.domain.entity.Planet;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "planet")
@EqualsAndHashCode(of = "id")
public class PlanetDB implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;



    @Id
    private int id;

    private String name;

    private String climate;

    private String terrain;

    @Column(name = "film_appeareces")
    private String filmAppearances;

    public PlanetDB(Planet planet) {
        this.id = planet.getId();
        this.climate = planet.getClimate();
        this.terrain = planet.getTerrain();
        this.filmAppearances = planet.getFilmAppearences();
    }
}
