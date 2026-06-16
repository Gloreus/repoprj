package ru.sqbt.plsqltests;

import lombok.extern.slf4j.Slf4j;
import ru.sqbt.plsqltests.caseentity.CaseResponse;
import ru.sqbt.plsqltests.caseentity.TestCase;
import ru.sqbt.plsqltests.caseentity.TestCaseData;

import java.util.function.Function;

@Slf4j
public class FakeCaseRunner<String> implements Function<TestCaseData, CaseResponse<String>> {
    @Override
    public CaseResponse<String> apply(TestCaseData testCaseData) {
        CaseResponse<String> response = new CaseResponse<>();
        response.setValue((String) testCaseData.getDescription());
        response.setStatus("Ok");
        response.setMessage(testCaseData.toString());
        log.debug("response [{}]", response.toString());
        return response;
    }
}
