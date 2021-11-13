> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/daily_temperatures/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/daily-temperatures/) 있습니다.

## Problem

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

**Example 1:**

```text
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
```

**Example 2:**

```text
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
```

**Example 3:**

```text
Input: temperatures = [30,60,90]
Output: [1,1,0]
```

**Constraints:**

* 1 <= temperatures.length <= 10^5
* 30 <= temperatures[i] <= 100

## Solution

일별 기온이 배열로 주어질 때 각 날짜 이후에 더 따듯해지기까지 기다려야하는 일수를 배열로 만들어 반환하는 문제입니다.

스택에 인덱스를 저장하고 각 날짜의 기온과 스택에 저장된 인덱스에 해당하는 기온을 비교하면서 현재 기온이 더 높을 경우 인덱스간 차이를 결과 배열에 저장하면 답을 구할 수 있습니다.

```java
import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if (temperatures.length == 0) return result;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
```

---

스택을 직접 배열로 구현하여 사용하면 속도나 메모리를 더 절약할 수 있습니다.

```java
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int top = -1;
        for(int i = 0; i < temperatures.length; i++) {
            while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                result[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return result;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.daily_temparatures;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTemperatures_whenCountDaysUntilWarmerTemperature_thenCorrect() {
    assertAll(
        () -> test(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
        () -> test(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
        () -> test(new int[]{30, 60, 90}, new int[]{1, 1, 0})
    );
  }

  private void test(int[] given, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.dailyTemperatures(given);

    // then
    assertArrayEquals(expected, actual);
  }
}
```