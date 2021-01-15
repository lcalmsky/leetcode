package io.lcalmsky.leetcode.next_greater_element_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NextGreaterElement2Tests {
    @Test
    public void givenArray_whenFindNextGreaterElement_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 1}, new int[]{2, -1, 2})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        Solution nextGreaterElement2 = new Solution();
        int[] actual = nextGreaterElement2.nextGreaterElements(given);

        // then
        assertArrayEquals(expected, actual);
    }
}
