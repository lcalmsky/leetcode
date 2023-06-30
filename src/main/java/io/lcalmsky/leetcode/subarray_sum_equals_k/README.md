> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/sub_array_equals_k/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/sub-array-equals-k/) 있습니다.

## Problem

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

**Example 1:**
```text
Input: nums = [1,1,1], k = 2
Output: 2
```
**Example 2:**
```text
Input: nums = [1,2,3], k = 3
Output: 2
```

**Constraints:**

* 1 <= nums.length <= 2 * 10^4
* -1000 <= nums[i] <= 1000
* -10^7 <= k <= 10^7

## Solution

정수 배열과 정수 k가 주어질 때 연속된 부분 배열의 합이 k가 되는 개수를 반환하는 문제입니다.

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    int count = 0;
    for (int num : nums) {
      sum += num;
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}

```

1. 초기값을 0일 때 1로 설정합니다. 맵에서 Key는 **부분 배열의 합 - k**를 나타내고, Value는 Key에 해당하는 카운트 값입니다.
2. 배열의 원소들을 순차적으로 더해줍니다.
3. 더한 값에서 k를 뺀 값이 맵의 Key로 존재하면 해당 Value를 카운트에 더해줍니다. sum은 배열이 끝날 때까지 순서대로 더해지기 때문에 k로 뺀 값에 해당하는 key가 존재한다는 것은 이미 이전에 더해서 그 값을 만들 수 있었다는 것이므로 그 이후부터 더해서 k를 만들 수 있음을 의미합니다.
4. 합을 Key로 가지는 개수를 증가시킵니다.

3번에 대해 부연설명 하자면 배열이 [1, 1, 2, 1, 1]으로 주어지고 k는 3일 때, 배열의 인덱스를 i라고 할 때 반복문을 돌면서 채워지는 값들은 아래와 같습니다.
```text
i = 0:
  sum = 1
  sum - k = -2
  map = {-2, 1}, {1, 1}
i = 1:
  sum = 2
  sum - k = -1
  map = {-2, 1}, {1, 1}, {2, 1}
i = 2:
  sum = 4
  sum - k = 1
  count = 1
  map = {-2, 1}, {1, 1}, {2, 1}, {4, 1}
i = 3:
  sum = 5
  sum - k = 2
  count = 2
  map = {-2, 1}, {1, 1}, {2, 1}, {4, 1}, {5, 1}
i = 4:
  sum = 6
  sum - k = 5
  map = {-2, 1}, {1, 1}, {2, 1}, {4, 1}, {5, 1}, {6, 1}
```

i가 2, 3일 때 각각 카운트가 올라간 것을 확인할 수 있는데,

i가 2일 때 1 + 1 + 2이므로 4이고, k를 빼면 4 - 3 = 1이 되지만, 앞서서 i가 0일 때 합 1을 맵에 저장해두었으므로 배열의 0번째를 제외한 부분부터 더했을 때 3이 됨을 알 수 있습니다. (1 + 1 + 2 - 1 = 3)   

i가 3일 때도 마찬가지로 합은 5가 되지만 앞에 두 원소의 합인 2가 맵에 저장되어있으므로 그 이후 인덱스부터의 합이 다시 3이 됩니다.

---

이 코드는 배열에서 부분 배열의 합이 주어진 값인 k와 동일한 경우의 수를 계산하는 알고리즘입니다. 이를 구현하기 위해 "누적합"과 "map"을 사용합니다.

먼저, 해시 map은 누적합(sum)과 해당 누적합의 등장 횟수를 저장합니다. 초기에 map에 (0, 1)을 추가함으로써 누적합이 0인 경우를 처리합니다.

그런 다음, 배열 nums를 반복하면서 각 요소 num을 누적합에 추가하고, 이전 누적합과의 차이인 diff를 계산합니다. diff가 map에 존재한다면, 이전에 등장한 누적합에서 현재 누적합을 뺀 값이 k와 동일한 부분 배열이 존재하는 것이므로, count에 해당 diff의 등장 횟수를 추가합니다.

마지막으로, 현재 누적합(sum)과 그 등장 횟수를 map에 업데이트합니다.

모든 요소에 대해 반복이 완료되면 count를 반환하여 부분 배열의 합이 k와 동일한 경우의 수를 구합니다.

## Test

```java
package io.lcalmsky.leetcode.subarray_sum_equals_k;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 1}, 2, 2),
        () -> test(new int[]{1, 2, 3}, 3, 2)
    );
  }

  private void test(int[] given, int k, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.subarraySum(given, k);
    // then
    assertEquals(expected, actual);
  }
}
```