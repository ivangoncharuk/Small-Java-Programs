package cosc237.assignments.number2;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Ivan Goncharuk
 */
public class Complex
{
    private double realPart;
    private double imaginaryPart;

    public Complex()
    {
        this.realPart = 0;
        this.imaginaryPart = 0;
    }

    public Complex(double realPart, double imaginaryPart)
    {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Determines if all doubles passed in are even. Used for add and subtract to determine whether to use the
     * BigDecimal class for accurate results.
     *
     * @param d a double
     *
     * @return {@code true} if all doubles are even
     */
    private static boolean isEven(double... d)
    {
        for (double i : d)
            if (i % 2 != 0)
                return false;
        return true;
    }

    /**
     * Prompts the user to enter data for a new complex object.<br> If the user does not provide a second value for the
     * imaginary part, it will be initialized to 0.<br> If the user provides an input that can npt be converted to a
     * double, it will initialize the object with (0, 0)
     *
     * @param prompt   Prompts the user for data
     * @param errorMsg Error message to handle exception
     *
     * @return a complex number initialized with user input.
     */
    public static Complex read(String prompt, String errorMsg)
    {
        System.out.print(prompt);
        Scanner  s     = new Scanner(System.in);
        String   input = s.nextLine();
        String[] str;
        str = input.split(" ");
        try {
            if (str.length == 2)
                return new Complex((Double.parseDouble(str[0])), Double.parseDouble(str[1]));
            if (str.length == 1)
                return new Complex(Double.parseDouble(str[0]), 0);
        } catch (NumberFormatException ne) {
            System.out.println(errorMsg);
        }
        return new Complex();
    }

    /**
     * Adds two complex numbers (a, b) where a is the real part, and b is the imaginary part.<br> (a, b) + (c, d) = (a +
     * c, b + d)<br> Note: multiples of 2 do not produce weird results, BigDecimal is not needed.
     *
     * @param o a complex number
     *
     * @return the complex result of adding two complex numbers.
     */
    public Complex add(Complex o)
    {
        if (isEven(this.realPart, this.imaginaryPart, o.realPart, o.imaginaryPart)) {
            BigDecimal realPart      = new BigDecimal(String.valueOf(this.realPart));
            BigDecimal imaginaryPart = new BigDecimal(String.valueOf(this.imaginaryPart));

            realPart = realPart.add(new BigDecimal(String.valueOf(o.realPart)));
            imaginaryPart = imaginaryPart.add(new BigDecimal(String.valueOf(o.imaginaryPart)));
            return new Complex(realPart.doubleValue(),
                    imaginaryPart.doubleValue());
        }
        return new Complex(this.realPart + o.realPart,
                this.imaginaryPart + o.imaginaryPart);
    }

    /**
     * Subtracts two complex numbers (a, b) where a is the real part, and b is the imaginary part.<br> (a, b) - (c, d) =
     * (a - c, b - d) <br> Note: multiples of 2 do not produce weird results, BigDecimal is not needed.
     *
     * @param o a complex number
     *
     * @return the complex result of subtracting two complex numbers
     */
    public Complex subtract(Complex o)
    {
        if (isEven(this.realPart, this.imaginaryPart, o.realPart, o.imaginaryPart)) {
            BigDecimal realPart      = new BigDecimal(String.valueOf(this.realPart));
            BigDecimal imaginaryPart = new BigDecimal(String.valueOf(this.imaginaryPart));

            realPart = realPart.subtract(new BigDecimal(String.valueOf(o.realPart)));
            imaginaryPart = imaginaryPart.subtract(new BigDecimal(String.valueOf(o.imaginaryPart)));
            return new Complex(realPart.doubleValue(), imaginaryPart.doubleValue());
        }
        return new Complex(this.realPart - o.realPart, this.imaginaryPart - o.imaginaryPart);
    }

    /**
     * Multiplies two complex numbers (a, b) where a is the real part, and b is the imaginary part.<br> (a, b) * (c, d)
     * = (a * c - b * d, a * d + b * c)
     *
     * @param o a complex number
     *
     * @return the complex result of multiplying two complex numbers
     */
    public Complex multiply(Complex o)
    {
        return new Complex(this.realPart * o.realPart - this.imaginaryPart * o.imaginaryPart,
                this.realPart * o.imaginaryPart + this.imaginaryPart * o.realPart);
    }

    /**
     * Divides two complex numbers (a, b) where a is the real part, and b is the imaginary part.<br> (a, b) / (c, d) =
     * (a * c + b * d) / (c2 + d2), (b * c - a * d) / (c2 + d2)
     *
     * @param o a complex number
     *
     * @return the complex result of dividing two complex numbers
     */
    public Complex divide(Complex o)
    {
        double numerator1  = this.realPart * o.realPart + this.imaginaryPart * o.imaginaryPart;
        double numerator2  = this.imaginaryPart * o.realPart - this.realPart * o.imaginaryPart;
        double denominator = o.realPart * 2 + o.imaginaryPart * 2;
        return new Complex(numerator1 / denominator, numerator2 / denominator);
    }

    //info

    /**
     * Takes the absolute value of a complex number.<br> Absolute value: |(a, b)| = sqrt(a2 + b2)<br>
     *
     * @return the Complex result of taking the absolute value of a complex number
     */
    public double cAbs()
    {
        return Math.sqrt(this.realPart * 2 + this.imaginaryPart * 2);
    }

    @Override
    public String toString()
    {
        return "(" + realPart + ", " + imaginaryPart + ")";
    }

    /**
     * Method to represent the complex number into the form: a + bi, where a is the real part, and b is the imaginary
     * part, and i = sqrt(-1);
     *
     * @return a String of this complex number in a + bi
     */
    public String toStandard()
    {
        return realPart + (imaginaryPart >= 0 ? " + " + imaginaryPart : " - " + (imaginaryPart * -1)) + "i";
    }

    /**
     * Prints this complex number in the format: (realPart, imaginaryPart)
     */
    public void print()
    {
        System.out.print("(" + realPart + ", " + imaginaryPart + ")");
    }

    /**
     * Copies attributes from another Complex object.
     *
     * @param o another Complex object
     */
    public void copy(Complex o)
    {
        this.realPart = o.realPart;
        this.imaginaryPart = o.imaginaryPart;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        if (Double.compare(complex.realPart, realPart) != 0) return false;
        return Double.compare(complex.imaginaryPart, imaginaryPart) == 0;
    }

    //GET - SET METHODS

    /**
     * Gets a copy of a Complex object
     *
     * @param o a Complex object
     *
     * @return a copy of Complex object
     */
    public Complex getCopy(Complex o)
    {
        return new Complex(o.realPart, o.imaginaryPart);
    }

    public double getRealPart()
    {
        return realPart;
    }

    public double getImaginaryPart()
    {
        return imaginaryPart;
    }
}
