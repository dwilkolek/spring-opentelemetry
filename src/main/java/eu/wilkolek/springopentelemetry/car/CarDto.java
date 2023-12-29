package eu.wilkolek.springopentelemetry.car;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public record CarDto(
        String name,
        Integer maxSpeed,
        String brand,
        OffsetDateTime createdAt,
        LocalDate manufacturedAt,

        String servicingWorkshop
) {
}