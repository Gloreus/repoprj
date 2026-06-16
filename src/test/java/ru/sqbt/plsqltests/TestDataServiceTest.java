package ru.sqbt.plsqltests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestDataServiceTest {

    @Autowired
    private TestDataService testDataService;

    @Test
    void getList() {
        List<String> result = testDataService.getList();

        assertNotNull(result);
        assertEquals(3, result.size());
    }
}