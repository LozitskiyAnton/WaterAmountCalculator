package com.example.demo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CalculatorWaterAmount {

    public static final int MIN_POSITION_HEIGHT = 0;
    public static final int MAX_POSITION_HEIGHT = 32000;

    /**
     * Calculate water amount.
     *
     * @param args initial data from program arguments
     * @return water amount
     */
    public int calculate(String[] args) {
        if (args.length == 0) {
            return 0;
        }
        List<Integer> initData = new ArrayList<>();
        // Parse args to int list
        for (String height : args[0].split(",")) {
            int position = Integer.parseInt(height);
            if (position < MIN_POSITION_HEIGHT || position > MAX_POSITION_HEIGHT) {
                log.debug("Invalid position height = {}", position);
                throw new IllegalArgumentException("Height must be from 0 to 32000");
            }
            initData.add(position);
        }

        int initSize = initData.size();
        // find height for each position
        List<Integer> leftHeight = new ArrayList<>();
        leftHeight.add(initData.get(0));
        List<Integer> rightHeight = new ArrayList<>();
        rightHeight.add(initData.get(initSize - 1));

        for (int i = 1; i < initData.size(); i++) {
            if (leftHeight.get(i - 1) < initData.get(i)) {
                leftHeight.add(i, initData.get(i));
            } else {
                leftHeight.add(i, leftHeight.get(i - 1));
            }
            if (rightHeight.get(i - 1) < initData.get(initSize - 1 - i)) {
                rightHeight.add(i, initData.get(initSize - 1 - i));
            } else {
                rightHeight.add(i, rightHeight.get(i - 1));
            }
        }
        // count amount for each position
        int result = 0;
        for (int i = 0; i < initSize; i++) {
            result += leftHeight.get(i) > rightHeight.get(i)
                    ? rightHeight.get(i) - initData.get(i)
                    : leftHeight.get(i) - initData.get(i);
        }
        return result;
    }
}


