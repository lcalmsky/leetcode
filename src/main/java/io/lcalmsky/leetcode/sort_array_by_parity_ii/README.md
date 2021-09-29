> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/sort_array_by_parity_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3990/) 있습니다.

## Problem

Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

**Example 1:**

```text
Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
```

**Example 2:**

```text
Input: nums = [2,3]
Output: [2,3]
```

**Constraints:**

* 2 <= nums.length <= 2 * 10^4
* nums.length is even.
* Half of the integers in nums are even.
* 0 <= nums[i] <= 1000

Follow Up: Could you solve it in-place?

## Solution

주어진 배열을 짝수 인덱스에는 짝수가 위치하도록, 홀수 인덱스에는 홀수가 위치하도록 정렬하는 문제입니다.

Follow Up에 명시된 것처럼 추가적인 메모리를 사용하지 않고 풀어보겠습니다.

홀수, 짝수를 선언하여 각각 배열의 길이가 넘어가기 전까지 탐색하면서, 해당 위치에 유효하지 않은 값이 있을 때까지 검사합니다.

이 때 효율을 높이기 위해선 % 연산보다 bit-operation을 사용하시는 게 좋습니다.

1과 & 연산하였을 때 0이나오면 짝수, 1이 나오면 홀수입니다.

ex)
```text
주어진 숫자가 6일 때:
1 1 0
&   1
-----
    0
주어진 숫자가 7일 때:
1 1 1
&   1
_____
    1
```

유효하지 않은 위치에 있는 짝수, 홀수 인덱스를 구했다면 두 개의 위치를 swap해 줍니다.

```java
public class Solution {
    
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int even = 0, odd = 1;
        while (even < n && odd < n) {
            while (even < n && (nums[even] & 1) == 0) {
                even += 2;
            }
            while (odd < n && (nums[odd] & 1) != 0) {
                odd += 2;
            }
            if (even < n && odd < n) {
                swap(nums, odd, even);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.sort_array_by_parity_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void givenArray_whenSortByParity_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 2, 5, 7}, new int[]{4, 5, 2, 7}),
                () -> test(new int[]{2, 3}, new int[]{2, 3})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.sortArrayByParityII(given);

        // then
        for (int i = 0; i < actual.length; i++) {
            assertTrue((i & 1) == 0 ?
                    (actual[i] & 1) == 0 :
                    (actual[i] & 1) == 1);
        }
    }
}
```