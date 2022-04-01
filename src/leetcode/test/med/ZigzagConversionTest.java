package leetcode.test.med;

import leetcode.med.ZigzagConversion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigzagConversionTest {

    // leetcode.test the convert method in ZigzagConversion
    // using PAYPALISHIRING as the input string, and 3 as the number of rows
    // "PAHNAPLSIIGYIR" should be returned
    @Test
    void convert() {
        assertEquals("PAHNAPLSIIGYIR", ZigzagConversion.convert("PAYPALISHIRING", 3));
    }

    // Input: s = "A", numRows = 1
    //Output: "A"
    @Test
    void convert1() {
        assertEquals("A", ZigzagConversion.convert("A", 1));
    }

    // Input: s = "AB", numRows = 1
    //Output: "AB"
    @Test
    void convert2() {
        assertEquals("AB", ZigzagConversion.convert("AB", 1));
    }

    // Input: s = "PAYPALISHIRING", numRows = 4
    // Output: "PINALSIGYAHRPI"
    @Test
    void convert3() {
        assertEquals("PINALSIGYAHRPI", ZigzagConversion.convert("PAYPALISHIRING", 4));
    }

    // Input: s = "PAYPALISHIRING", numRows = 5
    // Output: "PHASIYIRPLIGAN"
    @Test
    void convert4() {
        assertEquals("PHASIYIRPLIGAN", ZigzagConversion.convert("PAYPALISHIRING", 5));
    }
}