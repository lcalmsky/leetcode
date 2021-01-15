package io.lcalmsky.leetcode.combination_sum_iii;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CombinationSum3Tests {
    @Test
    public void givenNumberAndSum_whenFindCombinations_thenCorrect() {
        assertAll(
                () -> test(3, 7, Collections.singletonList(Arrays.asList(1, 2, 4))),
                () -> test(3, 9, Arrays.asList(
                        Arrays.asList(1, 2, 6),
                        Arrays.asList(1, 3, 5),
                        Arrays.asList(2, 3, 4))
                )
        );
    }

    private void test(int k, int n, List<List<Integer>> expected) {
        // when
        Solution combinationSum3 = new Solution();
        List<List<Integer>> actual = combinationSum3.combinationSum3(k, n);

        // then
        assertThat(actual).containsOnlyElementsOf(expected);
    }
}
