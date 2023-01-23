package org.andreev.sockets.validation;

public interface Validation <T>{

    ValidationResult isValid(T validationObject);
}
