package org.example.logisticapplication.domain.Cargo;

import jakarta.validation.constraints.Null;

public record CargoDto(
        @Null
        Long id,

        Integer cargoNumber,

        String cargoName,

        Integer cargoMass,

        String cargoStatus
) {
}
