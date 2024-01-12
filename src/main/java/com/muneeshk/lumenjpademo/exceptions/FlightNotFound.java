package com.muneeshk.lumenjpademo.exceptions;

public class FlightNotFound  extends RuntimeException {
    public FlightNotFound(String message) {
        super(message);
    }
}