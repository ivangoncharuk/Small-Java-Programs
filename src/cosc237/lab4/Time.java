package cosc237.lab4;

import java.util.Scanner;

import static java.lang.System.out;

public class Time {
    private int m_hrs;
    private int m_mins;
    private int m_secs;

    public Time() {
        m_hrs = 0;
        m_mins = 0;
        m_secs = 0;
    }

    public Time(int h, int m, int s) {
        m_hrs = h;
        m_mins = m;
        m_secs = s;
    }

    // getters and set

    public int getHrs() {
        return m_hrs;
    }

    public int getMins() {
        return m_mins;
    }

    public int getSecs() {
        return m_secs;
    }

    public void set(int h, int m, int s) {
        m_hrs = (h >= 0 && h < 24) ? h : 0;
        m_mins = (m >= 0 && m < 60) ? m : 0;
        m_secs = (s >= 0 && s < 60) ? s : 0;
    }

    // object methods

    /**
     * Creates a copy of a this {@link #Time()} object.
     *
     * @param t a {@link #Time()} object
     */
    public void copy(Time t) {
        set(t.m_hrs, t.m_mins, t.m_secs);
    }

    /**
     * Creates a copy of a this {@link #Time()} object.
     *
     * @return a copy of this {@link #Time()} object
     */
    public Time getCopy() {
        return new Time(m_hrs, m_mins, m_secs);
    }

    /**
     * Increments hours by one.
     * Sets hours to 0 when it reaches 24.
     */
    public void advanceHrs() {
        m_hrs++;
        if (m_hrs > 24)
            m_hrs = 0;
    }

    /**
     * Increments minutes by one.
     * It will set minutes to 0 when it reaches 60 and advances the hours by 1.
     * Sets hours to 0 when it reaches 24.
     */
    public void advanceMins() {
        m_mins++;
        if (m_mins > 59) {
            m_mins = 0;
            advanceHrs();
        }
    }

    /**
     * Increments seconds by one.
     * It will set minutes to 0 when it reaches 60 and advances the minutes by 1.
     * It will set the minutes to 0 when it reaches 60 and advances the hours by 1
     * It will set the hours to 0 when it reaches 24.
     */
    public void advanceSecs() {
        m_secs++;
        if (m_secs > 59) {
            m_secs = 0;
            advanceMins();
        }
    }

    /**
     * Checks for equality for two {@link #Time()} objects. They are equal when the hours, minutes, and seconds
     * are all the same value.
     *
     * @param t THe time object being compared
     * @return {@code true} when this {@link #Time()} object equals t.
     */
    public boolean equals(Time t) {
        return t != null && (
                this.m_hrs == t.m_hrs &&
                this.m_mins == t.m_mins &&
                this.m_secs == t.m_secs
        );
    }

    /**
     * Determines whether two time objects do not equal each other. They are no equal when all member variable of
     * the class are not equal to each other.
     *
     * @param t The time object being compared
     * @return {@code true} if this time object equals another
     */
    public boolean notEquals(Time t) {
        return t != null && !equals(t);
    }

    /**
     * Determines whether this {@link #Time()} object's time value is less than or equals to ( <= ) another time object.
     *
     * @param t The time object being compared
     * @return {@code true} if this time object is less than or equal to another
     */
    public boolean lessOrEquals(Time t) {
        return t != null && (equals(t) || lessThan(t));
    }

    /**
     * Determines whether this {@link #Time()} object's time value is greater than another {@link #Time()} object.
     *
     * @param t The {@link #Time()} object being compared
     * @return {@code true} if this {@link #Time()} object's time value is greater than another {@link #Time()} object.
     */
    public boolean greaterThan(Time t) {
        return t != null && (notEquals(t)) && (
                (m_hrs > t.m_hrs) ||
                (m_hrs == t.m_hrs && m_mins > t.m_mins) ||
                (m_mins == t.m_mins && m_secs > t.m_secs)
        );
    }

