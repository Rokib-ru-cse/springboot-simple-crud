package com.spring.crud.controller;

public class UserNotFoundException extends Throwable {

    public UserNotFoundException(String s) {
        super(s);
    }
}
