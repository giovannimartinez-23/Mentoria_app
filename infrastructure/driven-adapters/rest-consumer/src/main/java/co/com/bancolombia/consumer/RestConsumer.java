package co.com.bancolombia.consumer;

import co.com.bancolombia.commons.exceptions.ResourceNotFoundException;
import co.com.bancolombia.port.in.IBusinessServiceRestPort;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import co.com.bancolombia.model.ObjectResponse;

@Service
@RequiredArgsConstructor
public class RestConsumer implements IBusinessServiceRestPort {
    private final WebClient client;


    @CircuitBreaker(name = "testGet")
    public Mono<ObjectResponse> getExternalData() {
        return client
                .get()
                .uri("/api/v1/ruta-inventada")
                .retrieve()
                // errores 4xx
                .onStatus(status -> status.is4xxClientError(), clientResponse -> {
                    //404
                    if (clientResponse.statusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new ResourceNotFoundException("El recurso solicitado no existe en el sistema externo."));
                    }
                    return clientResponse.createException().flatMap(Mono::error);
                })
                .bodyToMono(ObjectResponse.class);
    }
}
