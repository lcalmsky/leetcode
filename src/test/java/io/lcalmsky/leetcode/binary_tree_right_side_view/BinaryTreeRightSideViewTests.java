package io.lcalmsky.leetcode.binary_tree_right_side_view;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeRightSideViewTests {
    @Test
    public void givenTreeNode_whenGetRightSideView_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, null, 5, null, 4), Arrays.asList(1, 3, 4))
        );
    }

    private void test(TreeNode given, List<Integer> expected) {
        // when
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        List<Integer> actual = binaryTreeRightSideView.rightSideView(given);

        // then
        assertEquals(expected, actual);
    }
}
