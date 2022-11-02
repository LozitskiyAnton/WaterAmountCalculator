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
    public long calculate(String[] args) {
        if (args.length == 0) {
            return 0;
        }
        if (((args[0].length())+1)/2 > 32000 ) {
            log.debug("number of positions is = {}", ((args[0].length())+1)/2);
            throw new IllegalArgumentException("Max number of positions is 32000");
        }
        String[] init = args[0].split(",");
        int[] initData = new int[init.length];

        // Parse args to int array
        for (int i = 0; i < init.length; i++) {
            int position = Integer.parseInt(init[i]);
            if (position < MIN_POSITION_HEIGHT || position > MAX_POSITION_HEIGHT) {
                log.debug("Invalid position height = {}", position);
                throw new IllegalArgumentException("Height must be from 0 to 32000");
            }
            initData[i] = position;
        }

        // find height for each position
        int[] leftHeight = new int[init.length];
        leftHeight[0] = initData[0];
        int[] rightHeight = new int[init.length];
        rightHeight[0] = initData[init.length-1];

        for (int i = 1; i < initData.length; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], initData[i]);
            rightHeight[i] = Math.max(rightHeight[i - 1], initData[init.length - 1 - i]);
        }

        // count amount for each position
        int result = 0;
        for (int i = 0; i < init.length; i++) {
            result += Math.min(leftHeight[i], rightHeight[i]) - initData[i];
        }
        return result;
    }
}


