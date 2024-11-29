package org.example.logisticapplication.domain.City;

import org.springframework.stereotype.Component;

@Component
public class CityDtoConverter {
    public City toDomain(
            CityDto cityDto
    ) {
        return new City(
                cityDto.id(),
                cityDto.name(),
                cityDto.country()
        );
    }

    public CityDto toDto(
            City city
    ) {
        return new CityDto(
                city.id(),
                city.name(),
                city.country()
        );
    }
}
