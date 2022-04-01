package cosc237.lab6;

import java.util.Objects;

public class Employee extends Person {
    public final int HOURS = 40;
    public final double OVERTIME = 1.5;
    private double payRate;
    private double hoursWorked;
    private String department;

    //default constructor
    public Employee() {
        super();
        payRate = 0;
        hoursWorked = 0;
        department = "";
    }

    public Employee(String first, String last, double rate, double hours, String dep) {
        super(first, last);
        payRate = rate;
        hoursWorked = hours;
        department = dep;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public String getDepartment() {
        return department;
    }

    public void print() {
        System.out.printf("The employee %s %s from the %s department worked %.1f hours with a pay rate of $%.2f." +
                          " The wages for %s %s are $%.2f\n",
                firstName, lastName, department, hoursWorked, payRate,
                firstName, lastName, calculatePay());
    }

    @Override
    public String toString() {
        return String.format("The wages for %s from the %s department are: $%.2f",
                super.toString(), department, calculatePay());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(payRate, employee.getPayRate()) == 0 &&
               Double.compare(hoursWorked, employee.getHoursWorked()) == 0 &&
               department.equals(employee.getDepartment());
    }

    public Employee getCopy() {
        return new Employee(firstName, lastName, payRate, hoursWorked, department);
    }

    public void copy(Employee e) {
        if (e != null) {
            firstName = e.firstName;
            lastName = e.lastName;
            payRate = e.payRate;
            hoursWorked = e.hoursWorked;
            department = e.department;
        }
    }

    public double calculatePay() {
        //HOURS = 40 (anything over is overtime)
        if (hoursWorked > HOURS)
            return payRate * HOURS + ((hoursWorked - HOURS) * payRate * OVERTIME);
        else
            return payRate * hoursWorked;
    }

    public void setAll(String first, String last, double rate, double hours, String dep) {
        firstName = first;
        lastName = last;
        payRate = rate;
        hoursWorked = hours;
        department = dep;
    }
}