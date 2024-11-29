package org.example.logisticapplication.service;

import lombok.RequiredArgsConstructor;
import org.example.logisticapplication.domain.Driver.DriverEntity;
import org.example.logisticapplication.domain.Truck.*;
import org.example.logisticapplication.repository.DriverRepository;
import org.example.logisticapplication.repository.TruckRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TruckService {
    private final TruckRepository truckRepository;
    private final TruckEntityConverter entityConverter;
    private final TruckDtoConverter dtoConverter;
    private final DriverRepository driverRepository;

    // Create new truck
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Truck createNewTruck(
            Truck truck
    ) {
        if (truckRepository.existsByRegistrationNumber(truck.registrationNumber())) {
            throw new IllegalArgumentException(
                    "Truck already exists with registration number=%s"
                            .formatted(truck.registrationNumber()));
        }

        var newTruck = truckRepository.save(
                entityConverter.toTruckEntity(truck)
        );

        return entityConverter.toDomain(newTruck);
    }

    // Find truck by id
    @Transactional(readOnly = true)
    public Truck findById(
            Long id
    ) {
        var truckEntity = truckRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(
                        "Truck does not exist with id=%s"
                                .formatted(id)
                )
        );

        return entityConverter.toDomain(truckEntity);
    }

    // Find all trucks
    @Transactional(readOnly = true)
    public List<Truck> findAll() {
        var allTrucks = truckRepository.findAll();
        if (allTrucks.isEmpty()) {
            return new ArrayList<>();
        }

        return allTrucks
                .stream()
                .map(entityConverter::toDomain)
                .toList();
    }

    // Delete truck
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void deleteTruck(
            Long id
    ) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "Id is null"
            );
        }

        var truckEntity = truckRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(
                        "Truck does not exist with id=%s"
                                .formatted(id)
                )
        );

        var allByCurrentDrivers = driverRepository.findAllByCurrentTruck(truckEntity);

        for (DriverEntity entity : allByCurrentDrivers) {
            entity.setCurrentTruck(null);
            driverRepository.save(entity);
        }

        truckRepository.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Truck updateTruck(
            Long id,
            Truck updateTruck
    ) {
        var truckById = findById(id);

        var updatedTruck = new Truck(
                truckById.id(),
                orDefault(updateTruck.registrationNumber(), truckById.registrationNumber()),
                orDefault(updateTruck.driversShift(), truckById.driversShift()),
                orDefault(updateTruck.status(), truckById.status()),
                orDefault(updateTruck.capacity(), truckById.capacity()),
                orDefault(updateTruck.currentCityId(), truckById.currentCityId()),
                orDefault(updateTruck.currentDriverId(), truckById.currentDriverId())
        );

        truckRepository.save(
                entityConverter.toTruckEntity(updatedTruck)
        );

        return updatedTruck;
    }

    private <T> T orDefault(T newValue, T currentValue) {
        return newValue != null ? newValue : currentValue;
    }
}
