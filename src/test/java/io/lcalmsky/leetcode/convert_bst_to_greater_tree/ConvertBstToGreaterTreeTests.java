package io.lcalmsky.leetcode.convert_bst_to_greater_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertBstToGreaterTreeTests {
    @Test
    public void givenTreeNode_whenConvertBstToGreaterTree_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(5, 2, 13), TreeNode.of(18, 20, 13))
        );
    }

    private void test(TreeNode given, TreeNode expected) {
        // when
        ConvertBstToGreaterTree convertBstToGreaterTree = new ConvertBstToGreaterTree();
        TreeNode actual = convertBstToGreaterTree.convertBST(given);

        // then
        assertEquals(expected, actual);
    }
}
