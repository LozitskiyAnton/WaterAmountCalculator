package com.example.demo;

import com.example.demo.service.CalculatorWaterAmount;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        long amount = new CalculatorWaterAmount().calculate(args);
        log.info("Collected {} squares of water", amount);
    }

}
