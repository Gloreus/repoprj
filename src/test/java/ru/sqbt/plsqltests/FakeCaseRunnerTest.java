package ru.sqbt.plsqltests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sqbt.plsqltests.caseentity.TestCase;
import ru.sqbt.plsqltests.caseentity.TestCaseData;
import ru.sqbt.plsqltests.core.BlockType;
import ru.sqbt.plsqltests.ora.OracleTypes;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FakeCaseRunnerTest extends FakeCaseRunner {

    @Test
    void apply() {
        TestCaseData testCase = new TestCaseData();
        testCase.setDescription("test case 1");
        testCase.setBlockSql("1111");
        testCase.setBlockType(BlockType.BLOCK);
        testCase.setReturningType(OracleTypes.NUMBER);
        assertEquals(apply(testCase).getStatus(), "Ok");
    }
}