package eu.wilkolek.springopentelemetry.workshop;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;


@Service
public class WorkshopService {



    @WithSpan
    public String findWorkshop(UUID carUuid) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Workshop " + Arrays.stream(carUuid.toString().split("-")).findFirst().orElse("NONE");
    }
}
