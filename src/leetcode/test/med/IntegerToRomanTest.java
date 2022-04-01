package leetcode.test.med;

import leetcode.med.IntegerToRoman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerToRomanTest {

    @Test
    void intToRoman() {
        Assertions.assertEquals("III", IntegerToRoman.intToRoman(3));
        assertEquals("IV", IntegerToRoman.intToRoman(4));
        assertEquals("IX", IntegerToRoman.intToRoman(9));
        assertEquals("LVIII", IntegerToRoman.intToRoman(58));
        assertEquals("MCMXCIV", IntegerToRoman.intToRoman(1994));
    }

    // leetcode.test 0
    @Test
    void intToRoman_0() {
        Assertions.assertEquals("", IntegerToRoman.intToRoman(0));
    }

    // leetcode.test negative
    @Test
    void intToRoman_negative() {
        Assertions.assertEquals("", IntegerToRoman.intToRoman(-1));
    }
}