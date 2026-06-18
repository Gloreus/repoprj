package ru.sqbt.plsqltests;

import lombok.extern.slf4j.Slf4j;
import ru.sqbt.plsqltests.caseentity.TestCaseResponse;
import ru.sqbt.plsqltests.core.TestCaseData;

import java.util.function.Function;

@Slf4j
public class FakeCaseRunner<String> implements Function<TestCaseData, TestCaseResponse<String>> {
    @Override
    public TestCaseResponse<String> apply(TestCaseData testCaseData) {
        TestCaseResponse<String> response = new TestCaseResponse<>();
        response.setValue((String) testCaseData.getDescription());
        response.setStatus("Ok");
        response.setMessage(testCaseData.toString());
        log.debug("response [{}]", response.toString());
        return response;
    }
}
