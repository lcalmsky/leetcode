package io.lcalmsky.leetcode.delete_node_in_a_bst;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteNodeInABstTests {
    @Test
    public void givenBstNode_whenDeleteNode_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(5, 3, 6, 2, 4, null, 7), 3, Arrays.asList(TreeNode.of(5, 4, 6, 2, null, null, 7), TreeNode.of(5, 2, 6, null, 4, null, 7)))
        );
    }

    private void test(TreeNode given, int key, List<TreeNode> expected) {
        // when
        DeleteNodeInABst deleteNodeInABst = new DeleteNodeInABst();
        TreeNode actual = deleteNodeInABst.deleteNode(given, key);

        // then
        assertTrue(expected.contains(actual));
    }
}
