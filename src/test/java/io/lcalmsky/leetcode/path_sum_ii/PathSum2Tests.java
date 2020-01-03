package io.lcalmsky.leetcode.path_sum_ii;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PathSum2Tests {
    @Test
    public void givenTreeNode_whenSum_thenFindPaths() {
        Assertions.assertAll(
                () -> test(TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22, Arrays.asList(
                        Arrays.asList(5, 4, 11, 2),
                        Arrays.asList(5, 8, 4, 5)
                ))
        );
    }

    private void test(TreeNode given, int sum, List<List<Integer>> expected) {
        // when
        PathSum2 pathSum2 = new PathSum2();
        List<List<Integer>> actual = pathSum2.pathSum(given, sum);

        // then
        assertThat(actual).containsOnlyElementsOf(expected);
    }
}
