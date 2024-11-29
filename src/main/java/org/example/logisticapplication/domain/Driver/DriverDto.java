package org.example.logisticapplication.domain.Driver;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;

public record DriverDto(
        @Null
        Long id,

        String name,

        String secondName,

        String personNumber,

        @JsonProperty("numOfHoursWorked")
        @Null
        Integer numberOfHoursWorked,

        String status,

        @JsonProperty("cityId")
        Long currentCityId,

        @JsonProperty("truckId")
        Long currentTruckId
) {
}
