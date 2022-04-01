package leetcode.easy;


/**
 * 278. First Bad Version
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad.
 */
public class FirstBadVersion {


    /**
     * <pre>
     * Runtime: 28 ms, faster than 16.46% of Java online submissions.
     * Memory Usage: 41.5 MB, less than 8.24% of Java online submissions.
     * </pre>
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int n) {
        return n == 4;
    }
}
