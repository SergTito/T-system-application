package org.example.logisticapplication.service;

import lombok.RequiredArgsConstructor;
import org.example.logisticapplication.domain.City.City;
import org.example.logisticapplication.domain.City.CityDto;
import org.example.logisticapplication.domain.City.CityEntity;
import org.example.logisticapplication.domain.City.CityEntityConverter;
import org.example.logisticapplication.repository.CityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CityEntityConverter cityEntityConverter;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public City addNewCity(
            City city
    ) {
        if (cityRepository.existsCityEntityByName(city.name())) {
            throw new IllegalArgumentException(
                    "City with name=%s already exists!"
                            .formatted(city.name())
            );
        }

        var savedCity = cityRepository.save(
                cityEntityConverter.toEntity(city)
        );


        return cityEntityConverter.toDomain(savedCity);

    }

    @Transactional(readOnly = true)
    public City findById(
            Long id
    ) {
        var cityEntity = cityRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(
                        "City with id=%s not found!"
                                .formatted(id)
                )
        );

        return cityEntityConverter.toDomain(cityEntity);
    }

    @Transactional(readOnly = true)
    public List<City> findAll() {
        var allCities = cityRepository.findAll();
        if (allCities.isEmpty()) {
            return new ArrayList<>();
        }

        return allCities
                .stream()
                .map(cityEntityConverter::toDomain)
                .toList();
    }
}
