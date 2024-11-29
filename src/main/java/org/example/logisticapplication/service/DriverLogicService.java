package org.example.logisticapplication.service;

import org.example.logisticapplication.domain.Driver.Driver;
import org.example.logisticapplication.domain.Truck.Truck;

@Service
public interface DriverLogicService {

    Driver addTruckForDriver(Long driverId, Long truck);
}
