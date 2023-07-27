> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/max_consecutive_ones_iii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/max-consecutive-ones-iii/) 있습니다.

## Problem

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

**Example 1:**

```text
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
```

**Example 2:**

```text
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
```

**Constraints:**

* 1 <= nums.length <= 10^5
* nums[i] is either 0 or 1.
* 0 <= k <= nums.length

## Solution

0과 1로 이루어진 배열에서 최대 k개의 0을 1로 바꿔서 얻을 수 있는 연속된 1의 가장 긴 길이를 구하는 문제입니다.

```java
package io.lcalmsky.leetcode.max_consecutive_ones_iii;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, zeroes = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroes++;
            }
            end++;
            if (zeroes > k) {
                if (nums[start] == 0) {
                    zeroes--;
                }
                start++;
            }
        }
        return end - start;
    }
}

```

1. int start = 0, end = 0, zeroes = 0;: 슬라이딩 윈도우를 위한 포인터 변수들을 초기화합니다. start는 윈도우의 시작 인덱스를 가리키고, end는 윈도우의 끝 인덱스를 가리키며, zeroes는 현재 윈도우 내에 있는 0의 개수를 저장합니다.
1. while (end < nums.length): end 포인터가 배열의 끝에 도달할 때까지 반복합니다. 이렇게 함으로써 모든 윈도우를 순회하면서 최대 길이를 구합니다.
1. if (nums[end] == 0): 현재 원소가 0인 경우, zeroes를 증가시킵니다.
1. end++;: end 포인터를 오른쪽으로 이동하여 윈도우를 확장합니다.
1. if (zeroes > k): 윈도우 내에 있는 0의 개수가 최대 허용 개수 k를 초과하는 경우를 처리합니다.
1. if (nums[start] == 0): start 포인터가 가리키는 원소가 0인 경우, 윈도우 내의 0 개수를 감소시킵니다. 이렇게 함으로써 윈도우를 왼쪽으로 이동하여 길이를 줄입니다.
1. start++;: start 포인터를 오른쪽으로 이동하여 윈도우를 축소합니다.
1. 최종적으로 end - start를 반환합니다. 이 값은 최대 k개의 0을 1로 바꿔서 얻을 수 있는 연속된 1의 가장 긴 길이가 됩니다.

이 코드는 슬라이딩 윈도우를 사용하여 최대 k개의 0을 1로 바꿔서 얻을 수 있는 연속된 1의 최대 길이를 효율적으로 계산합니다. 시간 복잡도는 O(N)입니다. 여기서 N은 배열 nums의 길이입니다.

## Test

```java
package io.lcalmsky.leetcode.max_consecutive_ones_iii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6),
                () -> test(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10)
        );

    }

    private void test(int[] nums, int k, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.longestOnes(nums, k);
        // then
        assertEquals(expected, actual);
    }

}
```