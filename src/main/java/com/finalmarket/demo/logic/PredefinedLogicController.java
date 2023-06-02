package com.finalmarket.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredefinedLogicController {
    @Autowired
    private PredefinedLogicService service;

    @GetMapping("/execute")
    void execute(@RequestParam(value = "logic", required = false) PredefinedLogic logic) {
        service.execute(logic);
    }
}