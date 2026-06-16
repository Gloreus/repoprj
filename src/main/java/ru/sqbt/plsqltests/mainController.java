package ru.sqbt.plsqltests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/")
public class mainController {

    private final TestDataService testDataService;

    public mainController(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    @GetMapping("/")
    List<String> list() {
        return testDataService.getList();
    }

}

