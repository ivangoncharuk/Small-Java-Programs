package leetcode.test.easy;

import leetcode.easy.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
    @Test
    void test_search_empty() {
        int[] arr = {};
        int key = 1;
        int expected = -1;
        int actual = BinarySearch.search(arr, key);
        assertEquals(expected, actual);
    }

    @Test
    void test_search_one() {
        int[] arr = {1};
        int key = 1;
        int expected = 0;
        int actual = BinarySearch.search(arr, key);
        assertEquals(expected, actual);
    }

    @Test
    void test_search_two() {
        int[] arr = {1, 2};
        int key = 1;
        int expected = 0;
        int actual = BinarySearch.search(arr, key);
        assertEquals(expected, actual);
    }

    @Test
    void test_search_two_not_found() {
        int[] arr = {1, 2};
        int key = 3;
        int expected = -1;
        int actual = BinarySearch.search(arr, key);
        assertEquals(expected, actual);
    }

    @Test
    void test_search_three() {
        int[] arr = {1, 2, 3};
        int key = 1;
        int expected = 0;
        int actual = BinarySearch.search(arr, key);
        assertEquals(expected, actual);
    }

    @Test
    void test_search_three_not_found() {
        int[] arr = {1, 2, 3};
        int key = 4;
        int expected = -1;
        int actual = BinarySearch.search(arr, key);
        assertEquals(expected, actual);
    }

    @Test
    void test_search_four() {
        int[] arr = {1, 2, 3, 4};
        int key = 1;
        int expected = 0;
        int actual = BinarySearch.search(arr, key);
        assertEquals(expected, actual);
    }

    @Test
    void test_search_four_not_found() {
        int[] arr = {1, 2, 3, 4};
        int key = 5;
        int expected = -1;
        int actual = BinarySearch.search(arr, key);
        assertEquals(expected, actual);
    }

    @Test
    void testSearch() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int expected = 4;
        int actual = BinarySearch.search(arr, target);
        assertEquals(expected, actual);

        arr = new int[]{-1, 0, 3, 5, 9, 12};
        target = 9;
        // expected = 4;
        actual = BinarySearch.search(arr, target);
        assertEquals(expected, actual);

        arr = new int[]{-1, 0, 3, 5, 9, 12};
        target = 2;
        expected = -1;
        actual = BinarySearch.search(arr, target);
        assertEquals(expected, actual);
    } // end testSearch

    // write the previous leetcode.test but for search2()
    @Test
    void testSearch2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int expected = 4;
        int actual = BinarySearch.search2(arr, target);
        assertEquals(expected, actual);

        arr = new int[]{-1, 0, 3, 5, 9, 12};
        target = 9;
        // expected = 4;
        actual = BinarySearch.search2(arr, target);
        assertEquals(expected, actual);

        arr = new int[]{-1, 0, 3, 5, 9, 12};
        target = 2;
        expected = -1;
        actual = BinarySearch.search2(arr, target);
        assertEquals(expected, actual);
    } // end testSearch2()
} // end class