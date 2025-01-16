package test.cicdtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.cicdtest.Calculator;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class TestController {

    private final Calculator calculator;

    @GetMapping("/health")
    public String health() {
        return "call health";
    }

    @PostMapping("/{number}")
    public String getInfo(@PathVariable String number) {
        int parsedInt = parseInt(number);
        return String.valueOf(calculator.multiply2(parsedInt));
    }

    private int parseInt(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("wrong input");
        }
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
