package com.genie.TrainApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TrainAlreadyExistsException extends RuntimeException {
    public TrainAlreadyExistsException(String message) {
        super(message);
    }
}
