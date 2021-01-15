package io.lcalmsky.leetcode.house_robber_iii;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobber3Tests {
    @Test
    public void givenTree_whenRob_thenGetMaximumAmountOfMoney() {
        assertAll(
                () -> test(TreeNode.of(3, 2, 3, null, 3, null, 1), 7),
                () -> test(TreeNode.of(3, 4, 5, 1, 3, null, 1), 9)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution houseRobber3 = new Solution();
        int actual = houseRobber3.rob(given);

        // then
        assertEquals(expected, actual);
    }
}
