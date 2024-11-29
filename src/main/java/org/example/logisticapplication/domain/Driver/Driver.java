package org.example.logisticapplication.domain.Driver;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Driver(
        Long id,

        String name,

        String secondName,

        String personNumber,

        @JsonProperty("numOfHoursWorked")
        Integer numberOfHoursWorked,

        String status,

        @JsonProperty("cityId")
        Long currentCityId,

        @JsonProperty("truckId")
        Long currentTruckId
) {
}
