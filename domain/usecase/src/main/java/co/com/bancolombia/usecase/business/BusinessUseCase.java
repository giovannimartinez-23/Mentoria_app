package co.com.bancolombia.usecase.business;

import co.com.bancolombia.model.Data;
import co.com.bancolombia.port.in.IBusinessServicePort;
import co.com.bancolombia.port.out.IBusinessPersistencePort;

import reactor.core.publisher.Mono;


public class BusinessUseCase implements IBusinessServicePort {

    private final IBusinessPersistencePort iBusinessPersistencePort;

    public BusinessUseCase(IBusinessPersistencePort iBusinessPersistencePort) {
        this.iBusinessPersistencePort = iBusinessPersistencePort;
    }

    //Obtener informacion de la data
    @Override
    public Mono<Data> ObtenerDatoPort() {
        return this.iBusinessPersistencePort.get();
    }
}
