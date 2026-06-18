package ru.sqbt.plsqltests.core;

import lombok.Data;

import java.time.LocalDateTime;

/// Результат выполнения теста
@Data
public class TestResultData {
    /// Продолжительность выполнения теста в мсек
    private long duration;
    /// Сообщение при ошибке выполнения запроса от сервера
    private String errorMessage;
    /// Статус ответа от сервера, если требуется. При ошибке тут должен быть errorCode
    private String errorCode;
    /// Что вернул сервер
    private Object value;
}
