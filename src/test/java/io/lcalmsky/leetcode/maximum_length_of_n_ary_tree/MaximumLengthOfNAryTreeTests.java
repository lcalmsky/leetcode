package io.lcalmsky.leetcode.maximum_length_of_n_ary_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumLengthOfNAryTreeTests {
    @Test
    public void givenNodes_whenFindMaximumDepth_thenCorrect() {
        assertAll(
//                () -> test()
        );
    }

    private void test(Node given, int expected) {
        // when
        MaximumLengthOfNAryTree maximumLengthOfNAryTree = new MaximumLengthOfNAryTree();
        int actual = maximumLengthOfNAryTree.maxDepth(given);

        // then
        assertEquals(expected, actual);
    }
}