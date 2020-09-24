package com.example.fedex_backend.exceptionhandler;

import com.example.fedex_backend.exceptions.ProgramNotFoundByIdException;
import com.example.fedex_backend.models.httpresponse.HttpResponse;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@NoArgsConstructor
@ControllerAdvice
public class ProgramExceptionHandler {
    @ExceptionHandler(value = ProgramNotFoundByIdException.class)
    public ResponseEntity<?> programNotFoundByIdException(ProgramNotFoundByIdException e) {
        return createHttpResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase()), httpStatus);
    }
}
