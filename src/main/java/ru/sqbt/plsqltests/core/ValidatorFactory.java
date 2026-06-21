package ru.sqbt.plsqltests.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class ValidatorFactory {

    private final Map<ValidationType, Validator> validatorMap;

    public ValidatorFactory(List<Validator> validators) {
        this.validatorMap = validators.stream()
                .collect(Collectors.toMap(Validator::getType, validator -> validator));
    }

    public Validator getValidator(ValidationType type) {
        Validator validator = validatorMap.get(type);
        if (validator == null) {
            throw new IllegalArgumentException("No validator found for type: " + type);
        }
        return validator;
    }
}