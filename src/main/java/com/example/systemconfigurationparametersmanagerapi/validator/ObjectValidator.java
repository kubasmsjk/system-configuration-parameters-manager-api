package com.example.systemconfigurationparametersmanagerapi.validator;

import com.example.systemconfigurationparametersmanagerapi.exceptions.ObjectNotValidException;
import jakarta.validation.*;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validate(T objectToValidate) {
        Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);

        if (!violations.isEmpty()) {
            var validFault = violations
                    .stream()
                    .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage,
                            (existing, replacement) -> existing));
            throw new ObjectNotValidException("ERROR", validFault);
        }
    }
}
