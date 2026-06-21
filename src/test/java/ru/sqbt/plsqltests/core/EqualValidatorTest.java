package ru.sqbt.plsqltests.core;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sqbt.plsqltests.ora.OracleTypes;
import ru.sqbt.plsqltests.ora.OutputExpectationData;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EqualValidatorTest extends EqualValidator {

    @Test
    void getTypeTest() {
        assertEquals(ValidationType.TO_BE_EQUAL, getType());
    }

    @Test
    void validateTest() {
        TestResultData td = new TestResultData();
        td.setErrorCode("200 Ok");
        DbValue resValue = new DbValue();
        resValue.setParamType(OracleTypes.VARCHAR2);
        resValue.setValue("1024");
        td.setValue(resValue);

        OutputExpectationData ed = new OutputExpectationData();
        ed.setValidationType(ValidationType.TO_BE_EQUAL);
        ed.setExpectType(OracleTypes.VARCHAR2);
        ed.setExpected("1024");

        assertDoesNotThrow(() ->  validate(ed, td));

        ed.setExpectType(OracleTypes.BLOB);
        assertThrows(AssertionError.class, ()-> validate(ed, td));
    }
}