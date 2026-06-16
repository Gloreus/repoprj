package ru.sqbt.plsqltests.caseentity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class TestDataYamlRepositoryTest{
    @Autowired
    private TestDataYamlRepository repository;

    @Test
    void testLoadProfile() throws FileNotFoundException {
        assertThrowsExactly(FileNotFoundException.class,
                () -> repository.loadProfile("1233333"));
        TestProfile profile = repository.loadProfile("123");
        System.out.println(profile);
        assertNotNull(profile);
    }

    @Test
    void testLoadCases() throws FileNotFoundException {
        TestProfile profile = repository.loadProfile("123");
        List<TestCase> caseList = repository.loadCases(profile);
        assertNotNull(caseList);
    }

    @Test
    void getFileName() {
        assertEquals(repository.getFileName("123"), "123.yaml");
        assertEquals(repository.getFileName("123.yaML"), "123.yaML");
        assertEquals(repository.getFileName("2/1.2.123.yaML"), "2/1.2.123.yaML");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> repository.getFileName("1.txt"));
    }
}