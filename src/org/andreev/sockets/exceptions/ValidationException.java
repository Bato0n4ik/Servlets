package org.andreev.sockets.exceptions;

import lombok.Getter;
import org.andreev.sockets.validation.Error;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException{
    @Getter
    private List<Error> errors;

    public ValidationException(List<Error> errors){
        this.errors = errors;
    }
}
