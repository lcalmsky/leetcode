> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/max_number_of_k_sum_pairs/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/max-number-of-k-sum-pairs/) 있습니다.

## Problem

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

**Example 1:**
```text
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
  There are no more pairs that sum up to 5, hence a total of 2 operations.
```
**Example 2:**
```text
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
  There are no more pairs that sum up to 6, hence a total of 1 operation.
```

**Constraints:**

* 1 <= nums.length <= 10^5
* 1 <= nums[i] <= 10^9
* 1 <= k <= 10^9

## Solution

정수 배열과 정수 k가 주어질 때 배열에서 합이 k가 되는 두 개의 정수를 골라서 제거할 수 있습니다.

이 동작을 최대로 수행했을 때의 횟수를 반환하는 문제입니다.

먼저 Map을 이용해 풀이하는 방법입니다.

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int maxOperations(int[] nums, int k) {
    int operations = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) { // (1)
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // (2)
      int key = entry.getKey();
      if (key > (k / 2)) { // (3)
        continue;
      }
      int value = entry.getValue(); // (4)
      int remain = k - key; // (5)
      if (key == remain) { // (6)
        operations += (value / 2);
        continue;
      }
      Integer pairCount = map.get(remain); // (7)
      if (pairCount != null) {
        operations += Math.min(value, pairCount);
      }
    }
    return operations;
  }
}
```

1. 배열을 탐색하면서 각 정수를 키로, 개수를 값으로 맵에 저장합니다.
2. 맵을 탐색하면서
3. 키가 정수 k의 반보다 클 경우 아무 것도 하지 않습니다. 그 이유는 계속 진행하게 되면 앞에서 계산에 사용했던 키를 중복으로 사용하게 되기 때문입니다. 이 부분은 for문이나 while문을 이용해 조건으로 반복을 제어해도 됩니다.
4. 현재 정수의 개수를 획득합니다.
5. 현재 정수와 더해서 k가 되는 값을 구합니다.
6. 현재 정수와 더해서 k가 되는 값이 같은 경우 해당 수를 두 번 더하면 k가 되므로 현재 정수의 개수를 2로 나눈 값을 operation 횟수에 더해줍니다.
7. 현재 정수와 더해서 k가 되는 값이 존재할 경우, 현재 정수의 개수와 더해서 k가 되는 정수의 개수 중 더 적은 값을 operation 횟수에 더해줍니다. 두 개가 짝을 이뤄 k가 되기 때문입니다.

---

다음은 두 개의 포인터를 이용한 방법입니다.

```java
package io.lcalmsky.leetcode.max_number_of_k_sum_pairs;

import java.util.Arrays;

class Solution extends Solution {

  public int maxOperations(int[] nums, int k) {
    Arrays.sort(nums); // (1)
    int left = 0;
    int right = nums.length - 1;
    int operations = 0;
    while (left < right) { // (2)
      int sum = nums[left] + nums[right]; // (3)
      if (sum == k) { // (4)
        operations++;
        left++;
        right--;
      } else if (sum > k) { // (5)
        right--;
      } else { // (6)
        left++;
      }
    }
    return operations;
  }
}

```

1. 배열을 정렬합니다.
2. 왼쪽 포인터가 가리키는 값이 오른쪽 포인터가 가리키는 값보다 작을 동안 반복합니다.
3. 각 포인터가 가리키는 값의 합을 구합니다.
4. 합이 k와 일치하는 경우 operation 횟수를 증가시키고 왼쪽 포인터를 오른쪽으로, 오른쪽 포인터를 왼쪽으로 이동시킵니다.
5. 합이 k보다 큰 경우 오른쪽 포인터만 왼쪽으로 이동시킵니다.
6. 합이 k보다 작은 경우 왼쪽 포인터만 오른쪽으로 이동시킵니다.

## Test

```java
package io.lcalmsky.leetcode.max_number_of_k_sum_pairs;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4}, 5, 2),
        () -> test(new int[]{3, 1, 3, 4, 3}, 6, 1)
    );
  }

  private void test(int[] given, int k, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxOperations(given, k);
    // then
    assertEquals(expected, actual);
  }
}
```