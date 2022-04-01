package leetcode.hard;

/**
 * 273. Integer to English Words
 * [Hard]
 * <p>
 * Given an integer, return its English word representation.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * <p>
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * <p>
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * <p>
 *
 */
public class IntegerToWords {
    private static final String[] numbers = {
            "", "One ", "Two ", "Three ", "Four ", "Five ",
            "Six ", "Seven ", "Eight ", "Nine ", "Ten ",

            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ",
            "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen ",

            "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ",
            "Seventy ", "Eighty ", "Ninety "
    };

    /**
     * Runtime: 4 ms, faster than 87.69% of Java online submissions for Integer to English Words.
     * Memory Usage: 42.4 MB, less than 70.96% of Java online submissions for Integer to English Words.
     * @param num: a non-negative integer
     * @return: english words representation
     */
    public static String numberToWords(int num) {
        if (num == 0) return "Zero"; // Only case where we have 'zero'

        // Store the digits (except the billions) in an array
        final int[] digits = new int[9];
        int mod = 1_000_000_000;
        for (int i = 0; i < 9; ++i) {
            digits[i] = num % mod / (mod / 10);
            mod /= 10;
        }

        // Construct the string based on each character
        StringBuilder str = new StringBuilder();
        if (num / 1_000_000_000 > 0) str.append(numbers[num / 1_000_000_000]).append("Billion ");

        for (int i = 0; i <= 6; i += 3) {
            if (digits[i] > 0) str.append(numbers[digits[i]]).append("Hundred ");
            if (digits[1 + i] > 1) str.append(numbers[18 + digits[1 + i]]); // Numbers 20 <= n < 100
            if (digits[1 + i] == 1) str.append(numbers[10 + digits[2 + i]]); // Numbers 10 <= n < 20
            if (digits[2 + i] > 0 && digits[1 + i] != 1) str.append(numbers[digits[2 + i]]); // Numbers 0 < n < 10 or n >= 20

            if (i == 0 && num / 1_000_000 % 1_000 > 0) str.append("Million ");
            if (i == 3 && num / 1_000 % 1_000 > 0) str.append("Thousand ");
        }

        // Return the string, excluding the last character if it is whitespace (faster than trim())
        return str.charAt(str.length() - 1) != ' ' ? str.toString() : str.substring(0, str.length() - 1);
    }
}
