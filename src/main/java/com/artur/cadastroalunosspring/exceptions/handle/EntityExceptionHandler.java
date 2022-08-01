package com.artur.cadastroalunosspring.exceptions.handle;

import com.artur.cadastroalunosspring.exceptions.AlunoNotFoundException;
import com.artur.cadastroalunosspring.exceptions.SalaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handle(Exception exception, HttpServletRequest request){

        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setMessage(exception.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(AlunoNotFoundException.class)
    public ResponseEntity<StandardError> handle(AlunoNotFoundException exception, HttpServletRequest request){

        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setMessage(exception.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(SalaNotFoundException.class)
    public ResponseEntity<StandardError> handle(SalaNotFoundException exception, HttpServletRequest request){

        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setMessage(exception.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}