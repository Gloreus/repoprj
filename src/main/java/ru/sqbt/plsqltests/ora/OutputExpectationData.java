package ru.sqbt.plsqltests.ora;

import lombok.AllArgsConstructor;
import lombok.Data;

import ru.sqbt.plsqltests.core.DbTypes;
import ru.sqbt.plsqltests.core.ExpectationData;
import ru.sqbt.plsqltests.core.ValidationType;

@Data
@AllArgsConstructor
public class OutputExpectationData implements ExpectationData {
    private DbTypes expectType;
    private ValidationType validationType;
    private Object expected;
    private Object expected2;

    OutputExpectationData() {
        expectType = null;
        validationType = ValidationType.TO_BE_EQUAL;
        expected = null;
        expected2 = null;
    }
}
