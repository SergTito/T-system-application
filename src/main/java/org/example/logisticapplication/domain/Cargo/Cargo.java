package org.example.logisticapplication.domain.Cargo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

public record Cargo(
        @Null
        Long id,

        @NotBlank
        Integer cargoNumber,

        @NotBlank
        String cargoName,

        @NotBlank
        Integer cargoMass,

        @NotBlank
        String cargoStatus
) {
}
