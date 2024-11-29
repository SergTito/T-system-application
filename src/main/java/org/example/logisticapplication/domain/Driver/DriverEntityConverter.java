package org.example.logisticapplication.domain.Driver;

import org.example.logisticapplication.utils.DriverDefaultValues;
import org.springframework.stereotype.Component;

@Component
public class DriverEntityConverter {
    private final DriverDefaultValues defaultValues;

    public DriverEntityConverter(
            DriverDefaultValues defaultValues
    ) {
        this.defaultValues = defaultValues;
    }

    public DriverEntity toEntity(Driver driver) {
        return new DriverEntity(
                driver.id(),
                driver.name(),
                driver.secondName(),
                driver.personNumber(),
                driver.numberOfHoursWorked() != null
                        ? driver.numberOfHoursWorked()
                        : defaultValues.getDefaultHoursWorked(),
                defaultValues.getDefaultStatus(),
                null,
                null
        );
    }

    public Driver toDomain(DriverEntity driver) {
        return new Driver(
                driver.getId(),
                driver.getName(),
                driver.getSecondName(),
                driver.getPersonNumber(),
                driver.getNumberOfHoursWorked() != null
                        ? driver.getNumberOfHoursWorked()
                        : defaultValues.getDefaultHoursWorked(),
                defaultValues.getDefaultStatus(),
                defaultValues.getCurrentCityId(),
                driver.getCurrentTruck() != null
                        ? driver.getCurrentTruck().getId()
                        : defaultValues.getCurrentTruckId()
        );
    }
}
