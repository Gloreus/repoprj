package ru.sqbt.plsqltests.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.sqbt.plsqltests.ora.OutputExpectationData;

@Component
@Slf4j
public class EqualValidator implements Validator {
    @Override
    public ValidationType getType() {
        return ValidationType.TO_BE_EQUAL;
    }

    @Override
    public void validate(ExpectationData expectationData, TestResultData testResultData) throws AssertionError {
        log.debug("expectationData: " + expectationData);
        log.debug("testResultData: " + testResultData);

        if (expectationData == null || testResultData == null) {
            throw new IllegalArgumentException("Входные параметры должны быть заданы");
        }
       if (!(expectationData instanceof OutputExpectationData outputExpectationData)) {
           throw new IllegalArgumentException(
                   "Этот валидатор работает только с OutputExpectationData, а получено: "
                           + expectationData.getClass().getName());
       }

       if (!(testResultData.getValue() instanceof DbValue value)) {
           throw new AssertionError("Ответ от сервера должен быть OracleTypes, получен: "
                   + testResultData.getValue());
       }

       if (!(value.getParamType().getJdbcType() == expectationData.getExpectType().getJdbcType())
               || (value.getValue() == outputExpectationData.getExpected())) {
           throw new AssertionError("Ожидалось " + outputExpectationData.getExpected()
                   + " а получено " + value.getValue() + " типа " + value.getParamType());
       }
    }
}