    /**
     * Determines whether this {@link #Time()} object's time value is less than another {@link #Time()} object.
     *
     * @param t The {@link #Time()} object being compared
     * @return {@code true} if this {@link #Time()} object's time value is less than another {@link #Time()} object.
     */
    public boolean lessThan(Time t) {
        return t != null && (notEquals(t)) && (
                (m_hrs < t.m_hrs) ||
                (m_hrs == t.m_hrs && m_mins < t.m_mins) ||
                (m_mins == t.m_mins && m_secs < t.m_secs)
        );
    }

    /**
     * Determines whether this {@link #Time()} object's time value is greater than or equals to ( >= ) another {@link #Time()} object.
     *
     * @param t The {@link #Time()} object being compared
     * @return {@code true} if this {@link #Time()} object's time value is greater or equal to than another {@link #Time()} object.
     */
    public boolean greaterOrEquals(Time t) {
        return t != null && (equals(t) || greaterThan(t));
    }

    /**
     * Method to print a {@link #Time()} object in standard format.
     * The time is printed in the form HH:MM:SS AM/PM
     */
    public void printTimeStandard() {
        System.out.print((m_hrs == 0 || m_hrs == 12 ? 12 : m_hrs % 12) + ":");
        System.out.print((m_mins < 10 ? "0" : "") + m_mins + ":");
        System.out.print((m_secs < 10 ? "0" : "") + m_secs);
        System.out.print((m_hrs < 12 ? " AM" : " PM"));
        System.out.println();
    }

    /**
     * Method to print a {@link #Time()} object in military format
     * The time is printed in the form HH:MM:SS
     */
    public void printTimeMilitary() {
        System.out.printf("%02d:%02d:%02d\n", m_hrs, m_mins, m_secs);
    }

    /**
     * Returns this time object's variables in a readable string in H:M:S
     *
     * @return A String that represents the time objects current time.
     */
    public String toString() {
        return m_hrs + ":" + m_mins + ":" + m_secs;
    }

    /**
     * Returns this time object's variables in a readable string in HH:MM:SS AM/PM
     *
     * @return A String that represents the time objects current time in standard form.
     */
    public String toStandard() {
        return (m_hrs == 0 || m_hrs == 12 ? 12 : m_hrs % 12) + ":" +
               (m_mins < 10 ? "0" : "") + m_mins + ":" +
               (m_secs < 10 ? "0" : "") + m_secs +
               (m_hrs < 12 ? " AM" : " PM");
    }

    /**
     * Returns this time object's variables in a readable string in HH:MM:SS
     *
     * @return A String that represents the time objects current time in military form.
     */
    public String toMilitary() {
        return (m_hrs < 10 ? "0" + m_hrs : m_hrs) + ":" +
               (m_mins < 10 ? "0" + m_mins : m_mins) + ":" +
               (m_secs < 10 ? "0" + m_secs : m_secs);
    }

    // Static methods

