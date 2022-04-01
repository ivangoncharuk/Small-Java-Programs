package cosc237.lab7;

import cosc237.lab7.classes.Book;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Book book = new Book(generateID(), "Mein Kampf", 1, "Adolf Hitler");
        System.out.println(book);
    }

    public static String generateID() {
        final int min = 0, max = 9;
        Random r = new Random();
        int[] arr = new int[6];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (r.nextInt((max + 1) - min) + min);
            result.append(arr[i]);
        }
        return result.toString();
    }
}
