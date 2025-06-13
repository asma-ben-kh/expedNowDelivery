package com.example.demo.exception;

public class NotDeleted  extends RuntimeException{
    public NotDeleted(String message){
        super(message);
    }

}
