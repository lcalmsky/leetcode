package io.lcalmsky.leetcode.find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree;

import static org.junit.jupiter.api.Assertions.*;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> {
          TreeNode original = TreeNode.of(7, 4, 3, null, null, 6, 19);
          TreeNode cloned = original.clone();
          TreeNode target = original.right;
          test(original, cloned, target);
        },
        () -> {
          TreeNode original = TreeNode.of(7);
          TreeNode cloned = original.clone();
          TreeNode target = original;
          test(original, cloned, target);
        },
        () -> {
          TreeNode original = TreeNode.of(8,null,6,null,5,null,4,null,3,null,2,null,1);
          TreeNode cloned = original.clone();
          TreeNode target = original.right.right.right;
          test(original, cloned, target);
        }
    );
  }

  private void test(TreeNode original, TreeNode cloned, TreeNode target) {
    // when
    Solution solution = new Solution();
    TreeNode actual = solution.getTargetCopy(original, cloned, target);
    // solution
    assertEquals(target, actual);
  }

}