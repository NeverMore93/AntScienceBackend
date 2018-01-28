package com.as.backend.antscience.utils;

import java.util.Random;

public class RandomCode {
    public static String generateCode(int bit) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i <bit; i++) {
            result += random.nextInt(10);
        }
        return result;
    }
}
