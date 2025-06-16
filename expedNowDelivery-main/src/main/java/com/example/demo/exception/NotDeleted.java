package com.example.demo.exception;

public class NotDeleted  extends NotFoundException{
    public NotDeleted(String message){
        super(message);
    }

}
