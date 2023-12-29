package eu.wilkolek.springopentelemetry.car;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.random.RandomGenerator;

@Component
public class CarDataGeneration {

    private final CarRepository repository;

    private static final Integer RECORDS_COUNT = 10000;
     private static final RandomGenerator randomGenerator = new Random();

    public CarDataGeneration(CarRepository repository) {
        this.repository = repository;
    }

    @PostConstruct()
    public void generate() {
        for (int i = 0; i<RECORDS_COUNT; i++) {
            repository.save(
                    new Car("Car" + i, i * 25, "Brand " + i, OffsetDateTime.now().plusDays(randomGenerator.nextInt() % 200), LocalDate.now().plusDays(randomGenerator.nextInt() % 150))
            );
        }
    }
}
