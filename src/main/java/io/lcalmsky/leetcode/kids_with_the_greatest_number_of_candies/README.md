> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/kids_with_the_greatest_number_of_candies/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/) 있습니다.

## Problem

There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.

**Example 1:**

```text
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]
Explanation: If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
```

**Example 2:**

```text
Input: candies = [4,2,1,1,2], extraCandies = 1
Output: [true,false,false,false,false]
Explanation: There is only 1 extra candy.
Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
```

**Example 3:**

```text
Input: candies = [12,1,12], extraCandies = 10
Output: [true,false,true]
```

**Constraints:**

* n == candies.length
* 2 <= n <= 100
* 1 <= candies[i] <= 100
* 1 <= extraCandies <= 50

## Solution

```java
package io.lcalmsky.leetcode.kids_with_the_greatest_number_of_candies;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}

```

## Test

```java
package io.lcalmsky.leetcode.kids_with_the_greatest_number_of_candies;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
                () -> test(new int[]{4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false)),
                () -> test(new int[]{12, 1, 12}, 10, List.of(true, false, true))
        );
    }

    private void test(int[] candies, int extraCandies, List<Boolean> expected) {
        Solution solution = new Solution();
        List<Boolean> actual = solution.kidsWithCandies(candies, extraCandies);
        assertEquals(expected, actual);
    }
}
```