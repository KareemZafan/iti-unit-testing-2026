package org.iti.tests;

import org.iti.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTests {

    private static StringUtils stringUtils;

    @BeforeAll
    static void setUp() {
        stringUtils = new StringUtils();
    }

    @Tag("FEB_RELEASE")
    @ParameterizedTest
    @ValueSource(strings = {"level","madam","rotor","refer","racecar"})
    void testIsPalindromeStringTruthyPath(String input) {
        assertTrue(stringUtils.isPalindromeString(input));
    }

    @Tag("FEB_RELEASE")
    @ParameterizedTest
    @ValueSource(strings = {"leve", "adam", "roto", "ref", "car"})
    void testIsPalindromeStringFalsyPath(String input) {
        assertFalse(stringUtils.isPalindromeString(input));
    }
}
