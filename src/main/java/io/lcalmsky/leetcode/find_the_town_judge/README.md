> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_the_town_judge/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-the-town-judge/) 있습니다.

## Problem

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

**Example 1:**

```text
Input: n = 2, trust = [[1,2]]
Output: 2
```

**Example 2:**

```text
Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
```

**Example 3:**

```text
Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
```

**Constraints:**

* 1 <= n <= 1000
* 0 <= trust.length <= 10^4
* trust[i].length == 2
* All the pairs of trust are unique.
* ai != bi
* 1 <= ai, bi <= n

## Solution

1부터 n까지 숫자로 표현되는 사람 n명이 마을에 존재하고 그 중 한 명이 비밀리에 업무를 수행하는 마을 판사입니다. (우리나라로 따지면 암행어사인듯!)

만약에 마을 판사가 존재한다고하면, 마을 판사는 아무도 믿지 않고, 마을 판사를 제외한 모든 사람은 마을 판사를 믿고, 앞의 두 조건을 만족하는 한 사람이 존재합니다.

마을 사람의 수와 믿음을 나타내는 배열이 주어질 때 마을 판사가 존재하면 마을 판사의 숫자를, 그렇지 않으면 -1을 반환하는 문제입니다.

모든 사람이 믿고있는 한 사람이 다른 사람을 아무도 믿지 않을 경우 마을 판사가 존재함을 알 수 있습니다.

```java
public class Solution {

  public int findJudge(int n, int[][] trust) {
    int[] count = new int[n + 1];
    for (int[] t : trust) {
      count[t[0]]--;
      count[t[1]]++;
    }
    for (int i = 1; i <= n; i++) {
      if (count[i] == n - 1) {
        return i;
      }
    }
    return -1;
  }
}
```

신뢰 받는 쪽은 더해주고 신뢰를 하는 쪽은 빼준 뒤 마지막에 n-1만큼 신뢰받은 인덱스를 반환하면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.find_the_town_judge;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(2, new int[][]{{1, 2}}, 2),
        () -> test(3, new int[][]{{1, 3}, {2, 3}}, 3),
        () -> test(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}, -1)
    );
  }

  private void test(int n, int[][] trust, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.findJudge(n, trust);
    // then
    assertEquals(expected, actual);
  }
}
```