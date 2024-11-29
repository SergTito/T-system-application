package org.example.logisticapplication.service;

import lombok.RequiredArgsConstructor;
import org.example.logisticapplication.domain.Driver.Driver;
import org.example.logisticapplication.domain.Driver.DriverEntityConverter;
import org.example.logisticapplication.repository.DriverRepository;
import org.example.logisticapplication.repository.TruckRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BusinessLogicService implements DriverLogicService {
    private final DriverRepository driverRepository;
    private final TruckRepository truckRepository;
    private final DriverEntityConverter driveEntityConverter;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Driver addTruckForDriver(
            Long driverId,
            Long truckId
    ) {

        if (driverId == null || truckId == null) {
            throw new IllegalArgumentException(
                    "Driver id or Truck id cannot be null"
            );
        }

        var driverEntity = driverRepository.findById(driverId).orElseThrow(
                () -> new IllegalArgumentException(
                        "Driver does not exist with id=%s"
                                .formatted(driverId)
                )
        );

        var truckEntity = truckRepository.findById(truckId).orElseThrow(
                () -> new IllegalArgumentException(
                        "Truck does not exist with id=%s"
                                .formatted(truckId)
                )
        );


        driverEntity.setCurrentTruck(truckEntity);

        driverRepository.save(driverEntity);

        return driveEntityConverter.toDomain(driverEntity);
    }
}
