package ru.xaabibas.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.xaabibas.test.services.CalculateService;

@Controller
public class CalculateController {
    @Autowired
    private CalculateService service;

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam double salary,
            @RequestParam int days,
            Model model
    ) {
        String result = service.calculateByDays(salary, days);
        model.addAttribute("days", days);
        model.addAttribute("salary", salary);
        model.addAttribute("result", result);
        return "index";
    }
}
