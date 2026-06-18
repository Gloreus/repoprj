package ru.sqbt.plsqltests.ora;

import lombok.Data;
import ru.sqbt.plsqltests.core.DbTypes;
import ru.sqbt.plsqltests.core.DbValue;
import ru.sqbt.plsqltests.core.ExpectationData;
import ru.sqbt.plsqltests.core.ValidationType;

@Data
public class OutputExpectationData implements ExpectationData {
    private DbTypes expectType;
    private ValidationType validationType;
    private Object expected;
    private Object expected2;
}
