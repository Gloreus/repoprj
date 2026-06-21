package ru.sqbt.plsqltests.caseentity;

import lombok.Data;
import ru.sqbt.plsqltests.core.ExpectationData;
import ru.sqbt.plsqltests.core.TestCaseData;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestCase {
    /// Описание тест-кейса
    private TestCaseData testCaseData;
    /// Ожидаемые результаты, все должны выполниться для успешного теста
    private final List<ExpectationData> expectations = new ArrayList<>(1);
}
