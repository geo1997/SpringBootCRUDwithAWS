package com.sre.exercise.exception;

public class UserDoesNotExist extends Exception{

    public UserDoesNotExist() {
        super();
    }


    public UserDoesNotExist(String message) {
        super(message);
    }
}
