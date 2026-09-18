package co.com.bancolombia.dataadapter;

import co.com.bancolombia.configuration.TracePrototype;
import co.com.bancolombia.configuration.TraceSingleton;
import co.com.bancolombia.model.Data;
import co.com.bancolombia.port.out.IBusinessPersistencePort;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Slf4j
@Repository // Correcto
@AllArgsConstructor
public class DataAdapter implements IBusinessPersistencePort {

    private final TraceSingleton traceSingleton;
    private final TracePrototype tracePrototype;
    @PostConstruct
    public void logHashCodes() {
        log.info("--- EN Repositorio ---");
        log.info("Singleton HashCode: {}", traceSingleton.hashCode());
        log.info("Prototype HashCode: {}", tracePrototype.hashCode());
    }
    @Override
    public Mono<Data> get() {
        return Mono.just( new Data(1)) ;
    }
}
