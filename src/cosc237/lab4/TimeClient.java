package cosc237.lab4;
import static cosc237.lab4.Time.printLabel;
import static java.lang.System.exit;
import static java.lang.System.out;


public class TimeClient {
    public static void main(String[] args) {
        Time t1 = new Time(8, 15, 30);
        Time t2 = new Time();
        Time.clearScreen();
        out.println("I created a method that lets you leetcode.test Time with\n" +
                    "input provided by the user and included a\n" +
                    "working menu.\n");

        if (Time.isYes("Run driver method?\n" +
                  "Y - Run driver method first for tests\n" +
                  "N - Run the original leetcode.test\n")) {
            Time.clearScreen();
            Time.testTimeClass(); //another testing program similar to this one, but loops
            if (Time.isYes("Exit program?\n" +
                      "Y - Finish processing with exit code 0\n" +
                      "N - Continue with original leetcode.test\n")) {
                Time.clearScreen();
                exit(0);
            } else {
                Time.clearScreen();
                out.println("###################################\n" +
                            "#     ORIGINAL CLIENT TESTING     #\n" +
                            "###################################\n");
            }
        }

        printLabel("constructors");
        out.print("Initial time t1 (alternate constructor invoked) - military format: ");
        t1.printTimeMilitary(); // t1 military
        out.print("Initial time t1 (alternate constructor invoked) - standard format: ");
        t1.printTimeStandard(); // t1 standard
        out.print("Initial time t2 (default constructor invoked) - military format: ");
        t2.printTimeMilitary(); // t2 military
        out.print("Initial time t2 (default constructor invoked) - standard format: ");
        t2.printTimeStandard(); // t2 standard

        printLabel("t2.set()");
        t2.set(9, 45, 35); //t2 is now 09:54:35
        out.print("t2 after call to set() - military format: ");
        t2.printTimeMilitary();
        out.print("t2 after call to set() - standard format: ");
        t2.printTimeStandard();

        printLabel("equals, lessThan");
        out.print("t1: ");
        t1.printTimeMilitary();
        out.print("t2: ");
        t2.printTimeMilitary();
        out.printf("After call to equals(): %s",
                t1.equals(t2) ? "times are equal\n" : "times are NOT equal\n");
        out.printf("After call to lessThan(): %s",
                t1.lessThan(t2) ? "t1 is less than t2.\n" : "t1 is NOT less than t2\n");

        printLabel("set() from user");
        out.print("Enter hours, mins, and seconds: ");
        t1.set(Time.getInt(), Time.getInt(), Time.getInt()); //get input from user
        out.print("New time t1 after call to set() - standard format: ");
        t1.printTimeStandard();

        printLabel("advanceSecs");
        t1.advanceSecs(); // advance t1 by 1s
        out.print("New time t1 after call to advanceSecs() - standard format: ");
        t1.printTimeStandard(); //t1 standard

        printLabel("copy, toString");
        t2.copy(t1);
        out.print("New t2 after call to copy(t1) - standard format: ");
        t2.printTimeStandard();
        out.printf("Test toString for t2: %s\n", t2);

        out.println("\n--- TESTING notEquals, lessOrEquals, greaterThan, and greaterOrEquals. ---\n");
        out.print("t1 - standard format: ");
        t1.printTimeStandard();
        t2.copy(t1);
        out.print("New t2 after call to copy(t1) - standard format: ");
        t2.printTimeStandard();

        out.printf("After call to notEquals(): %s", t1.notEquals(t2) ? "t1 != t2\n" : " ! (t1 != t2)\n");
        out.printf("After call to lessOrEquals(): %s", t1.lessOrEquals(t2) ? "t1 <= t2\n" : " ! (t1 <= t2)\n");
        out.printf("After call to greaterThan(): %s", t1.greaterThan(t2) ? "t1 > t2\n" : " ! (t1 > t2)\n");
        out.printf("After call to greaterOrEquals(): %s", t1.greaterOrEquals(t2) ? "t1 >= t2\n" : " ! (t1 >= t2)\n");

        t2.advanceSecs(); // advance t2 by 1s
        out.print("New time t2 after call to advanceSecs() - standard format: ");
        t2.printTimeStandard();

        out.printf("After call to notEquals(): %s", t1.notEquals(t2) ? "t1 != t2\n" : " ! (t1 != t2)\n");
        out.printf("After call to lessOrEquals(): %s", t1.lessOrEquals(t2) ? "t1 <= t2\n" : " ! (t1 <= t2)\n");
        out.printf("After call to greaterThan(): %s", t1.greaterThan(t2) ? "t1 > t2\n" : " ! (t1 > t2)\n");
        out.printf("After call to greaterOrEquals(): %s", t1.greaterOrEquals(t2) ? "t1 >= t2\n" : " ! (t1 >= t2)\n");

        printLabel("advanceHrs, advanceMins, advanceSecs");
        out.print("t1 - standard format: ");
        t1.printTimeStandard();
        out.print("Enter advanceHrs, advanceMins, and advanceSecs: ");

        int advanceHrs = Time.getInt();
        int advanceMins = Time.getInt();
        int advanceSecs = Time.getInt();
        t2.copy(t1);
        out.println("\nAdvance Hours:");
        for (int i = 0; i < advanceHrs; i++)
            t1.advanceHrs();
        out.printf("t1 after %d call%s to advanceHrs() - standard format: ",
                advanceHrs, advanceHrs > 1 ? "s" : "");
        t1.printTimeStandard();

        out.println("\nAdvance Minutes:");
        for (int i = 0; i < advanceMins; i++)
            t1.advanceMins();
        out.printf("t1 after %d call%s to advanceMins() - standard format: ",
                advanceMins, advanceMins > 1 ? "s" : "");
        t1.printTimeStandard();

        out.println("\nAdvance Seconds:");
        for (int i = 0; i < advanceSecs; i++)
            t1.advanceSecs();
        out.printf("t1 after %d call%s to advanceSecs() - standard format: ",
                advanceSecs, advanceSecs > 1 ? "s" : "");
        t1.printTimeStandard();

        printLabel("toStandard, toMilitary");
        out.printf("Test toStandard for t1: %s\n", t1.toStandard());
        out.printf("Test toMilitary for t1: %s\n", t1.toMilitary());

        out.println("\n\n#### TESTING COMPLETED ####");
    }
}
