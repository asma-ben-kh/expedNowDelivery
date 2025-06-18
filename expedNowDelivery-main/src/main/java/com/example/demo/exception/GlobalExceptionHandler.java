package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.exception.EmptyDemandeListException;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NotSaved.class)
    public ResponseEntity<String> handleNotSaved(NotSaved ex){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
    }

 

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(VehiculeAlreadyExistException.class)
    public  ResponseEntity<List<String>> handleVehiculeAlreadyExistException(VehiculeAlreadyExistException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getFields());
    }
}
