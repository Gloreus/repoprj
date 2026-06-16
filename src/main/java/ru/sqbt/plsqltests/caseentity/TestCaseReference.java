package ru.sqbt.plsqltests.caseentity;

import lombok.Data;

import java.util.UUID;

@Data
public class TestCaseReference {
    public static final String DEFAULT_ID = "";
    ///  Уникальный ID тесткейса, должен ссответствовать ID в файле
    private String testId = DEFAULT_ID;
    /// Путь к файлу тесткейса относительно корня репо
    private String filePath;
}
