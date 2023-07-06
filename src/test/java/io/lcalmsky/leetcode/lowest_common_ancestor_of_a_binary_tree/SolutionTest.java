//package io.lcalmsky.leetcode.lowest_common_ancestor_of_a_binary_tree;
//
//import io.lcalmsky.leetcode.TreeNode;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class SolutionTest {
//    @Test
//    void testAll() {
//        assertAll(
//                () -> test(TreeNode.of(3,5,1,6,2,0,8,null,null,7,4), TreeNode.of(5), TreeNode.of(1), TreeNode.of(3)),
//                () -> test(TreeNode.of(3,5,1,6,2,0,8,null,null,7,4), TreeNode.of(5), TreeNode.of(4), TreeNode.of(5)),
//                () -> test(TreeNode.of(1, 2), TreeNode.of(1), TreeNode.of(2), TreeNode.of(1))
//        );
//    }
//
//    private void test(TreeNode root, TreeNode p, TreeNode q, TreeNode expected) {
//        // when
//        Solution solution = new Solution();
//        System.out.println(root);
//        System.out.println(p);
//        System.out.println(q);
//        TreeNode actual = solution.lowestCommonAncestor(root, p, q);
//        // then
//        assertEquals(expected, actual);
//    }
//}