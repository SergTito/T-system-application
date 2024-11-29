package org.example.logisticapplication.domain.Truck;

import jakarta.validation.constraints.Null;
import org.example.logisticapplication.domain.City.CityEntity;
import org.example.logisticapplication.domain.Driver.DriverEntity;

public record TruckDto(
        @Null
        Long id,

        String registrationNumber,

        Integer driversShift,

        String status,

        Double capacity,

        Integer currentCityId,

        Integer currentDriverId

) {
}
