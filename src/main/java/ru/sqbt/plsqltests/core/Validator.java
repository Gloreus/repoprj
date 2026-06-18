package ru.sqbt.plsqltests.core;

public interface Validator {
    ValidationType getType();

    /// Сравниваем ожидания с ответом сервера
    void validate(ExpectationData expectationData, TestResultData testResultData) throws AssertionError;
}