package com.example.scheduler.utils;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public static List<Integer> getRandomNumbers(int end) {
        List<Integer> resultRandomNumbers = new ArrayList<>();
        for (int i = 0; i < end; i++) {
            int randomNumber = (int) (Math.random() * end);
            for (Integer number : resultRandomNumbers) {
                if (number == randomNumber) {
                    i -= 1;
                    break;
                }
            }
            if (resultRandomNumbers.contains(randomNumber)) {
                resultRandomNumbers.add(randomNumber);
                continue;
            }
            i -= 1;
        }
        return resultRandomNumbers;
    }
}
