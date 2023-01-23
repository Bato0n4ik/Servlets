package org.andreev.sockets.validation;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    @Getter
    private List<Error> errors = new ArrayList<>();

    public void addError(Error error){
        errors.add(error);
    }

    public boolean isValid(){
        return errors.isEmpty();
    }
}
