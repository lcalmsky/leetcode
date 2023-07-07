> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/product_of_array_except_self/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/product-of-array-except-self/) 있습니다.

## Problem

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

**Example 1:**
```text
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

**Example 2:**
```text
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```

**Constraints:**

* 2 <= nums.length <= 10^5
* -30 <= nums[i] <= 30
* The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

**Follow up:** Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

## Solution

주어진 정수 배열 nums의 각 원소를 제외한 나머지 원소들의 곱을 계산하는 문제입니다.

나눗셈을 이용할 수 없고 시간 복잡도 O(n)으로 문제를 해결해야 합니다.

```java
package io.lcalmsky.leetcode.product_of_array_except_self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length]; // 1
        result[nums.length - 1] = 1; // 2
        for (int i = nums.length - 2; i >= 0; i--) { // 3
            result[i] = result[i + 1] * nums[i + 1];
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) { // 4
            result[i] = result[i] * left;
            left = left * nums[i];
        }
        return result; // 5
    }
}
```

1. 결과를 저장할 result 배열을 생성합니다. 이 배열의 크기는 nums 배열과 동일합니다.
2. result 배열의 마지막 원소를 1로 초기화합니다. 이는 마지막 원소를 제외한 다른 모든 원소의 곱이 1이라는 의미입니다.
3. 역방향으로 nums 배열을 순회하면서 result 배열을 업데이트합니다. 현재 인덱스 i에 대해, result[i]에는 result[i+1]에 현재 원소 nums[i+1]를 곱한 값을 저장합니다. 이를 통해 result 배열에는 현재 원소를 제외한 오른쪽의 원소들의 곱이 저장되게 됩니다.
4. 왼쪽부터 순회하면서 result 배열과 nums 배열을 곱하여 결과를 계산합니다. result[i]에는 이전까지의 오른쪽 원소들의 곱과 왼쪽 원소들의 곱을 곱한 값이 저장됩니다. 이를 위해 left 변수를 사용하여 왼쪽 원소들의 곱을 계속해서 업데이트합니다.
5. result 배열을 반환합니다. 이 배열에는 각 원소를 제외한 나머지 원소들의 곱이 저장되어 있습니다.

이 알고리즘은 두 번의 배열 순회를 통해 원소들의 곱을 계산하므로 시간 복잡도는 O(n)입니다. 따라서 주어진 문제의 요구사항인 O(n)의 런타임 복잡도를 만족합니다.

조금 더 가독성 좋은 풀이 방법입니다.

```java
package io.lcalmsky.leetcode.product_of_array_except_self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, temp = 1; i < nums.length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        for (int i = nums.length - 1, temp = 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}
```

풀이 과정은 동일합니다.

## Test

```java
package io.lcalmsky.leetcode.product_of_array_except_self;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                () -> test(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );
    }

    private void test(int[] nums, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.productExceptSelf(nums);
        // then
        assertArrayEquals(expected, actual);
    }
}

```