    /**
     * Method to leetcode.test this time class in a simple menu.
     */
    public static void testTimeClass() {
        int option;
        Time t1 = new Time(8, 15, 30);
        Time t2 = new Time();
        boolean testing = true;
        do {
            menu();
            out.print("\t\t\t ENTER YOUR OPTION: ");
            option = getInt();
            clearScreen();
            switch (option) {
                case 0:
                    testing = false;
                    break;
                case 1:
                    final int hr = 8;
                    final int min = 15;
                    final int sec = 30;
                    printLabel("constructors");
                    out.printf("Time objects t1 and t2 initialized:\n" +
                               "Time t1 = new Time(%d, %d, %d);\n" +
                               "Time t2 = new Time();\n" +
                               "\n", hr, min, sec);
                    if (!t1.equals(new Time(hr, min, sec)))
                        t1.set(hr, min, sec);
                    if (!t2.equals(new Time()))
                        t2.copy(new Time());
                    out.print("Initial time t1 (alternate constructor invoked) - military format: ");
                    t1.printTimeMilitary(); // t1 military
                    out.print("Initial time t1 (alternate constructor invoked) - standard format: ");
                    t1.printTimeStandard(); // t1 standard
                    out.print("Initial time t2 (default constructor invoked) - military format: ");
                    t2.printTimeMilitary(); // t2 military
                    out.print("Initial time t2 (default constructor invoked) - standard format: ");
                    t2.printTimeStandard(); // t2 standard
                    break;
                case 2:
                    printLabel("set()");
                    t2.set(9, 45, 35); //t2 is now 09:54:35
                    out.print("t2 after call to set(9, 45, 35) - military format: ");
                    t2.printTimeMilitary();
                    out.print("t2 after call to set(9, 45, 35) - standard format: ");
                    t2.printTimeStandard();
                    break;
                case 3:
                    printLabel("set() from user");
                    out.println("Enter hrs, mins, and secs for t1");
                    setFromUser(t1);
                    out.print("New time t1 after call to set() - standard format: ");
                    t1.printTimeStandard();
                    out.print("New time t1 after call to set() - military format: ");
                    t1.printTimeMilitary();
                    break;
                case 4:
                    printLabel("copy, getCopy, toString");
                    out.println("Enter hrs, mins, and secs for t1");
                    setFromUser(t1);
                    t2.copy(t1);
                    out.print("New t2 after call to t2.copy(t1) - standard format: ");
                    t2.printTimeStandard();
                    t1.set(11, 22, 33);
                    out.print("New t1 after call to t1.set(11, 22, 33) - standard format: ");
                    t1.printTimeStandard();
                    t2 = t1.getCopy();
                    out.print("New t2 after assignment t2 = getCopy(t1) - standard format: ");
                    t2.printTimeStandard();
                    out.printf("Test toString for t1: %s\n", t1); // t1.toString() is implied
                    out.printf("Test toString for t2: %s\n", t2); // t2.toString() is implied
                    break;
                case 5:
                    printLabel("equals, lessThan");
                    out.println("Enter hrs, mins, and secs for t1");
                    setFromUser(t1);
                    out.print("t1 - military: ");
                    t1.printTimeMilitary();
                    out.println("Enter hrs, mins, and secs for t2");
                    setFromUser(t2);
                    out.print("t2 - military: ");
                    t2.printTimeMilitary();
                    out.printf("After call to equals(): %s",
                            t1.equals(t2) ? "times are equal\n" : "times are NOT equal\n");
                    out.printf("After call to lessThan(): %s",
                            t1.lessThan(t2) ? "t1 is less than t2.\n" : "t1 is NOT less than t2\n");
                    break;
                case 6:
                    printLabel("notEquals, lessOrEquals, greaterThan, and greaterOrEquals.");
                    out.print("t1 - standard format: ");
                    t1.printTimeStandard();
                    t2.copy(t1);
                    out.print("New t2 after call to copy(t1) - standard format: ");
                    t2.printTimeStandard();

                    out.printf("After call to notEquals(): %s",
                            t1.notEquals(t2) ? "t1 != t2\n" : "t1 == t2\n");
                    out.printf("After call to lessOrEquals(): %s",
                            t1.lessOrEquals(t2) ? "t1 <= t2\n" : " ! (t1 <= t2)\n");
                    out.printf("After call to greaterThan(): %s",
                            t1.greaterThan(t2) ? "t1 > t2\n" : " ! (t1 > t2)\n");
                    out.printf("After call to greaterOrEquals(): %s",
                            t1.greaterOrEquals(t2) ? "t1 >= t2\n" : " ! (t1 >= t2)\n");

                    t2.advanceSecs(); // advance t2 by 1s
                    out.println("Enter new time for t2: hours, minutes, and seconds");
                    setFromUser(t2);

                    out.print("New time t2 after call to set() - standard format: ");
                    t2.printTimeStandard();

                    out.printf("After call to notEquals(): %s",
                            t1.notEquals(t2) ? "t1 != t2\n" : "t1 == t2\n");
                    out.printf("After call to lessOrEquals(): %s",
                            t1.lessOrEquals(t2) ? "t1 <= t2\n" : "! (t1 <= t2)\n");
                    out.printf("After call to greaterThan(): %s",
                            t1.greaterThan(t2) ? "t1 > t2\n" : "! (t1 > t2)\n");
                    out.printf("After call to greaterOrEquals(): %s",
                            t1.greaterOrEquals(t2) ? "t1 >= t2\n" : " ! (t1 >= t2)\n");
                    break;
                case 7:
                    printLabel("advanceHrs, advanceMins, advanceSecs");
                    out.println("Enter hours, minutes, and seconds for t1");
                    setFromUser(t1);
                    out.print("t1 - standard format: ");
                    t1.printTimeStandard();
                    out.println("Enter advanceHrs, advanceMins, and advanceSecs: ");
                    out.print("advanceHrs: ");
                    int advanceHrs = getInt();
                    out.print("advanceMins: ");
                    int advanceMins = getInt();
                    out.print("advanceSecs: ");
                    int advanceSecs = getInt();
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
                    break;
                case 8:
                    printLabel("toStandard, toMilitary");
                    out.println("Enter hours, minutes, and seconds for t1");
                    setFromUser(t1);
                    out.printf("Test toStandard for t1: %s\n", t1.toStandard());
                    out.printf("Test toMilitary for t1: %s\n", t1.toMilitary());
                    break;
                default:
                    break;
            }
        } while (testing);
    }

