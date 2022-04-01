package cosc237.lab12;

public interface Lab12 {
    /*
Write a program to do the testing for the following methods. Make sure you also have a method to handle input
validation (positive integer, n > 0).
1. A method to find the sum of digits in any integer (iterative method)
2. A method to find the sum of digits in any integer (recursive method)
3. A method to display a number in binary (iterative method)
4. A method to display a number in binary (recursive method)
5. A method to return the string representation of a number in any base (iterative method)
6. A method to return the string representation of a number in any base (recursive method)
 */

    /**
     * Method to find the sum of digits in any integer (iterative method)
     *
     * @param n an integer
     * @return the sum of digits in n
     */
    static int sumOfDigits(int n) {
        int sum = 0;
        int remainder;
        while (n != 0) {
            remainder = n % 10;
            sum += remainder;
            n /= 10;
        }
        return sum;
    }

    /**
     * Method to find the sum of digits in any integer (recursive method)
     *
     * @param n an integer
     * @return the sum of digits in n
     */
    static int sumOfDigitsRecursive(int n) {
        if (n == 0)
            return 0;
        int temp = n % 10;
        return temp + sumOfDigits(n / 10);
    }

    /**
     * Method to display a number in binary (iterative method)
     * @param n a number
     */
    static void displayBinary(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 != 0 ? "1" + str : "0" + str;
            n /= 2;
        }
        System.out.println(str);
    }

    /**
     * Method to display a number in binary (recursive method)
     * @param n a number
     */
    static void displayBinaryRecursive(int n) {
        if (n != 0) {
            displayBinary(n);
            n /= 2;
            System.out.print((n % 2 != 0) ? "1" : "0");
        }
    }

    /**
     * return the string representation of a number in any base (iterative method)
     * @param n any base number
     */
    static void displayAnyBase(int n, int b) {
        String s = "";
        int x = n % b;
        while (n != 0) {
            s = x != 0 ? x + s : 0 + s;
            n /= b;
        }
        System.out.println(s);
    }

    /**
     * return the string representation of a number in any base (recursive method)
     * @param n any base number
     */
    static void displayAnyBaseRecursive(int n, int base) {
        if (n != 0) {
            displayAnyBaseRecursive(n, base);
            n /= base;
            System.out.print((n % base != 0) ?
                    String.format("[%d]", n % base) :
                    "[0]");
        }
    }
}
