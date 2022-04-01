package leetcode.test.hard;

import leetcode.hard.IntegerToWords;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerToWordsTest {
    @Test
    void numberToWords() {
        assertEquals("One Hundred Twenty Three",
                IntegerToWords.numberToWords(123));
        assertEquals("Twelve Thousand Three Hundred Forty Five",
                IntegerToWords.numberToWords(12_345));
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
                IntegerToWords.numberToWords(1_234_567));
    }
}