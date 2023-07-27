> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_the_highest_altitude/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-the-highest-altitude/) 있습니다.

## Problem

There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

**Example 1:**
```text
Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
```

**Example 2:**
```text
Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
```

**Constraints:**

* n == gain.length
* 1 <= n <= 100
* -100 <= gain[i] <= 100

## Solution

```java
package io.lcalmsky.leetcode.find_the_highest_altitude;

public class Solution {
    public int largestAltitude(int[] gain) {
        int net = 0;
        int max = net;
        for (int i : gain) {
            net += i;
            max = Math.max(net, max);
        }
        return max;
    }
}

```

## Test

```java
package io.lcalmsky.leetcode.find_the_highest_altitude;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{-5, 1, 5, 0, -7}, 1),
                () -> test(new int[]{-4, -3, -2, -1, 4, 3, 2}, 0)
        );
    }

    private void test(int[] gain, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.largestAltitude(gain);
        // then
        assertEquals(expected, actual);
    }

}
```