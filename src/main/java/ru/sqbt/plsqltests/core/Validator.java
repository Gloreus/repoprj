package ru.sqbt.plsqltests.core;

public interface Validator<T extends ExpectationData> {
    ValidationType getType();

    /// Сравниваем ожидания с ответом сервера
    void validate(T expectationData, TestResultData testResultData) throws AssertionError;
}