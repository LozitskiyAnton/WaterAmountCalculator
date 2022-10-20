package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorWaterAmountTest {

    @Autowired CalculatorWaterAmount calculatorWaterAmount;

    @Test
    void calculateWithEmptyArgsTest() {
        Assertions.assertEquals(0, calculatorWaterAmount.calculate(new String[0]));
    }

    @Test
    void calculateWithSingleElementArgsTest() {
        Assertions.assertEquals(0, calculatorWaterAmount.calculate(new String[] {"1"}));
    }


    @Test
    void calculateWithValidArgsFromTaskTest() {
        Assertions.assertEquals(9, calculatorWaterAmount.calculate(new String[] {"5,2,3,4,5,4,0,3,1"}));
    }

    @Test
    void calculateWithFlatArgsTest() {
        Assertions.assertEquals(0, calculatorWaterAmount.calculate(new String[] {"5,5,5,5,5"}));
    }


    @Test
    void calculateWithZeroArgsTest() {
        Assertions.assertEquals(0, calculatorWaterAmount.calculate(new String[] {"0,0,0,0,0"}));
    }

    @Test
    void calculateWithIncreasingArgsTest() {
        Assertions.assertEquals(0, calculatorWaterAmount.calculate(new String[] {"0,1,2,3,4"}));
    }

    @Test
    void calculateWithDecreasingArgsTest() {
        Assertions.assertEquals(0, calculatorWaterAmount.calculate(new String[] {"4,3,2,1"}));
    }

    @Test
    void calculateWithNegativeArgsTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorWaterAmount.calculate(new String[] {"4,3,-2,1"}));
    }

    @Test
    void calculateWithTooBigArgsTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorWaterAmount.calculate(new String[] {"4,3,32001,1"}));
    }
}