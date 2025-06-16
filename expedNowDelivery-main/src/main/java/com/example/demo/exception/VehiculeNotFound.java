package com.example.demo.exception;

public class VehiculeNotFound extends RuntimeException{

    public VehiculeNotFound(String message)
    {
        super(message);
    }

}
