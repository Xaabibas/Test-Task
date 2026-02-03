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

    @GetMapping(value = "/calculate", params = {"salary", "days"})
    public String calculate(
            @RequestParam double salary,
            @RequestParam long days,
            Model model
    ) {
        String result = service.calculateByDays(salary, days);
        model.addAttribute("days", days);
        model.addAttribute("salary", salary);
        model.addAttribute("result", result);
        return "days";
    }

    @GetMapping(value = "/calculate", params = {"salary", "start", "end"})
    public String calculate(
            @RequestParam double salary,
            @RequestParam String start,
            @RequestParam String end,
            Model model
    ) {
        String result = service.calculateByDates(salary, start, end);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        model.addAttribute("salary", salary);
        model.addAttribute("result", result);
        return "dates";
    }
}
