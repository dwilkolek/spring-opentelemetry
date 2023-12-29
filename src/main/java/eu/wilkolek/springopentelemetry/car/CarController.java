package eu.wilkolek.springopentelemetry.car;


import eu.wilkolek.springopentelemetry.workshop.WorkshopService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {


    private final CarRepository repository;
    private final WorkshopService workshopService;

    public CarController(CarRepository repository, WorkshopService workshopService) {
        this.repository = repository;
        this.workshopService = workshopService;
    }

    @GetMapping("")
    public List<CarDto> cars() {
        return repository.findAll(PageRequest.of(3, 1000, Sort.by("id"))).stream().parallel().map(car -> new CarDto(
                car.getName(), car.getMaxSpeed(), car.getBrand(), car.getCreatedAt(), car.getManufacturedAt(), workshopService.findWorkshop(car.getId())
        )).toList();
    }



}
