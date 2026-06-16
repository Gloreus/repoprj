package ru.sqbt.plsqltests.caseentity;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestProfile {
    private String profileName = "";
    private String description = "";
    private final List<TestCaseReference> references = new ArrayList<>(1);
}
