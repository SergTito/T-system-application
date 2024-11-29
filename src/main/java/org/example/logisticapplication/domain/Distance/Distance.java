package org.example.logisticapplication.domain.Distance;

import jakarta.validation.constraints.Null;

public record Distance(
        @Null
        Long id,

        Integer fromCityId,

        Integer toCityId,

        Integer distance
) {
}
