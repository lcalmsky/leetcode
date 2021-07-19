> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/unique-binary-search-trees/) 있습니다.

## Problem

Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of
unique values from 1 to n.

Example 1:

```text
1   1       2       3   3
 \   \     / \     /   /
  3   2   1   3   2   1
 /     \         /     \
2       3       1       2
```

```text
Input: n = 3
Output: 5
```

Example 2:

```text
Input: n = 1
Output: 1
```

Constraints:

* 1 <= n <= 19

## Solution

정수 n이 주어졌을 때, 1에서 n까지 고유 값을 가진 n개의 노드를 갖는 구조적으로 고유한 BST의 수를 반환하는 문제입니다.

보자마자 규칙이 있을 거라고 생각하였고 마침 예제에서 n=3일 때 답이 5라는 걸 알려줬기 때문에 단순하게 숫자를 나열해봤습니다.

```text
n = 1: answer = 1
n = 2: answer = 2
n = 3: answer = 5
```

여기까지만 보면 벌써부터 뭔가 규칙이 보이는 거 같은데요, n이 4일때까지만 노가다로 구하고나면 완전히 알 거 같다는 생각에 머릿속으로 그려가면서 갯수를 일일히 세어보았습니다.

n이 4일 때는 총 14개가 나왔습니다.

규칙만 구했더라면 DP를 이용해 이전까지 계산된 값에 2를 곱하고 뭘 빼고 이럴 생각에 들떠있었는데 14라니..! 어떻게 끼워맞춰도 잘 안 되더군요.

아 이게 DP문제가 아니라 일일히 조건을 주어가면서 백트래킹으로 구해야 하는 문제인가 고민하다가 BST의 특징을 떠올려보았습니다.

BST는 가운데를 기준으로 왼쪽은 무조건 그 수보다 작은 수만 존재할 수 있고 오른쪽은 무조건 더 큰 수만 존재할 수 있습니다.

이게 반복되면서 leaf node까지 도달하게 될 거고 여기서 제가 놓친 규칙을 찾을 수 있었습니다.

n이 5일 때를 예를 들면,

```text
n=5, root=1: root를 기준으로 우측에 [2, 3, 4, 5]가 위치
n=5, root=2: root를 기준으로 좌측에 [1]이, 우측에 [3, 4, 5]가 위치
n=5, root=3: root를 기준으로 좌측에 [1, 2]가, 우측에 [4, 5]가 위치
n=5, root=4: root를 기준으로 좌측에 [1, 2, 3]이, 우측에 [5]가 위치
n=5, root=5: root를 기준으로 좌측에 [1, 2, 3, 4]가 위치
```

수식으로 표현해보면

```text
dp[5] = dp[0] * dp[4] +
        dp[1] * dp[3] +
        dp[2] * dp[2] +
        dp[3] * dp[1] +
        dp[4] * dp[0]
```

이렇게 됩니다.

dp[4]일 때 맞는지 검산을 해보면,

```text
dp[4] = dp[0] * dp[3] +
        dp[1] * dp[2] +
        dp[2] * dp[1] +
        dp[3] * dp[0]
      = 1 * 5 + 
        1 * 2 + 
        2 * 1 + 
        5 * 1
      = 14
```

딱 맞아떨어지네요 😁

소스 코드로 작성해보았습니다.

```java
package io.lcalmsky.leetcode.unique_binary_search_trees;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
```

```java
package io.lcalmsky.leetcode.unique_binary_search_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testAll() {
        assertAll(
                () -> test(3, 5),
                () -> test(1, 1),
                () -> test(4, 14)
        );
    }

    private void test(int given, int expected) {
        // when
        int actual = solution.numTrees(given);

        // then
        assertEquals(expected, actual);
    }
}
```

로컬 테스트는 무사히 통과하였습니다.

코드를 제출해보니

```text
Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
Memory Usage: 35.5 MB, less than 78.49% of Java online submissions for Unique Binary Search Trees.
```

좋은 성적으로 통과했습니다 🥳