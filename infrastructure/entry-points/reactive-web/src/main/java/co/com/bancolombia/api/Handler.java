package co.com.bancolombia.api;

import co.com.bancolombia.configuration.TracePrototype;
import co.com.bancolombia.configuration.TraceSingleton;
import co.com.bancolombia.model.Data;
import co.com.bancolombia.port.in.IBusinessServicePort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class Handler {
    private final IBusinessServicePort businessUseCase;

    private final TraceSingleton traceSingleton;
    private final TracePrototype tracePrototype;
    private String name;

    public Mono<ServerResponse> compararScopes(ServerRequest request) {
        log.info("--- En handler ---");
        log.info("Singleton HashCode: {}", traceSingleton.hashCode());
        log.info("Prototype HashCode: {}", tracePrototype.hashCode());

        return ServerResponse.ok().bodyValue("Revisar la consola para ver los HashCodes");
    }

    public Mono<ServerResponse> listenGETDataWrong(ServerRequest serverRequest) {

        this.name = serverRequest.queryParam("nombre").orElse("Anónimo");

        return Mono.delay(Duration.ofSeconds(1))
                .flatMap(delay -> {
                    log.warn("WRONG - Devolviendo datos para: {}", this.name);

                    Mono<Data> res = businessUseCase.ObtenerDatoPort();
                    return ServerResponse.ok().body(res, Data.class);
                });
    }

    public Mono<ServerResponse> listenGETDataCorrect(ServerRequest serverRequest) {


        String nombre = serverRequest.queryParam("nombre").orElse("Anónimo");

        return Mono.delay(Duration.ofSeconds(1))
                .flatMap(delay -> {
                    log.info("CORRECTO - Devolviendo datos para: {}", nombre);

                    Mono<Data> res = businessUseCase.ObtenerDatoPort();
                    return ServerResponse.ok().body(res, Data.class);
                });
    }
    public Mono<ServerResponse> listenGETData(ServerRequest serverRequest) {
        Mono<Data> res = businessUseCase.ObtenerDatoPort();
        return ServerResponse.ok().body(res, Data.class);
    }


/*
    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }*/
}
