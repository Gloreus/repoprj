package ru.sqbt.plsqltests;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TestDataService {

    public List<String> getList() {
        return Arrays.asList("1", "2", "testString");
    }
}
