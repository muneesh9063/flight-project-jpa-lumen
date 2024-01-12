package com.muneeshk.lumenjpademo.apis;

import com.muneeshk.lumenjpademo.exceptions.FlightNotFound;
import com.muneeshk.lumenjpademo.exceptions.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandlerAdvice {
    private final Logger logger;

    public ApplicationExceptionHandlerAdvice() {
        this.logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException e){
        logger.warn(e.getMessage());
        return ResponseEntity.status(404).body(Map.of("error",e.getMessage()));
    }
    @ExceptionHandler(FlightNotFound.class)
    public ResponseEntity<?> handleRecordNotFoundException(FlightNotFound e){
        logger.warn(e.getMessage());
        return ResponseEntity.status(404).body(Map.of("error",e.getMessage()));
    }
}
