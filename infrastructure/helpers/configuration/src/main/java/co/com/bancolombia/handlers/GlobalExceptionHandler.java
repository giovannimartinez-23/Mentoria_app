package co.com.bancolombia.handlers;

import co.com.bancolombia.commons.exceptions.ResourceNotFoundException;
import co.com.bancolombia.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
//
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .codigoError("ERR-404")
//                .error("NOT_FOUND")
//                .mensaje_tecnico(ex.getMessage()) // Aquí viene el mensaje de tu excepción
//                .mensaje_usuario("El servicio externo no encontró la información solicitada.")
//                .build();
//
//        // Retorna el JSON estructurado y cambia el status HTTP de 500 a 404
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
   }