package io.lcalmsky.leetcode.print_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintBinaryTreeTest {
    @Test
    public void givenTree_whenPrintTree_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2), Arrays.asList(
                        Arrays.asList("", "1", ""),
                        Arrays.asList("2", "", "")
                )),
                () -> test(TreeNode.of(1, 2, 3, null, 4), Arrays.asList(
                        Arrays.asList("", "", "", "1", "", "", ""),
                        Arrays.asList("", "2", "", "", "", "3", ""),
                        Arrays.asList("", "", "4", "", "", "", "")
                )),
                () -> test(TreeNode.of(1, 2, 5, 3, null, null, null, 4), Arrays.asList(
                        Arrays.asList("", "", "", "", "", "", "", "1", "", "", "", "", "", "", ""),
                        Arrays.asList("", "", "", "2", "", "", "", "", "", "", "", "5", "", "", ""),
                        Arrays.asList("", "3", "", "", "", "", "", "", "", "", "", "", "", "", ""),
                        Arrays.asList("4", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
                )));
    }

    private void test(TreeNode given, List<List<String>> expected) {
        // when
        Solution printBinaryTree = new Solution();
        List<List<String>> actual = printBinaryTree.printTree(given);

        // then
        assertEquals(expected, actual);
    }

}
