package org.example.logisticapplication.domain.RoutePoint;

import jakarta.validation.constraints.Null;

public record RoutePoint(
        @Null
        Long id,
        String city,
        Integer cargoId,
        String operationType
) {
}
