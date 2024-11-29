package org.example.logisticapplication.domain.City;

import org.springframework.stereotype.Component;

@Component
public class CityEntityConverter {

    public City toDomain(
            CityEntity cityEntity
    ) {
        return new City(
                cityEntity.getId(),
                cityEntity.getName(),
                cityEntity.getCountry()
        );
    }

    public CityEntity toEntity(
            City city
    ) {
        return new CityEntity(
                city.id(),
                city.name(),
                city.country()
        );
    }
}
