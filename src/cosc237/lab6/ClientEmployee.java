package cosc237.lab6;

import cosc237.lab6.Employee;

import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.*;

public class ClientEmployee {
    public static void main(String[] arg) {
        Scanner input = new Scanner(in);
        final String invalidInput = "Not a valid input, try again";
        String last, first, dept;
        double pay_rate;
        int hours;
        Employee prof = new Employee("John", "Doe", 25.50, 50, "COSC");
        Employee newEmp = new Employee();
        out.print("Enter employee last name: ");
        last = input.next();
        out.print("Enter employee first name: ");
        first = input.next();
        out.print("Enter department: ");
        dept = input.next();
        pay_rate = getInput(input, "Enter employee pay rate: ", invalidInput, Double::parseDouble);
        hours = getInput(input, "Enter employee hours worked: ", invalidInput, Integer::parseInt);
        newEmp.setAll(first, last, pay_rate, hours, dept);
        out.println("--- Record for both employees with overridden .toString from subclass --- ");
        out.println(prof);
        out.println(newEmp);
        out.println("--- Output with calls to overridden method print from subclass --- ");
        prof.print();
        newEmp.print();
        out.println("--- Output with calls to getters from the superclass ---");
        out.printf("The wages for %s %s from the %s department are $%.2f\n",
                newEmp.getFirstName(), newEmp.getLastName(), newEmp.getDepartment(), newEmp.calculatePay());
        out.println("--- Call to overridden equals/subclass for 2 Employee objects---");
        out.printf("%s an employee with same record.", prof.equals(newEmp) ? "Found" : "Couldn't find");
        prof.copy(newEmp);
        out.println("\nCalled prof.copy(newEmp);");
        out.printf("%s an employee with same record.", prof.equals(newEmp) ? "Found" : "Couldn't find");

    }

    //example call -> int hours = getInput(input, "Enter employee hours worked: ", invalidInput, Integer::parseInt);
    public static <T> T getInput(Scanner scan, String prompt, String errMsg, Function<String, T> parse) {
        String str;
        while (true) {
            out.print(prompt);
            str = scan.next();
            try {
                return parse.apply(str);
            } catch (Exception e) {
                out.print(errMsg);
            }
        }
    }
}

