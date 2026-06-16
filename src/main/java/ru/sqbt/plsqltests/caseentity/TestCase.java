package ru.sqbt.plsqltests.caseentity;

import lombok.Data;
import ru.sqbt.plsqltests.caseentity.expect.Expectation;
import ru.sqbt.plsqltests.core.BlockType;
import ru.sqbt.plsqltests.core.DbParam;
import ru.sqbt.plsqltests.core.DbTypes;
import ru.sqbt.plsqltests.core.TransactionMode;

import java.util.List;

@Data
public class TestCase {
    private TestCaseData testCaseData;
    private List<Expectation> expectations;
}
