package cosc237.assignments.number2;

import java.util.Random;

public class Matrix {

    public final int MAX = 20;
    private final int defaultValueMax = 5;
    private final int defaultValueMin = 1;
    private int size;
    private int[][] table = new int[MAX][MAX];

    // Default Constructor
    public Matrix() {
        this.size = 3;
        init(defaultValueMin, defaultValueMax);
    }

    // Alternate Constructor with 0 values
    public Matrix(int size) {
        this.size = size;
        init(defaultValueMin, defaultValueMax);
    }

    // Alternate Constructor with random values
    public Matrix(int size, int valueMin, int valueMax) {
        this.size = size;
        init(valueMin, valueMax);
    }

    // Copy Constructor
    public Matrix(Matrix m) {
        this.size = m.size;
        // Copy elements of table
        this.table = m.table;
    }

    public int getSize() {
        return size;
    }

    public int getElement(int r, int c) {
        return table[r][c];
    }

    public void setElement(int r, int c, int value) {
        table[r][c] = Math.max(value, 0);
    }

    public void init(int low, int high) {
        Random r = new Random();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                table[i][j] = r.nextInt(((high - low) + 1) + low);
            }
        }
    }

    public void print() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.printf("%6d", table[r][c]);
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix a) {
        Matrix result = new Matrix(size);
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                result.table[i][j] = this.table[i][j] + a.table[i][j];
        return result;
    }

    public Matrix subtract(Matrix a) {
        Matrix result = new Matrix(size);
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                result.table[i][j] = this.table[i][j] - a.table[i][j];
        return result;
    }

    public Matrix multiply(Matrix a) {
        Matrix result = new Matrix(size);
        for (int r = 0; r < size; r++)
            for (int c = 0; c < size; c++) {
                int cell = 0;
                for (int i = 0; i < size; i++) 
                    cell += table[r][i] * a.table[i][c];
                result.table[r][c] = cell;
            }
        return result;
    }

    public Matrix multiplyConst(int num) {
        Matrix result = new Matrix(size);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                result.table[r][c] = this.table[r][c] * num;
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(size);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                result.table[r][c] = this.table[c][r];
            }
        }
        return result;
    }

    public int trace() {
        if (this.table != null) {
            int result = this.table[0][0];
            for (int i = 1; i < size; i++)
                result += this.table[i][i];
            return result;
        }
        return 0;
    }
    
    public void copy(Matrix a) {
        this.size = a.size;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                this.table[r][c] = a.table[r][c];
            }
        }
    }

    public Matrix getCopy() {
        return new Matrix(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;
        //todo equality for table!
        return true;
    }
    

    @Override
    public int hashCode() {
        return 0;
    }
}
