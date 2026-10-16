package co.com.bancolombia.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String codigoError;
    private String error;
    private String mensaje_tecnico;
    private String mensaje_usuario;
}