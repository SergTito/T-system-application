package org.example.logisticapplication.domain.Truck;

import org.springframework.stereotype.Component;

@Component
public class TruckDtoConverter {

    public TruckDto toDto(
            Truck truck
    ) {
        return new TruckDto(
                truck.id(),
                truck.registrationNumber(),
                truck.driversShift(),
                truck.status(),
                truck.capacity(),
                truck.currentCityId(),
                truck.currentDriverId()
        );
    }

    public Truck toDomain(
            TruckDto truck
    ) {
        return new Truck(
                truck.id(),
                truck.registrationNumber(),
                truck.driversShift(),
                truck.status(),
                truck.capacity(),
                truck.currentCityId(),
                truck.currentDriverId()
        );
    }
}
