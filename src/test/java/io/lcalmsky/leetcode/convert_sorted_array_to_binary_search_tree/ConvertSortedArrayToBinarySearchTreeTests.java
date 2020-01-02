package io.lcalmsky.leetcode.convert_sorted_array_to_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertSortedArrayToBinarySearchTreeTests {
    @Test
    public void givenSortedArray_whenConvertToBinarySearchTree_thenCorrect() {
        assertAll(
                () -> test(new int[]{-10, -3, 0, 5, 9}, TreeNode.of(0, -3, 9, -10, null, 5))
        );
    }

    private void test(int[] given, TreeNode expected) {
        // when
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        TreeNode actual = convertSortedArrayToBinarySearchTree.sortedArrayToBST(given);

        // then
        assertEquals(expected, actual);
    }
}