    /**
     * Prints the testing label formatted for each leetcode.test.<br>
     * example call: <br>
     * printLabel(set()) --> System.out.print("\n--- TESTING set() ---\n");
     *
     * @param label The string to be printed
     */
    public static void printLabel(String label) {
        out.printf("\n--- TESTING %s ---\n", label);
    }

    /**
     * Gets an integer input from user. Returns the input if the input is an integer.
     *
     * @return An integer entered by the user.
     */
    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int result;
        String str;
        while (true) {
            str = scanner.next();
            try {
                result = Integer.parseInt(str);
                return result;
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * Clears the console screen. Output is still visible when you scroll up.
     * Does not work inside IDE.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Prints the menu for {@link #testTimeClass()}
     */
    private static void menu() {
        out.println("\n" +
                    "        ~~~~~~~~~~  MENU  ~~~~~~~~~~\n" +
                    "        | 1. Testing constructors\n" +
                    "        | 2. Testing set()\n" +
                    "        | 3. Testing set() from user\n" +
                    "        | 4. Testing copy(), getCopy(), toString()\n" +
                    "        | 5. Testing equals(), lessThan()\n" +
                    "        | 6. Testing notEquals(), lessOrEquals(), greaterThan(), and greaterOrEquals()\n" +
                    "        | 7. Testing advanceHrs(), advanceMins(), and advanceSecs()\n" +
                    "        | 8. Testing toStandard(), toMilitary()\n" +
                    "        | 0. EXIT MENU\n" +
                    "\n");
    }

    /**
     * Sets the time using {@link #getInt()} from user.
     *
     * @param t a {@link #Time()} object
     */
    public static void setFromUser(Time t) {
        out.println("\n\t\tENTER:");
        out.print("\t\tHR  = ");
        int h = getInt();
        out.print("\t\tMIN = ");
        int m = getInt();
        out.print("\t\tSEC = ");
        int s = getInt();
        t.set(h, m, s);
        out.println();
    }

    /**
     * Method to ask yes or no questions to user.
     *
     * @param prompt The prompt shown to user to reply
     * @return {@code true} if the answer is 'y' or 'Y'
     * {@code false} if the answer is any other character
     */
    public static boolean isYes(String prompt) {
        Scanner userInput = new Scanner(System.in);
        out.println(prompt);
        return userInput.next().equalsIgnoreCase("Y");
    }
}