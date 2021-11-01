package io.lcalmsky.leetcode._3sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("주어진 배열에서 세 개의 원소를 더해 0을 만드는 모든 부분 배열을 구한다.")
    void test() {
        assertAll(
            () -> test(new int[]{-1, 0, 1, 2, -1, 4},
                List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))),
            () -> test(new int[]{}, Collections.emptyList()),
            () -> test(new int[]{0}, Collections.emptyList())
        );
    }

    private void test(int[] given, List<List<Integer>> expected) {
        // when
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.threeSum(given);

        // then
        assertEquals(expected, actual);
    }
}