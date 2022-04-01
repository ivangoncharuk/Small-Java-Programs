package leetcode.med;

/**
 * 12. Integer to Roman
 * [MEDIUM]
 * Given an integer, convert it to a roman numeral.
 */
public class IntegerToRoman {

    /**
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Integer to Roman. <br>
     * Memory Usage: 41.5 MB, less than 97.38% of Java online submissions for Integer to Roman. <br>
     * @param num the number to convert
     * @return the roman numeral
     */
    public static String intToRoman(int num) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                sb.append(roman[i]);
                num -= value[i];
            }
        }
        return sb.toString();
    }
}
