package io.lcalmsky.leetcode.n_ary_tree_level_order_traversal.n_ary_tree_level_order_traversal;

import io.lcalmsky.leetcode.n_ary_tree_level_order_traversal.Node;
import io.lcalmsky.leetcode.n_ary_tree_level_order_traversal.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NAryTreeLevelOrderTraversalTests {
    @Test
    public void givenTreeNodes_whenTravelByLevelOrder_thenCorrect() {
//        assertAll(
//                () -> test(node, Arrays.asList(
//                        Collections.singletonList(1),
//                        Arrays.asList(2, 3, 4, 5),
//                        Arrays.asList(6, 7, 8, 9, 10),
//                        Arrays.asList(11, 12, 13),
//                        Collections.singletonList(14)
//                ))
//        );
    }

    private void test(Node given, List<List<Integer>> expected) {
        // when
        Solution nAryTreeLevelOrderTraversal = new Solution();
        List<List<Integer>> actual = nAryTreeLevelOrderTraversal.levelOrder(given);

        // then
        assertEquals(expected, actual);
    }
}
