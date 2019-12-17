package io.lcalmsky.leetcode.combination_sum_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationSum2Tests {

    @Test
    public void givenIntegerArray_whenCombineElements_thenEqualsTarget() {
        Assertions.assertAll(
                () -> test(
                        new int[]{10, 1, 2, 7, 6, 1, 5},
                        8,
                        Arrays.asList(
                                Arrays.asList(1, 1, 6), Arrays.asList(1, 2, 5), Arrays.asList(1, 7), Arrays.asList(2, 6)
                        )),
                () -> test(
                        new int[]{2, 5, 2, 1, 2},
                        5,
                        Arrays.asList(
                                Arrays.asList(1, 2, 2), Collections.singletonList(5)
                        ))
        );
    }

    public void test(int[] given, int target, List<List<Integer>> expected) {
        // when
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> actual = combinationSum2.combinationSum2(given, target);

        // then
        assertEquals(expected, actual);

        // log
        System.out.println(actual);
    }
}
