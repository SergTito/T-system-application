package org.example.logisticapplication.domain.CountryMap;

import org.example.logisticapplication.domain.City.CityEntity;
import org.example.logisticapplication.domain.Distance.DistanceEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryMapEntityConverter {

    public CountryMap toDomain(
            CountryMapEntity entity
    ) {
        return new CountryMap(
                entity.getId(),
                entity.getCountryName(),
                entity.getCities()
                        .stream()
                        .map(CityEntity::getId)
                        .toList(),
                entity.getDistances()
                        .stream()
                        .map(DistanceEntity::getId)
                        .toList()
        );
    }

    public CountryMapEntity toEntity(
            CountryMap map,
            List<CityEntity> cities,
            List<DistanceEntity> distances
    ) {
        return new CountryMapEntity(
                map.id(),
                map.countryName(),
                cities,
                distances
        );
    }
}
