package leetcode.test.easy;

import leetcode.easy.FirstBadVersion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstBadVersionTest {
    // leetcode.test firstBadVersion(int n) Input: n = 5, bad = 4
    // Output: 4
    @Test
    void testFirstBadVersion() {
        assertEquals(4, FirstBadVersion.firstBadVersion(5));
    }
}