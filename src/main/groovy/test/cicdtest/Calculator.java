package test.cicdtest;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public int multiply2(int inputNumber) {
        return inputNumber * 2;
    }

}
