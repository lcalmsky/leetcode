package io.lcalmsky.leetcode.partition_labels;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenString_whenPartitionString_thenEachLetterAppearsMost() {
        assertAll(
                () -> test("ababcbacadefegdehijhklij", Arrays.asList(9, 7, 8))
        );
    }

    private void test(String given, List<Integer> expected) {
        // when
        Solution solution = new Solution();
        List<Integer> actual = solution.partitionLabels(given);

        // then
        assertEquals(expected, actual);
    }

}
