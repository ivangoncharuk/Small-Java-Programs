package leetcode.test.easy;

import leetcode.easy.SearchInsertPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInsertPositionTest {
    // write a leetcode.test for searchInsert() using Input: nums = [1,3,5,6], target = 5, Output: 2
    @Test
    void searchInsert() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int expected = 2;
        int actual = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(expected, actual);
    }

    // using Input: nums = [1,3,5,6], target = 2, Output: 1
    @Test
    void searchInsert1() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int expected = 1;
        int actual = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(expected, actual);
    }

    // using Input: nums = [1,3,5,6], target = 7, Output: 4
    @Test
    void searchInsert2() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int expected = 4;
        int actual = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(expected, actual);
    }

    // using Input: nums = [1,3,5,6], target = 0, Output: 0
    @Test
    void searchInsert3() {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int expected = 0;
        int actual = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(expected, actual);
    }
}