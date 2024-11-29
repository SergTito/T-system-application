package org.example.logisticapplication.domain.Truck;

import org.springframework.stereotype.Component;

@Component
public class TruckEntityConverter {

    public Truck toDomain(
            TruckEntity truck
    ) {
        return new Truck(
                truck.getId(),
                truck.getRegistrationNumber(),
                truck.getDriversShift(),
                truck.getStatus(),
                truck.getCapacity(),
                null,
                null
        );
    }

    public TruckEntity toTruckEntity(
            Truck truck
    ) {
        return new TruckEntity(
                truck.id(),
                truck.registrationNumber(),
                truck.driversShift(),
                truck.status(),
                truck.capacity(),
                null
        );
    }

}
