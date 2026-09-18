package co.com.bancolombia.configuration;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TraceSingleton {
    public TraceSingleton() {
        log.info("Creando instancia de TraceSingleton");
    }
}