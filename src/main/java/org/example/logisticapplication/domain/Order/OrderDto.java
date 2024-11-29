package org.example.logisticapplication.domain.Order;

import jakarta.validation.constraints.Null;
import org.example.logisticapplication.domain.RoutePoint.RoutePointDto;

import java.util.List;

public record OrderDto(
        @Null
        Long id,
        String uniqueNumber,
        RoutePointDto routePoint,
        Integer truckId,
        List<Integer> driversId
) {
}
