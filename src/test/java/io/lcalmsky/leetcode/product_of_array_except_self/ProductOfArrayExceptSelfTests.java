package io.lcalmsky.leetcode.product_of_array_except_self;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelfTests {
    @Test
    public void givenArray_whenProducts_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        Solution productOfArrayExceptSelf = new Solution();
        int[] actual = productOfArrayExceptSelf.productExceptSelf(given);

        // then
        assertArrayEquals(expected, actual);
    }
}
