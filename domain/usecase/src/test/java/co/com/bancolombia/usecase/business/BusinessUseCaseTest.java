package co.com.bancolombia.usecase.business;

import co.com.bancolombia.model.Data;
import co.com.bancolombia.port.out.IBusinessPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class BusinessUseCaseTest {

    @Mock
    private IBusinessPersistencePort iBusinessPersistencePort;


    @InjectMocks
    private BusinessUseCase businessUseCase;

    @Test
    void obtenerDatoPort_debeRetornarDataCorrectamente() {

        // Preparamos un objeto
        Data dataEsperada = new Data();

        // Hacemos un mock para que devuelva el objeto
        when(iBusinessPersistencePort.get()).thenReturn(Mono.just(dataEsperada));


        // Llamamos al metodo real
        Mono<Data> resultadoMono = businessUseCase.ObtenerDatoPort();


        // Como es código Reactivo (Mono), se usa StepVerifier para suscribirnos al flujo y comprobar qué emite a lo largo del tiempo.
        StepVerifier.create(resultadoMono)
                .expectNext(dataEsperada) // Verificamos que el Mono emita lo que deseamos
                .verifyComplete();        // Verificamos que el flujo termine correctamente

        // Verificamos si el metodo get fue llamado
        verify(iBusinessPersistencePort, times(1)).get();
    }
}