package io.lcalmsky.leetcode.increasing_subsequences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class IncreasingSubsequencesTests {
    @Test
    public void givenNumbers_whenFindIncreasingSubsequences_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 6, 7, 7}, Arrays.asList(
                        Arrays.asList(4, 6),
                        Arrays.asList(4, 7),
                        Arrays.asList(4, 6, 7),
                        Arrays.asList(4, 6, 7, 7),
                        Arrays.asList(6, 7),
                        Arrays.asList(6, 7, 7),
                        Arrays.asList(7, 7),
                        Arrays.asList(4, 7, 7)
                ))
        );
    }

    private void test(int[] given, List<List<Integer>> expected) {
        // when
        IncreasingSubsequences increasingSubsequences = new IncreasingSubsequences();
        List<List<Integer>> actual = increasingSubsequences.findSubsequences(given);

        // then

    }
}
