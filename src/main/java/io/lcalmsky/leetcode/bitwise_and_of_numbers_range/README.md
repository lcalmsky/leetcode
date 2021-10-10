> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/bitwise_and_of_numbers_range/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/bitwise-and-of-numbers-range/) 있습니다.

## Problem

Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

**Example 1:**

```text
Input: left = 5, right = 7
Output: 4
```

**Example 2:**

```text
Input: left = 0, right = 0
Output: 0
```

**Example 3:**

```text
Input: left = 1, right = 2147483647
Output: 0
```

**Constraints:**

0 <= left <= right <= 23^1 - 1

## Solution

두 개의 숫자가 주어졌을 때 두 수를 포함해서 사이에 존재하는 모든 숫자를 AND 연산하여 나오는 값을 반환하는 문제입니다.

범위 내에서 비트 AND 연산은 실제로 left과 right의 두 숫자만으로 일부 연산을 수행해 구할 수 있습니다.

예제 1번에서 처럼 5와 7은 이진법으로 각각 101과 111이고 [5, 7]의 결과는 5 & 6 & 7 = 101 & 110 & 111 입니다.

left와 right의 숫자가 같아질 때까지 왼쪽에서 오른쪽으로 이동한 뒤 뒷자리를 0으로 채우는 것과 동일합니다.

5와 7로 예를 들면 아래와 같습니다.

```text
101, 111을 두 비트가 같이질 때까지 오른쪽으로 이동
(0) 101
(0) 111

(1) 10
(1) 11

(2) 1
(2) 1

1에 이동한 횟수만큼 0을 더해줌
답: 100
```

이를 소스 코드로 나타내면 아래와 같습니다.

```java
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int move = 0;
        while (left != right) { // (1)
            left >>= 1;
            right >>= 1;
            move++;
        }
        return right << move; // (2)
    }
}
```

1. 두 수가 같아질 때까지 오른쪽으로 한 비트씩 shift 하면서 이동한 갯수를 카운트
2. 같아진 수에서 이동한 비트 수만큼 다시 왼쪽으로 shift

## Test

```java
package io.lcalmsky.leetcode.bitwise_and_of_numbers_range;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void givenNumbers_whenGetBitwiseAndOfNumbersRange_thenCorrect() {
        assertAll(
                () -> test(5, 7, 4),
                () -> test(0, 1, 0),
                () -> test(1, 2147483647, 0)
        );

    }

    private void test(int a, int b, int expected) {
        // when
        Solution bitwiseAndOfNumbersRange = new Solution();
        int actual = bitwiseAndOfNumbersRange.rangeBitwiseAnd(a, b);

        // then
        assertEquals(expected, actual);
    }
}
```