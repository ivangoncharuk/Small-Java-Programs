package cosc237.lab6.exercise;

public class ExerciseClient {
    public static void main(String[] args) {
        String divider ="-".repeat(70);

        //class1
        System.out.println(divider);
        Class_1 class1 = new Class_1();
        System.out.print("class1.print after invoking default constructor: ");
        class1.print();
        class1 = new Class_1(10, 20);
        System.out.print("\nclass1.print after invoking alternate constructor (10, 20): ");
        class1.print();
        class1.set(20, 30);
        System.out.print("\nclass1.print() after call to set (20, 30): ");
        class1.print();
        System.out.print("\nclass1.toString(): " + class1);
        System.out.println("\n" + divider);
        //end of class 1 testing

        // class2
        Class_2 class2 = new Class_2();
        System.out.print("class2.print after invoking default constructor: ");
        class2.print();
        class2 = new Class_2(10, 20, 30);
        System.out.print("\nclass2.print after invoking alternate constructor (10, 20, 30): ");
        class2.print();
        class2.set(20, 30, 40);
        System.out.print("\nclass1.print() after call to set (20, 30, 40): ");
        class2.print();
        System.out.print("\nclass1.toString(): " + class2);
        System.out.println("\n" + divider);
        //end of class 2 testing
    }
}
