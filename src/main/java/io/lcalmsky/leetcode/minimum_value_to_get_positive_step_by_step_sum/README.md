> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/minimum_value_to_get_positive_step_by_step_sum/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/submissions/) 있습니다.

## Problem

Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.

**Example 1:**

```text
Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
(4 -3 ) = 1  | (5 -3 ) = 2    |  -3
(1 +2 ) = 3  | (2 +2 ) = 4    |   2
(3 -3 ) = 0  | (4 -3 ) = 1    |  -3
(0 +4 ) = 4  | (1 +4 ) = 5    |   4
(4 +2 ) = 6  | (5 +2 ) = 7    |   2
```

**Example 2:**

```text
Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive.
```

**Example 3:**

```text
Input: nums = [1,-2,-3]
Output: 5
```

**Constraints:**

* 1 <= nums.length <= 100
* -100 <= nums[i] <= 100

## Solution

초기 값을 설정하고 주어진 배열을 순차적으로 탐색하면서 더하는 동안 합이 0이하로 떨어지지 않게 하는 최소한의 양수 값을 구하는 문제입니다.

초기 값은 양수 중 가장 작은 수인 1부터 설정 가능합니다.

배열을 탐색하면서 더하는 동안 음수가 포함되어 있을 경우 합이 음수가 될 수도있지만 사전에 양수를 먼저 더했을 경우엔 그렇지 않을 수도 있음을 주의하고 풀어야 합니다.

풀이 방법은 순차적으로 더하는 동안 가장 낮은 값이 되었을 때를 따로 저장했다가 절대값을 취한 뒤 1을 더해주면 됩니다.

그렇게 하기 위해선 현재 합계와 가장 낮은 합계를 따로 관리해야 합니다.

가장 낮은 합계는 한 번도 0이하로 내려가지 않을 수 있기 때문에(모두 양수인 경우) 초기값을 0으로 설정해야 마지막에 1이 더해져도 정답 조건을 만족시킬 수 있습니다.

```java
public class Solution {

  public int minStartValue(int[] nums) {
    int lowestSum = 0;
    int sum = 0;
    for (int num : nums) {
      sum += num;
      lowestSum = Math.min(sum, lowestSum);
    }
    return Math.abs(lowestSum) + 1;
  }
}
```

## Test
