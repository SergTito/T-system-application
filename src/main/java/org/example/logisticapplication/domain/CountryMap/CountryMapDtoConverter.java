package org.example.logisticapplication.domain.CountryMap;

import org.springframework.stereotype.Component;

@Component
public class CountryMapDtoConverter {

    public CountryMapDto toDto(
            CountryMap countryMap
    ) {
        return new CountryMapDto(
                countryMap.id(),
                countryMap.countryName(),
                countryMap.citiesId(),
                countryMap.distancesId()
        );
    }

    public CountryMap toDomain(
            CountryMapDto countryMap
    ) {
        return new CountryMap(
                countryMap.id(),
                countryMap.countryName(),
                countryMap.citiesId(),
                countryMap.distancesId()
        );
    }
}
