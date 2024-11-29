package org.example.logisticapplication.domain.City;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.logisticapplication.domain.CountryMap.CountryMapEntity;
import org.example.logisticapplication.domain.Distance.DistanceEntity;


import java.util.List;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    public CityEntity(
            Long id,
            String name,
            String country
    ) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public CityEntity() {}
}
