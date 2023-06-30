> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximum_product_subarray/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximum-product-subarray/) 있습니다.

## Problem

Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

**Example 1:**
```text
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
```

**Example 2:**

```text
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
```

Constraints:

* 1 <= nums.length <= 2 * 10^4
* -10 <= nums[i] <= 10
* The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

## Solution

정수 배열이 주어졌을 때 부분 배열의 곱이 최대가 되는 값을 반환하는 문제입니다.

DP를 이용해 최대가 나오는 경우, 최소가 나오는 경우를 분리해 이전 결과와 비교하여 값을 계산해 나가면 됩니다.

음수의 곱은 한 번 곱해질 땐 음수지만 두 번째 곱해질 땐 양수가 되는 점을 이용하여, 최솟값을 따로 저장하고 있어야 향후 음수가 한 번 더 등장했을 때 더 높은 값을 만들어 낼 가능성이 있습니다.

이 부분만 고민하면 아주 간단히 풀리는 문제입니다.

```java
package io.lcalmsky.leetcode.maximum_product_subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = min[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num > 0) {
                max[i] = Math.max(num, max[i - 1] * num);
                min[i] = Math.min(num, min[i - 1] * num);
            } else {
                max[i] = Math.max(num, min[i - 1] * num);
                min[i] = Math.min(num, max[i - 1] * num);
            }
            result = Math.max(result, max[i]);
        }

        return result;
    }
}

```

## Test

```java
package io.lcalmsky.leetcode.maximum_product_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test() {
        assertAll(
                () -> test(new int[]{2, 3, -2, 4}, 6),
                () -> test(new int[]{-2, 0, -1}, 0)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxProduct(nums);
        // then
        assertEquals(expected, actual);
    }
}
```