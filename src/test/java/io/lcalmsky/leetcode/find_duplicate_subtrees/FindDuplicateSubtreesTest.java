package io.lcalmsky.leetcode.find_duplicate_subtrees;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindDuplicateSubtreesTest {
    @Test
    public void givenBinaryTree_whenFindDuplicateSubtrees_thenCorrect() {
        assertAll(
                () -> test(
                        TreeNode.of(1, 2, 3, 4, null, 2, 4, null, null, 4),
                        Arrays.asList(TreeNode.of(2, 4, null, null, null), TreeNode.of(4, null, null)
                        )),
                () -> test(
                        TreeNode.of(2, 1, 1),
                        Collections.singletonList(TreeNode.of(1))
                ),
                () -> test(
                        TreeNode.of(2, 2, 2, 3, null, 3, null),
                        Arrays.asList(TreeNode.of(2, 3), TreeNode.of(3))
                )
        );
    }

    private void test(TreeNode given, List<TreeNode> expected) {
        // when
        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        List<TreeNode> actual = findDuplicateSubtrees.findDuplicateSubtrees(given);

        // then
        assertEquals(expected, actual);
    }
}