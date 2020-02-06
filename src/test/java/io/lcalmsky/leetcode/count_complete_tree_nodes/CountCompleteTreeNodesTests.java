package io.lcalmsky.leetcode.count_complete_tree_nodes;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountCompleteTreeNodesTests {
    @Test
    public void givenCompleteTree_whenCount_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, 4, 5, 6), 6)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        int actual = countCompleteTreeNodes.countNodes(given);

        // then
        assertEquals(expected, actual);
    }
}
