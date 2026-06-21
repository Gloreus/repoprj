package ru.sqbt.plsqltests;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sqbt.plsqltests.caseentity.*;
import ru.sqbt.plsqltests.core.*;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CheckTestService {
    private final ValidatorFactory validatorFactory;
    private final TestDataRepository testDataRepository;
    private FakeCaseRunner<DbTypes> runner = new FakeCaseRunner<>();

    public void checkAllTest(TestProfile profile) {
        List<TestCase> cases =  testDataRepository.loadCases(profile);
        log.debug(cases.toString());
        cases.forEach(testCase -> checkCase(testCase));
    }

    public void checkCase(TestCase testCase) {
        if (testCase.getExpectations().isEmpty()) {
            log.error("Для " + testCase.getTestCaseData().getDescription() + " не заданы ожидания");
            return;
        }
        ExpectationData expectationData = testCase.getExpectations().getFirst();
        TestCaseData testCaseData = testCase.getTestCaseData();
        log.debug(expectationData.toString());
        log.debug(testCaseData.toString());

        Validator validator = validatorFactory.getValidator(expectationData.getValidationType());
        log.debug(validator.toString());
        TestCaseResponse<DbTypes> response = runner.apply(testCaseData);
        TestResultData resultData = new TestResultData();
        response.setStatus("200 Ok");
        response.setValue(response.getValue());
        validator.validate(expectationData, resultData);
    }
}
