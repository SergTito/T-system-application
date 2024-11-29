package org.example.logisticapplication.domain.City;


import jakarta.validation.constraints.Null;

import java.util.List;

public record CityDto(
        @Null
        Long id,

        String name,

        String country
) {
}
