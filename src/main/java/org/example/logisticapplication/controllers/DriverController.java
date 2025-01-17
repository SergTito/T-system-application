package org.example.logisticapplication.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.logisticapplication.domain.Driver.Driver;
import org.example.logisticapplication.domain.Driver.DriverConverter;
import org.example.logisticapplication.domain.Driver.DriverDto;
import org.example.logisticapplication.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
@Slf4j
public class DriverController {
    private final DriverService driverService;
    private final DriverConverter driverConverter;

    @GetMapping
    public ResponseEntity<List<DriverDto>> findAll() {
        log.info("Find all drivers");

        var allDrivers = driverService.findAll();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        allDrivers.stream()
                                .map(driverConverter::toDto)
                                .toList()
                );
    }

    @PostMapping
    public ResponseEntity<DriverDto> addDriver(
            @RequestBody DriverDto driver
    ) {
        log.info("Get request for save driver driver: {}", driver);

        var savedDriver = driverService.createDriver(
                driverConverter.toDomain(driver)
        );

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        driverConverter.toDto(savedDriver)
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverDto> updateDriver(
            @PathVariable("id") Long id,
            @RequestBody Driver driver
    ) {
        log.info("Get request for update driver driver: {}", driver);

        var updatedDriver = driverService.updateDriver(id, driver);

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        driverConverter.toDto(updatedDriver)
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDto> getDriverById(
            @PathVariable Long id
    ) {
        log.info("Get request for get driver by id: {}", id);

        var foundedDriver = driverService.findById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        driverConverter.toDto(foundedDriver)
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriverById(
            @PathVariable Long id
    ) {
        log.info("Delete request for delete driver by id: {}", id);
        driverService.deleteDriver(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
