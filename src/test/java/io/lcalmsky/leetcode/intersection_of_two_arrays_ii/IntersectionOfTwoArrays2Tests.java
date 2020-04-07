package io.lcalmsky.leetcode.intersection_of_two_arrays_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntersectionOfTwoArrays2Tests {
    @Test
    public void givenTwoArrays_whenFindIntersection_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
                () -> test(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9})
        );
    }

    private void test(int[] given1, int[] given2, int[] expected) {
        // when
        IntersectionOfTwoArrays2 intersectionOfTwoArrays2 = new IntersectionOfTwoArrays2();
        int[] actual = intersectionOfTwoArrays2.intersect(given1, given2);

        // then
        assertArrayEquals(expected, actual);
    }
}
