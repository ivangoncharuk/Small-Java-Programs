package cosc237.assignments.number2.tests;

import cosc237.assignments.number2.Complex;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ComplexTest {
    //for annoying floating point arithmetic
    Random rand = new Random();

    @Test
    void multiply() {
        //(a, b) * (c, d) = (a * c - b * d, a * d + b * c)
        double r = rand.nextDouble(), i = rand.nextDouble();
        double r2 = rand.nextDouble(), i2 = rand.nextDouble();
        Complex c1 = new Complex(r, i);
        Complex c2 = new Complex(r2, i2);
        assertEquals(new Complex(r * r2 - i * i2, r * i2 + i * r2), c1.multiply(c2));
    }

    @Test
    void divide() {
        double r1 = rand.nextDouble(), i1 = rand.nextDouble();
        double r2 = rand.nextDouble(), i2 = rand.nextDouble();

        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);
        double numerator1 = r1 * r2 + i1 * i2;
        double numerator2 = i1 * r2 - r1 * i2;
        double denominator = r2 * 2 + i2 * 2;
        assertEquals(new Complex(numerator1 / denominator, numerator2 / denominator), c1.divide(c2));
    }

    @Test
    void cAbs() {
        double r = rand.nextDouble(), i = rand.nextDouble();
        assertEquals(Math.sqrt(r * 2 + i * 2), new Complex(r, i).cAbs());
    }

    @SuppressWarnings("SimplifiableAssertion")
    @Test
    void testEquals() {
        Random rand = new Random();
        double r = rand.nextDouble();
        double i = rand.nextDouble();
        Complex c1 = new Complex(r, i);
        Complex c2 = new Complex(r, i);
        assertTrue(c1.equals(c2));
    }
}