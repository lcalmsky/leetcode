> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/longest_turbulent_subarray/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3976/) 있습니다.

## Problem

Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

* For i <= k < j:
    * arr[k] > arr[k + 1] when k is odd, and
    * arr[k] < arr[k + 1] when k is even.
* Or, for i <= k < j:
    * arr[k] > arr[k + 1] when k is even, and
    * arr[k] < arr[k + 1] when k is odd.

**Example 1:**

```
Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
```

**Example 2:**

```
Input: arr = [4,8,12,16]
Output: 2
```

**Example 3:**

```
Input: arr = [100]
Output: 1
```

**Constraints:**

* 1 <= arr.length <= 4 * 10^4
* 0 <= arr[i] <= 10^9

## Solution

주어진 수열에서 숫자가 오르락 내리락하는 부분 수열 중 길이가 가장 긴 부분 수열의 길이를 반환하는 문제입니다.

첫 번 째 숫자 이후 다음 숫자가 증가했을 경우 그 다음 숫자는 반드시 감소해야하고, 반대의 경우에는 반드시 증가해야 합니다.

결과를 반환할 count 변수 외에 증가, 감소하는 갯수를 카운팅 할 변수를 추가로 선언하여 풀어보았습니다.

숫자가 증가, 증가하거나 감소, 감소했을 경우 다시 카운팅해야하기 때문에 매 조건마다 자기 자신의 값을 1로 업데이트 해주었습니다.

```java
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int increase = 1, decrease = 1, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                decrease = increase + 1;
                increase = 1;
            } else if (arr[i] > arr[i - 1]) {
                increase = decrease + 1;
                decrease = 1;
            } else {
                increase = 1;
                decrease = 1;
            }
            count = Math.max(count, Math.max(increase, decrease));
        }
        return count;
    }
}
```

이렇게 작성해서 제출했는데 생각보다 저조한(?) 성적을 받아 속도나 메모리 측면에서 더 나은 답이 무엇인지 확인해보았습니다.

먼저 속도 면에서 나은 답은, 최대 값을 구하는 시점을 조정하는 것 입니다.

```java
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int increase = 1, decrease = 1, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                decrease = increase + 1;
                increase = 1;
                count = Math.max(count, decrease);
            } else if (arr[i] > arr[i - 1]) {
                increase = decrease + 1;
                decrease = 1;
                count = Math.max(count, increase);
            } else {
                increase = 1;
                decrease = 1;
            }
        }
        return count;
    }
}
```

매 번 최댓값을 구하는 것이 아니라 숫자가 서로 다를 때만 구하기 때문에 숫자가 같을 경우 연산을 아낄 수 있고, 기존의 숫자 비교는 increase, decrease 값을 먼저 비교한 뒤 count와 비교했기 때문에 위 방식으로 한다면 연산 방식을 추가로 아낄 수 있습니다.

메모리를 아낄 수 있는 방법은, 한 변수를 사용해 계속 계산하면 임시 메모리 공간을 계속 사용하게 되기 때문에 배열을 사용해 메모리를 미리 지정하는 방법입니다.

```java
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int length = arr.length;
        if (length < 2) return length;
        int count = 1;
        int[] increase = new int[length];
        int[] decrease = new int[length];
        increase[0] = 1;
        decrease[0] = 1;
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] < arr[i]) {
                increase[i] = decrease[i - 1] + 1;
                decrease[i] = 1;
                count = Math.max(count, increase[i]);
            } else if (arr[i - 1] > arr[i]) {
                decrease[i] = increase[i - 1] + 1;
                increase[i] = 1;
                count = Math.max(count, decrease[i]);
            } else {
                increase[i] = 1;
                decrease[i] = 1;
            }
        }
        return count;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.longest_turbulent_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenNumbers_whenFindLongestTurbulentSubarray_thenCorrect() {
        assertAll(
                () -> test(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}, 5),
                () -> test(new int[]{4, 8, 12, 16}, 2),
                () -> test(new int[]{100}, 1)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxTurbulenceSize(given);

        // then
        assertEquals(expected, actual);
    }
}
```