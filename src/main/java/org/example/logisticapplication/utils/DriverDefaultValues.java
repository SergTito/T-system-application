package org.example.logisticapplication.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class DriverDefaultValues {
    @Value("${driver.status}")
    private String defaultStatus;

    @Value("${driver.hoursWorked}")
    private Integer defaultHoursWorked;

    @Value("${driver.currentTruck:#{null}}")
    private Long currentTruckId;

    @Value("${driver.currentCity:#{null}}")
    private Long currentCityId;
}
