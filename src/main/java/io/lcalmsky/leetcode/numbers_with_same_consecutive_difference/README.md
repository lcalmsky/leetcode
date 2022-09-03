> 소스 코드는 [여기](https  
> 문제는 [여기](https

## Problem

Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.

**Example 1:**
```text
Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
```

**Example 2:**
```text
Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
```

**Constraints:**

* 2 <= n <= 9
* 0 <= k <= 9

## Solution

모든 연속된 숫자 사이의 절대값의 차이가 k가 되는 음수가 아니면서 길이가 n인 모든 정수를 반환하는 문제입니다.

문제의 예시에 나와있듯이 n=3이고 k=7일 때 길이가 3인 정수 181은 각각의 자리가 7씩 차이가나는데 이런 세 자리 정수는 5개밖에 존재하지 않습니다.

한 정수를 끝까지 탐색하는 DFS를 이용하는 방법과 각 자리먼저 탐색하는 BFS 두 가지 방법으로 풀이할 수 있습니다.

먼저 DFS를 이용한 풀이입니다.

```java
import java.util.ArrayList;
import java.util.List;

class Solution {

  public int[] numsSameConsecDiff(int N, int K) {
    if (N == 1) {
      return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
    List<Integer> results = new ArrayList<>();
    for (int num = 1; num < 10; num++) {
      dfs(N - 1, num, K, results);
    }
    return results.stream().mapToInt(i -> i).toArray();
  }

  protected void dfs(int N, int num, int K, List<Integer> results) {
    if (N == 0) {
      results.add(num);
      return;
    }
    List<Integer> nextDigits = new ArrayList<>();
    int tailDigit = num % 10;
    nextDigits.add(tailDigit + K);
    if (K != 0) {
      nextDigits.add(tailDigit - K);
    }
    for (int nextDigit : nextDigits) {
      if (0 <= nextDigit && nextDigit < 10) {
        int newNum = num * 10 + nextDigit;
        dfs(N - 1, newNum, K, results);
      }
    }
  }
}
```

다음은 BFS를 이용한 방법입니다.

```java
import java.util.ArrayList;
import java.util.List;

class Solution {

  public int[] numsSameConsecDiff(int N, int K) {
    if (N == 1) {
      return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
    List<Integer> queue = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    for (int level = 1; level < N; level++) {
      List<Integer> nextQueue = new ArrayList<>();
      for (Integer num : queue) {
        int tailDigit = num % 10;
        ArrayList<Integer> nextDigits = new ArrayList<>();
        nextDigits.add(tailDigit + K);
        if (K != 0) {
          nextDigits.add(tailDigit - K);
        }
        for (Integer nextDigit : nextDigits) {
          if (0 <= nextDigit && nextDigit < 10) {
            Integer newNum = num * 10 + nextDigit;
            nextQueue.add(newNum);
          }
        }
      }
      queue = nextQueue;
    }
    return queue.stream().mapToInt(i -> i).toArray();
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.numbers_with_same_consecutive_difference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(3, 7, new int[]{181, 292, 707, 818, 929}),
        () -> test(2, 1,
            new int[]{10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98})
    );
  }

  private void test(int n, int k, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.numsSameConsecDiff(n, k);
    // then
    Arrays.sort(actual);
    Arrays.sort(expected);
    assertArrayEquals(expected, actual);
  }

}
```