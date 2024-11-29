package org.example.logisticapplication.domain.Driver;

import org.example.logisticapplication.utils.DriverDefaultValues;
import org.springframework.stereotype.Component;

@Component
public class DriverConverter {
    private final DriverDefaultValues defaultValues;

    public DriverConverter(
            DriverDefaultValues defaultValues
    ) {
        this.defaultValues = defaultValues;
    }

    public DriverDto toDto(Driver driver) {
        return new DriverDto(
                driver.id(),
                driver.name(),
                driver.secondName(),
                driver.personNumber(),
                driver.numberOfHoursWorked() != null
                        ? driver.numberOfHoursWorked()
                        : defaultValues.getDefaultHoursWorked(),
                defaultValues.getDefaultStatus(),
                defaultValues.getCurrentCityId(),
                driver.currentTruckId() != null
                        ? driver.currentCityId()
                        : defaultValues.getCurrentTruckId()
        );
    }

    public Driver toDomain(DriverDto driver) {
        return new Driver(
                driver.id(),
                driver.name(),
                driver.secondName(),
                driver.personNumber(),
                driver.numberOfHoursWorked() != null
                        ? driver.numberOfHoursWorked()
                        : defaultValues.getDefaultHoursWorked(),
                defaultValues.getDefaultStatus(),
                defaultValues.getCurrentCityId(),
                driver.currentTruckId() != null
                        ? driver.currentCityId()
                        : defaultValues.getCurrentTruckId()
        );
    }
}
