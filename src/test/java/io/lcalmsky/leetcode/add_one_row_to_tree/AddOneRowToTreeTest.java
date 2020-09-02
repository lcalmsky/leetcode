package io.lcalmsky.leetcode.add_one_row_to_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddOneRowToTreeTest {
    @Test
    public void givenBinaryTree_whenAddOneRow_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(4, 2, 6, 3, 1, 5), 1, 2, TreeNode.of(4, 1, 1, 2, null, null, 6, 3, 1, 5)),
                () -> test(TreeNode.of(4, 2, null, 3, 1), 1, 3, TreeNode.of(4, 2, null, 1, 1, 3, null, null, 1))
        );
    }

    private void test(TreeNode given, int v, int d, TreeNode expected) {
        // when
        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
        TreeNode actual = addOneRowToTree.addOneRow(given, v, d);

        // then
        assertEquals(expected, actual);
    }

}