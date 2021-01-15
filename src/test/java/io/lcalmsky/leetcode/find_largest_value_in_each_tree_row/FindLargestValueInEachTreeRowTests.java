package io.lcalmsky.leetcode.find_largest_value_in_each_tree_row;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindLargestValueInEachTreeRowTests {
    @Test
    public void givenTreeNode_whenFindLargestValueInEachTreeRow_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 3, 2, 5, 3, 9), Arrays.asList(1, 3, 9))
        );
    }

    private void test(TreeNode given, List<Integer> expected) {
        // when
        Solution findLargestValueInEachTreeRow = new Solution();
        List<Integer> actual = findLargestValueInEachTreeRow.largestValues(given);

        // then
        assertEquals(expected, actual);
    }
}
