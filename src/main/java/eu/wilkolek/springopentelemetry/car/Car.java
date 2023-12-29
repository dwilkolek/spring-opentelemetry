package eu.wilkolek.springopentelemetry.car;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
public class Car {

    @Id
    private UUID id = UUID.randomUUID();


    private String name;
    private Integer maxSpeed;

    private String brand;

    private OffsetDateTime createdAt;

    private LocalDate manufacturedAt;

    @Version
    private Integer version;

    public Car() {
    }

    public Car(String name, Integer maxSpeed, String brand, OffsetDateTime createdAt, LocalDate manufacturedAt) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.brand = brand;
        this.createdAt = createdAt;
        this.manufacturedAt = manufacturedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getManufacturedAt() {
        return manufacturedAt;
    }

    public void setManufacturedAt(LocalDate manufacturedAt) {
        this.manufacturedAt = manufacturedAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
