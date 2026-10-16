package co.com.bancolombia.port.in;

import co.com.bancolombia.model.ObjectResponse;
import reactor.core.publisher.Mono;

public interface IBusinessServiceRestPort {
    Mono<ObjectResponse> getExternalData();
}
