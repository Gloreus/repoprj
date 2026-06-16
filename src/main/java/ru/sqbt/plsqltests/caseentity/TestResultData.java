package ru.sqbt.plsqltests.caseentity;

import lombok.Data;

import java.time.LocalDateTime;

/// Результат выполнения теста
@Data
public class TestResultData {
    private LocalDateTime dateTime;
    /// Уникальный ID кейса (GUID), не обязательно
    private String testUid;
    private String name;
    private String systemName;
    /// Продолжительность выполнения теста в мсек
    private long duration;
    /// Дополнительные пояснения, текст ошибки если нужно
    private String description;
    /// Успех, провален, иное...
    private String status;
}