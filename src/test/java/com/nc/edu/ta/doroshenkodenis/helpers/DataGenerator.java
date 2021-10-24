package com.nc.edu.ta.doroshenkodenis.helpers;

import org.apache.commons.lang.RandomStringUtils;

public class DataGenerator {

    public static String getRandomAlphanumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String getOnlyLetters(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getOnlyDigits(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
}
