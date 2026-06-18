package ru.sqbt.plsqltests.caseentity;

import lombok.Data;

/// Ответ исполнителя тест-кейса
@Data
public class TestCaseResponse<T> {
    private String message;
    private String status;
    private T value;
}
