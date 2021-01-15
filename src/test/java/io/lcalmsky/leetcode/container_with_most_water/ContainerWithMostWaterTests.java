package io.lcalmsky.leetcode.container_with_most_water;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainerWithMostWaterTests {
    @Test
    public void integrationTest() {
        Assertions.assertAll(
                () -> test(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                () -> test(new int[]{1, 2, 1, 1, 1, 2, 1, 1, 1}, 8)
        );
    }

    public void test(int[] given, int expected) {
        // when
        Solution containerWithMostWater = new Solution();
        int result = containerWithMostWater.maxArea(given);

        // then
        Assertions.assertEquals(expected, result);

        // log
        System.out.println(result);
    }
}
