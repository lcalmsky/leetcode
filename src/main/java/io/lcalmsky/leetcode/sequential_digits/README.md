> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/sequential_digits/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/sequential-digits/) 있습니다.

## Problem

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

**Example 1:**
```text
Input: low = 100, high = 300
Output: [123,234]
```
**Example 2:**
```text
Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
```

**Constraints:**

* 10 <= low <= high <= 10^9

## Solution

각 자리의 숫자가 증가하는 숫자를 sequential digit이라고 부릅니다.

low값과 high값이 주어질 때 해당 범위 안에 sequential digit들을 정렬된 리스트로 반환하는 문제입니다.

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> sequentialDigits(int low, int high) {
    String digits = "123456789";
    List<Integer> result = new ArrayList<>();
    int lowLength = String.valueOf(low).length();
    int highLength = String.valueOf(high).length();
    for (int i = lowLength; i <= highLength; i++) { // (1) 
      for (int j = 0; j < 10 - i; j++) {
        int num = Integer.parseInt(digits.substring(j, j + i)); // (2)  
        if (num >= low && num <= high) { // (3) 
          result.add(num);
        }
      }
    }
    return result;
  }
}
```

1. low의 길이부터 high의 길이까지 반복합니다.
2. j에서 j+i번째까지 연속된 숫자를 구합니다.
3. low와 high 범위 내에 해당 숫자가 존재하면 결과에 추가합니다.



## Test

```java
package io.lcalmsky.leetcode.sequential_digits;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(100, 300, List.of(123, 234)),
        () -> test(1000, 13000, List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345))
    );
  }

  private void test(int low, int high, List<Integer> expected) {
    // when
    Solution solution = new Solution();
    List<Integer> actual = solution.sequentialDigits(low, high);
    // then
    assertEquals(expected, actual);
  }
}
```