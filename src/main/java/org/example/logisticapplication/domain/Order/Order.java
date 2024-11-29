package org.example.logisticapplication.domain.Order;

import org.example.logisticapplication.domain.RoutePoint.RoutePointDto;

import java.util.List;

public record Order(
        Long id,
        String uniqueNumber,
        RoutePointDto routePoint,
        Integer truckId,
        List<Integer> driversId
) {
}
