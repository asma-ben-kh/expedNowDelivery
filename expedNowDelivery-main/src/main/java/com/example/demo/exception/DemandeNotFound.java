package com.example.demo.exception;

public class DemandeNotFound extends RuntimeException{

    public DemandeNotFound(String message){
        super(message);
    }
}
