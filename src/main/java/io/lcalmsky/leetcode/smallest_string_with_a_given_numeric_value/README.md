> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/smallest_string_with_a_given_numeric_value/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/) 있습니다.

## Problem

The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.

The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.

You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.

Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.

**Example 1:**
```text
Input: n = 3, k = 27
Output: "aay"
Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.
```
**Example 2:**
```text
Input: n = 5, k = 73
Output: "aaszz"
```

**Constraints:**

* 1 <= n <= 10^5
* n <= k <= 26 * n

## Solution

알파벳 소문자가 각자의 위치에 해당하는 값을 같습니다. 문자열은 이 알파벳들의 값으로 계산하여 나타낼 수 있습니다.

정수 n과 k가 주어질 때 길이 n과 정수값 k에 해당하는 사전적으로 가장 작은 문자열을 반환하는 문제입니다.

```java
import java.util.Arrays;

public class Solution {

  public String getSmallestString(int n, int k) {
    char[] array = new char[n]; // (1)
    Arrays.fill(array, 'a'); // (2)
    k -= n; // (3)
    for (int i = n - 1; i >= 0 && k > 0; i--) { // (4)  
      int min = Math.min(25, k); 
      array[i] += min; // (5)
      k -= min; // (6)
    }
    return String.valueOf(array);
  }
}

```

1. 길이 n의 char 배열을 생성합니다.
2. 생성한 배열을 모두 'a'로 채웁니다.
3. 이미 n개의 a로 구성되어있기 때문에 n * 1 = n 만큼을 k에서 빼줍니다.
4. 끝까지 탐색하거나 k가 0보다 클 동안 배열의 끝에서 앞으로 순차적으로 탐색하는데
5. k와 25중 더 작은 값으로 배열을 채우고
6. 그 값만큼 k에서 빼줍니다.

## Test

```java
package io.lcalmsky.leetcode.smallest_string_with_a_given_numeric_value;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(3, 27, "aay"),
        () -> test(5, 73, "aaszz")
    );
  }

  private void test(int n, int k, String expected) {
    // when
    Solution solution = new Solution();
    String actual = solution.getSmallestString(n, k);
    // then
    assertEquals(expected, actual);
  }
}
```