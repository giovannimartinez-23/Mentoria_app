package co.com.bancolombia.port.in;

import co.com.bancolombia.model.Data;
import co.com.bancolombia.model.ObjectResponse;
import reactor.core.publisher.Mono;

public interface IBusinessServicePort {

    Mono<Data> ObtenerDatoPort ();
    Mono<ObjectResponse> testExternalCall();
}
