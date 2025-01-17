package org.example.logisticapplication.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.logisticapplication.domain.Truck.Truck;
import org.example.logisticapplication.domain.Truck.TruckDto;
import org.example.logisticapplication.domain.Truck.TruckDtoConverter;
import org.example.logisticapplication.service.TruckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trucks")
@RequiredArgsConstructor
@Slf4j
public class TruckController {
    private final TruckService truckService;
    private final TruckDtoConverter dtoConverter;

    @PostMapping
    public ResponseEntity<TruckDto> createTruck(
            @RequestBody TruckDto truckDto
    ) {
        log.info("Get request for creating truck: {}", truckDto);

        var savedTruck = truckService.createNewTruck(
                dtoConverter.toDomain(truckDto)
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dtoConverter.toDto(savedTruck));
    }

    @GetMapping
    public ResponseEntity<List<TruckDto>> getAllTrucks() {
        log.info("Get request for getting all trucks");
        var allTrucks = truckService.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        allTrucks.stream()
                                .map(dtoConverter::toDto)
                                .toList()
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TruckDto> getTruckById(
            @PathVariable Long id
    ) {
        log.info("Get request for getting truck by id: {}", id);
        var truck = truckService.findById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoConverter.toDto(truck));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TruckDto> updateTruck(
            @PathVariable("id") Long id,
            @RequestBody Truck truck
    ) {
        log.info("Update request for getting truck by id: {}", id);

        var updateTruck = truckService.updateTruck(id, truck);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoConverter.toDto(updateTruck));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTruck(
            @PathVariable("id") Long id
    ) {
        log.info("Delete request for deleting truck: {}", id);
        truckService.deleteTruck(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
