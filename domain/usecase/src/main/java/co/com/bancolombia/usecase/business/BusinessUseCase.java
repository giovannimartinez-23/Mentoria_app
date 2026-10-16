package co.com.bancolombia.usecase.business;

import co.com.bancolombia.model.Data;
import co.com.bancolombia.model.ObjectResponse;
import co.com.bancolombia.port.in.IBusinessServicePort;
import co.com.bancolombia.port.in.IBusinessServiceRestPort;
import co.com.bancolombia.port.out.IBusinessPersistencePort;

import reactor.core.publisher.Mono;


public class BusinessUseCase implements IBusinessServicePort {

    private final IBusinessPersistencePort iBusinessPersistencePort;
    private final IBusinessServiceRestPort externalServicePort;

    public BusinessUseCase(IBusinessPersistencePort iBusinessPersistencePort,
                           IBusinessServiceRestPort externalServicePort) {
        this.iBusinessPersistencePort = iBusinessPersistencePort;
        this.externalServicePort = externalServicePort;
    }

    //Obtener informacion de la data
    @Override
    public Mono<Data> ObtenerDatoPort() {
        return this.iBusinessPersistencePort.get();
    }

    @Override
    public Mono<ObjectResponse> testExternalCall() {
        return this.externalServicePort.getExternalData();
    }
}
