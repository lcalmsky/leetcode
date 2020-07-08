package io.lcalmsky.leetcode.find_bottom_left_tree_value;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindBottomLeftTreeValueTests {
    @Test
    public void givenTreeNode_whenFindBottomLeftValue_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(2, 1, 3), 1),
                () -> test(TreeNode.of(1, 2, 3, 4, 5, 6, null, null, 7), 7)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
        int actual = findBottomLeftTreeValue.findBottomLeftValue(given);

        // then
        assertEquals(expected, actual);
    }
}
