package io.lcalmsky.leetcode.combination_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationSumTests {

    private CombinationSum combinationSum;

    @BeforeEach
    public void init() {
        combinationSum = new CombinationSum();
    }


    @Test
    @DisplayName("([2, 3, 6, 7]), 7 -> [[2, 2, 3], [7]]")
    public void givenArray_whenCombination_thenCorrect_case1() {
        // given
        int[] array = new int[]{2, 3, 6, 7};
        int target = 7;

        // when
        List<List<Integer>> result = combinationSum.combinationSum(array, target);

        // then
        assertAll(
                () -> assertTrue(result.contains(Arrays.asList(2, 2, 3))),
                () -> assertTrue(result.contains(Collections.singletonList(7)))
        );

        // log
        System.out.println(result);
    }

    @Test
    @DisplayName("([2, 3, 5], 8) -> [[2, 2, 2, 2], [2, 3, 3], [3, 5]]")
    public void givenArray_whenCombination_thenCorrect_case2() {
        // given
        int[] array = new int[]{2, 3, 5};
        int target = 8;

        // when
        List<List<Integer>> result = combinationSum.combinationSum(array, target);

        // then
        assertAll(
                () -> assertTrue(result.contains(Arrays.asList(2, 2, 2, 2))),
                () -> assertTrue(result.contains(Arrays.asList(2, 3, 3))),
                () -> assertTrue(result.contains(Arrays.asList(3, 5)))
        );

        assertEquals(Stream.of(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5)).collect(Collectors.toList()), result);

        // log
        System.out.println(result);
    }
}
