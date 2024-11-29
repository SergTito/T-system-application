package org.example.logisticapplication.domain.RoutePoint;


import jakarta.validation.constraints.Null;

public record RoutePointDto(
        @Null
        Long id,
        String city,
        Integer cargoId,
        String operationType
) {
}
