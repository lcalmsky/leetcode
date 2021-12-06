> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/house_robber_iii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/house-robber-iii/) 있습니다.

## Problem

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/10/rob1-tree.jpg)

```text
Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/10/rob2-tree.jpg)

```text
Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 10^4].
* 0 <= Node.val <= 10^4

## Solution

[이전 포스팅](https://jaime-note.tistory.com/164)과 유사하지만 배열이 아닌 이진 트리 구조의 집을 터는 문제입니다.

이진 트리의 루트 노드가 털 구역의 입구가 되고 역시나 마찬가지로 연속된 두 집을 털 경우 경찰이 출동합니다.

경찰에게 쫓기지 않으면서 최대한 많은 돈을 터는 방법을 구하는 문제입니다.

DPS 방식으로 탐색하면서 각 노드에 대해 자신이 포함되고 한 노드씩 건너 뛰어서 포함시킬 때와 자신이 포함되지 않고 인접한 노드 또는 한 노드를 건너 뛴 노드가 포함되었을 때를 계산하여 최대로 털 수 있는 금액을 구할 수 있습니다.

```java
public class Solution {

  public int rob(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int[] result = helper(root);
    return Math.max(result[0], result[1]);
  }

  public int[] helper(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }
    int[] result = new int[2];
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    result[0] = root.val + left[1] + right[1]; // 자신이 포함되고 한 노드씩 건너 뛰고 포함시킬 경우
    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 자신이 포함되지 않고 인접한 노드 또는 한 노드를 건너 뛴 노드 중 더 높은 값
    return result;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.house_robber_iii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTree_whenRob_thenGetMaximumAmountOfMoney() {
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
```