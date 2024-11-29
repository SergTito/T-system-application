package org.example.logisticapplication.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.logisticapplication.domain.Driver.DriverConverter;
import org.example.logisticapplication.domain.Driver.DriverDto;
import org.example.logisticapplication.service.BusinessLogicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
@Slf4j
public class DriverLogisticController {
    private final BusinessLogicService businessLogicService;
    private final DriverConverter driverConverter;

    @PutMapping("/{driverId}/truck/{truckId}")
    public ResponseEntity<DriverDto> addTruck(
            @PathVariable("driverId") Long driverId,
            @PathVariable("truckId") Long truckId
    ) {
        log.info("Get request for adding truck {} to driver {}", truckId, driverId);
        var driver = businessLogicService.addTruckForDriver(driverId, truckId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        driverConverter.toDto(driver)
                );
    }
}
