package leetcode.easy;

/**
 * <pre>
 *     704. Binary Search
 *     [Easy]
 *     Given an array of integers nums which is sorted in ascending order,
 *     and an integer target, write a function to search target in nums.
 *     If target exists, then return its index.
 *     Otherwise, return -1.
 *     You must write an algorithm with O(log n) runtime complexity.
 * </pre>
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * <pre>
     * Binary search is a textbook algorithm based on the idea to compare
     * the target value to the middle element of the array.
     *
     * If the target value is equal to the middle element - we're done.
     *
     * If the target value is smaller - continue to search on the left.
     *
     * If the target value is larger - continue to search on the right.
     * </pre>
     *
     * @param nums sorted array
     * @param target target
     * @return index of target, -1 if not found
     */
    public static int search2(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }
}
