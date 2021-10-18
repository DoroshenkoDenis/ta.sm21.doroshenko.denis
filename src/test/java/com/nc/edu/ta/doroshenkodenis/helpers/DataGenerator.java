package com.nc.edu.ta.doroshenkodenis.helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Locale;

public class DataGenerator {


//    used in previous project / will be deleted

    public static String getRandomPassword(int length) {
        return RandomStringUtils.randomAscii(length - 4) + RandomStringUtils.randomNumeric(1) + "&Ps";
    }

    public static String getRandomPasswordWithoutDigits(int length) {
        return RandomStringUtils.randomAlphabetic(length - 3) + "&Ps";
    }

    public static String getRandomPasswordWithoutUppercase(int length) {
        return RandomStringUtils.randomNumeric(length - 2) + "a&";
    }

    public static String getRandomPasswordWithoutLowercase(int length) {
        return RandomStringUtils.randomNumeric(length - 2) + "A&";
    }

    public static String getRandomPasswordWithoutAlphabet(int length) {
        return RandomStringUtils.randomNumeric(length - 1) + "&";
    }

    public static String getRandomPasswordWithoutSymbols(int length) {
        return RandomStringUtils.randomNumeric(length - 2) + "aA";
    }

    public static String getUserRandomName(int length) {
        return RandomStringUtils.randomAlphabetic(length - 2) + "00";
    }





    public static String getRuUserRandomName() {
        Faker faker = new Faker(Locale.forLanguageTag("ru"));
        return faker.name().lastName();
    }
//    -----------------------------------------------
//    using in this project

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
