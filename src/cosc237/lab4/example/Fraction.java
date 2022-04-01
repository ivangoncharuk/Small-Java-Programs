package cosc237.lab4.example;

import java.util.Scanner;

public class Fraction
{
    private int m_n; // numerator
    private int m_d; // denominator

    public static void main(String[] args)
    {
        Fraction f = new Fraction(0, 5);
        System.out.println(f.getDecimal());
    }

    public Fraction()
    {
        m_n = 0;
        m_d = 1; //avoid division by 0
    }

    public Fraction(int n, int d)
    {
        setNum(n);
        setDen(d);
    }

    public int getNum()
    {
        return m_n;
    }

    public void setNum(int n)
    {
        m_n = n;
    }

    public int getDen()
    {
        return m_d;
    }

    public void setDen(int d)
    {
        m_d = d != 0 ? d : 1;
    }

    public void set(int n, int d)
    {
        setNum(n);
        setDen(d);
    }


    public Fraction getCopy()
    {
        return new Fraction(this.m_n, this.m_d);
    }

    public void copy(Fraction f)
    {
        this.m_n = f.m_n;
        this.m_d = f.m_d;
    }

    public boolean equals(Fraction f)
    {
        if (f != null)
        {
            return this.m_n == f.m_n &&
                   this.m_d == f.m_d;
        }
        return false;
    }

    public double getDecimal()
    {
        double n = 0;
        if (m_d != 0)
            n = (double) m_n / m_d;
        return n;
    }

    public void print()
    {
        System.out.printf("%d/%d", m_n, m_d);
    }

    public String toString()
    {
        return m_n + " / " + m_d;
    }

    private void getInput()
    {
        System.out.println("Enter your shit");
        System.out.print("m_n: ");
        m_n = getInt();
        System.out.print("d_n: ");
        m_d = getInt();
    }

    private int getInt()
    {
        Scanner s = new Scanner(System.in);
        int result;
        String str;
        while (true)
        {
            str = s.next();
            try
            {
                result = Integer.parseInt(str);
                s.close();
                return result;
            } catch (Exception ignored)
            {
            }
        }
    }
}
