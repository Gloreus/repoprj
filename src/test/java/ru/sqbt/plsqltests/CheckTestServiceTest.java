package ru.sqbt.plsqltests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sqbt.plsqltests.caseentity.TestDataRepository;
import ru.sqbt.plsqltests.caseentity.TestDataYamlRepository;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CheckTestServiceTest {
    @Autowired
    private CheckTestService checkTestService;
    @Autowired
    private TestDataYamlRepository repository;

    @Test
    void checkAllTest() throws FileNotFoundException {
        checkTestService.checkAllTest( repository.loadProfile("123"));
    }
}
