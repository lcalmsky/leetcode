package io.lcalmsky.leetcode.subsets;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubsetsTests {
    @Test
    public void givenNumbers_whenGetSubsets_thenCorrect() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> test(new int[]{1, 2, 3}, Arrays.asList(
                        Collections.emptyList(),
                        Collections.singletonList(1),
                        Collections.singletonList(2),
                        Collections.singletonList(3),
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 3),
                        Arrays.asList(2, 3),
                        Arrays.asList(1, 2, 3)
                ))
        );
    }

    private void test(int[] given, List<List<Integer>> expected) {
        // when
        Subsets subsets = new Subsets();
        List<List<Integer>> actual = subsets.subsets(given);

        // then
        assertThat(actual).containsAll(expected);
    }
}
