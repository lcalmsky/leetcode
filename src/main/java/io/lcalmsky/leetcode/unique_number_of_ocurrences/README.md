> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/unique_number_of_ocurrences/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/unique-number-of-ocurrences/) 있습니다.

## Problem

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

**Example 1:**
```text
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
```

**Example 2:**
```text
Input: arr = [1,2]
Output: false
```

**Example 3:**
```text
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
```


**Constraints:**

* 1 <= arr.length <= 1000
* -1000 <= arr[i] <= 1000

## Solution

```java
package io.lcalmsky.leetcode.unique_number_of_ocurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}

```

## Test

```java
package io.lcalmsky.leetcode.unique_number_of_ocurrences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 2, 1, 1, 3}, true),
                () -> test(new int[]{1, 2}, false),
                () -> test(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}, true)
        );
    }

    private void test(int[] arr, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.uniqueOccurrences(arr);
        // then
        assertEquals(expected, actual);
    }
}
```