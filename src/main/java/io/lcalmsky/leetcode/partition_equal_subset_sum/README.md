> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/partition_equal_subset_sum/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/partition-equal-subset-sum/) 있습니다.

## Problem

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

**Example 1:**

```text
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
```

**Example 2:**

```text
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
```

**Constraints:**

* 1 <= nums.length <= 200
* 1 <= nums[i] <= 100

## Solution

양의 정수로 이루어진 배열이 주어질 때 합이 같은 두 개의 부분집합으로 나눌 수 있는지 확인하는 문제입니다.

```java
public class Solution {

  public boolean canPartition(int[] nums) {
    if (nums == null || nums.length < 2) {
      return false;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) { // (1)
      return false;
    }
    sum /= 2;
    boolean[] dp = new boolean[sum + 1]; // (2)
    dp[0] = true; // (3)
    for (int i = 1; i < nums.length; i++) {
      int current = nums[i - 1];
      for (int j = sum; j >= current; j--) {
        dp[j] |= dp[j - current]; // (4)
      }
    }
    return dp[sum];
  }
}
```

1. 배열의 합이 홀수이면 합이 같은 두 부분 배열로 나눌 수 없습니다.
2. 합이 같은 두 부분 배열로 나누기 위해선 배열의 전체 합을 2로 나눈 값을 합으로 가지는 두 배열을 만들어야 하므로 DP 배열의 길이를 합의 절반으로 설정합니다.
3. 초기 값을 설정합니다.
4. 부분 배열의 합이 되어야 할 값부터 출발하여 현재 인덱스에 해당하는 값까지 1씩 줄여주면서 반복합니다. j번째 값이 j에서 current만큼 뺐을 때 0이 되면 sum을 만들 수 있다는 뜻인데요, 그 이유를 1번 예제를 이용해 설명하겠습니다.  
```text
sum = (1 + 5 + 11 + 5) / 2 = 11

i = 1:
current = 1 (nums의 0번째 값)
j = 11 ~ 1:
dp[11] = dp[11] || dp[10] = false;
dp[10] = dp[10] || dp[9] = false;
dp[9] = dp[9] || dp[8] = false;
...
dp[1] = dp[1] || dp[0] = true;

현재까지 DP 배열
[true, true, false, false, false, false, false, false, false, false, false, false]

i = 2:
current = 5 (nums의 1번째 값)
j = 11 ~ 5
dp[11] = dp[11] || dp[6] = false;
dp[10] = dp[10] || dp[5] = false;
dp[9] = dp[9] || dp[4] = false;
dp[8] = dp[8] || dp[3] = false;
dp[7] = dp[7] || dp[2] = false;
dp[6] = dp[6] || dp[1] = true;
dp[5] = dp[5] || dp[0] = true;

현재까지 DP 배열
[true, true, false, false, false, true, true, false, false, false, false, false]

i = 3:
current = 11 (nums의 2번째 값)
j = 11
dp[11] = dp[11] || dp[0] = true;

현재까지 DP 배열
[true, true, false, false, false, true, true, false, false, false, false, true]
```

## Test

```java
package io.lcalmsky.leetcode.partition_equal_subset_sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenSumSubsets_thenEqualsPartition() {
    assertAll(
        () -> test(new int[]{1, 5, 11, 5}, true),
        () -> test(new int[]{1, 2, 3, 4, 5}, false)
    );
  }

  private void test(int[] given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.canPartition(given);

    // then
    assertEquals(expected, actual);
  }
}
```