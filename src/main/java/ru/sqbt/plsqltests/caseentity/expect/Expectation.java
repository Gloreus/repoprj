package ru.sqbt.plsqltests.caseentity.expect;

import ru.sqbt.plsqltests.caseentity.CaseResponse;
import ru.sqbt.plsqltests.caseentity.TestCase;
import ru.sqbt.plsqltests.caseentity.TestResultData;

import java.util.function.Function;

///  Ожидаемый результат выполнения тест-кейса
public interface Expectation<T> {
    TestResultData validate(Function<TestCase, CaseResponse<T>> testRunner);
}
