package ru.sqbt.plsqltests;

import lombok.extern.slf4j.Slf4j;
import ru.sqbt.plsqltests.caseentity.TestCaseResponse;
import ru.sqbt.plsqltests.core.DbValue;
import ru.sqbt.plsqltests.core.TestCaseData;
import ru.sqbt.plsqltests.ora.OracleTypes;

import java.util.function.Function;

@Slf4j
/// Всегда возвращает первый входящий параметр как результат
public class FakeCaseRunner<String> implements Function<TestCaseData, TestCaseResponse<String>> {
    @Override
    public TestCaseResponse<String> apply(TestCaseData testCaseData) {
        TestCaseResponse<String> response = new TestCaseResponse<>();

        DbValue resValue = new DbValue();
        if (testCaseData.getParams() == null) {

        }
        resValue.setParamType(testCaseData.getReturningType());


        response.setValue((String) testCaseData.getDescription());
        response.setStatus("Ok");
        response.setMessage(testCaseData.toString());
        log.debug("response [{}]", response.toString());
        return response;
    }
}
