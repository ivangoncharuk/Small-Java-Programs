package leetcode.med;


/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * <pre>
 *     P   A   H   N
 *     A P L S I I G
 *     Y   I   R
 * </pre>
 * And then read line by line: And then read line by line: <code>"PAHNAPLSIIGYIR"</code><br>
 *
 * Write the code that will take a string and make this conversion given a number of rows: <br>
 * <code>string convert(string s, int numRows);</code>
 *
 *
 */
public class ZigzagConversion {
    /**
     * Runtime: 5 ms, faster than 87.44% of Java online submissions for Zigzag Conversion. <br>
     * Memory Usage: 44.7 MB, less than 80.13% of Java online submissions for Zigzag Conversion. <br>
     *
     * @param s the string to convert
     * @param numRows the number of rows
     * @return the converted string
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return sb.toString();
    }
}
