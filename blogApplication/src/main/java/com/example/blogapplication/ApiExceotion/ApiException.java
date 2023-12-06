package com.example.blogapplication.ApiExceotion;

public class ApiException extends RuntimeException{
    public ApiException(String message){

        super(message);
    }
}
