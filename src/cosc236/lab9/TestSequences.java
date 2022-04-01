package cosc236.lab9;

public class TestSequences {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(sequence(i) + "   ");  // 2, 4, 6, 12, 22, 40, 74, 136, 250, 460
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(sequence2(i) + "   "); // 1, 2, 4, 5, 7, 8, 10, 11, 13, 14
        }
    }

    /**
     * Where S is defined by the recursive formula:
     *  For n >= 0
     *  Base case 1 S(0) = 2;
     *  Base case 1 S(1) = 4;
     *  Base case 2 S(2) = 6;
     *  Function S(N) = 2 * (  S(N-1)/2 + S(N-2)/2 + S(N-3)/2)
     *
     * @param n the nth term in the sequence
     * @return the nth term in the sequence
     */
    public static int sequence(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 4;
        } else if (n == 2) {
            return 6;
        } else {
            return (sequence((n - 1)) + sequence(n - 2) + sequence(n - 3));
        }
    }

    /**
     * S2(n) = 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, …
     * @param n nth term in sequence
     * @return the nth term in the sequence
     */
    public static int sequence2(int n) {
        if(n == 0)
            return 1;
        else {
            if(n % 2 == 0)
                return sequence2(n - 1) + 2;
            else
                return sequence2(n - 1) + 1;
        }
    }
} // end of TestSequences class
