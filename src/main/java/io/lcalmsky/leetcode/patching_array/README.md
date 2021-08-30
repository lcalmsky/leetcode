> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/patching_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3956/) 있습니다.  

## Problem
Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.

Return the minimum number of patches required.

**Example 1:**

```text
Input: nums = [1,3], n = 6
Output: 1
Explanation:
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.
```

**Example 2:**

```text
Input: nums = [1,5,10], n = 20
Output: 2
Explanation: The two patches can be [2, 4].
```

**Example 3:**

```text
Input: nums = [1,2,2], n = 5
Output: 0
```

**Constraints:**

* 1 <= nums.length <= 1000
* 1 <= nums[i] <= 10^4
* nums is sorted in ascending order.
* 1 <= n <= 2^31 - 1

## Solution

주어진 정수 배열에 숫자를 추가하거나 수정해서, 그 배열의 숫자들 중 일부(또는 전체)를 더해, 1부터 N까지 수를 구성할 수 있게하는 최소로 필요한 정수 갯수를 구하는 문제입니다.

예제 1 처럼 n이 6인 경우 `1, 2, 3, 4, 5, 6`을 모두 구성할 수 있는 배열로 만들어야하고 주어진 배열은 [1, 3] 이기 때문에 2 하나만 추가해주면 [1], [2], [3], [1, 3], [2, 3], [1, 2, 3]으로 1~6을 구성할 수 있습니다.

1보다 크고 N보다 작은 K가 존재한다고 가정하고, 여기서 주어진 숫자 N이 1부터 K까지의 수를 모두 더한 수의 합일 경우 답은 단순하게 구할 수 있습니다. 예를 들어, N이 1인 경우 [1]만 있으면 되고, 3인 경우 [1, 2], 6인 경우 [1, 2, 3], 10인 경우 [1, 2, 3, 4] 이런 식으로 말이죠.

반면에 N이 다른 수 일 경우 일부 숫자를 중복시키거나 숫자를 추가하지 않고도 조합 가능할 수도 있습니다. 예를 들어 N이 2인 경우 [1, 1] 이렇게 1이 중복되어야 하고, N이 5인 경우 [1, 2, 3] 또는 [1, 2, 2]로 [1, 2, 3, 4, 5]를 표현할 수 있습니다.

하지만 이 경우도 잘 살펴보시면 1부터 K까지의 합이 N인 경우인 경우보다 원소의 갯수가 더 필요하진 않습니다.

* _**N이 1일 때 필요한 원소 갯수: 1 (1)**_
* N이 2일 때 필요한 원소 갯수: 2 (1, 1) or (1, 2)
* _**N이 3일 때 필요한 원소 갯수: 2 (1, 2)**_
* N이 4일 때 필요한 원소 갯수: 3 (1, 2, 2)
* N이 5일 때 필요한 원소 갯수: 3 (1, 2, 2) or (1, 2, 3)
* _**N이 6일 때 필요한 원소 갯수: 3 (1, 2, 3)**_
* N이 7일 때 필요한 원소 갯수: 4 (1, 2, 3, 4), (1, 2, 2, 3), (1, 1, 2, 3) 등
* N이 8일 때 필요한 원소 갯수: 4 // 생략
* N이 9일 때 필요한 원소 갯수: 4 // 생략
* _**N이 10일 때 필요한 원소 갯수: 4 (1, 2, 3, 4)**_

이러한 원리로 주어진 배열로 1부터 N까지의 수를 구성하기 위해 필요한 정수 갯수를 찾을 수 있습니다.

이론적으로는 쉽지만 주어진 배열이 이상할 경우엔 저렇게 단순하게 파악할 수가 없습니다. 예를 들어 주어진 배열은 [100, 200]인데 N이 3인 경우 결국 [1, 2]를 추가해줘야 하죠.

따라서 주어진 배열에 숫자들과 크기 비교도 포함되어야 합니다.

```java
public class Solution {
    public int minPatches(int[] nums, int n) {
        long misses = 1; // (1)
        int count = 0, position = 0;
        while (misses <= n) { // (2)
            if (position < nums.length && misses >= nums[position]) { // (3)
                misses += nums[position++];
            } else { // (4)
                misses *= 2;
                count++;
            }
        }
        return count;
    }
}
```

> (1) misses는 누락될 수 있는 숫자입니다.  
> (2) 배열을 탐색하며 각 자리의 숫자보다 misses가 더 큰 경우, 이 숫자를 구성할 수 있음을 의미하므로 해당 숫자를 더해 misses의 범위를 확장합니다.  
> (3) 그렇지 않은 경우 misses에 두 배를 곱해 범위를 확장합니다. 두 배로 확장하는 경우 기존 숫자들로는 구성이 불가능하므로 반드시 하나의 숫자가 추가되어야 하기 때문에 count의 값을 올려줍니다.

위에 알고리즘을 예제 2번으로 설명하자면, [1, 5, 10]이 있고 N이 20일때 1부터 20까지의 수를 구성할 수 있어야 하는데, 이 때 누락된 수인지 순차적으로 확인합니다.

```text
misses = 1, nums[0] = 1, count = 0:
  먼저 1부터 확인을 하는데 1은 배열에 포함되어 있으므로 더해줍니다.
misses = 2, nums[1] = 5, count = 0:
  다음은 2를 확인하는데 비교 대상이 5입니다. 5보다 작으므로 misses를 두 배 곱해주고 count를 1 올려줍니다.
misses = 4, nums[1] = 5, count = 1:
  다음도 마찬가지로 4를 확인하는데 5보다 작으므로 두 배 곱해주고 count를 1 올려줍니다.
misses = 8, nums[1] = 5, count = 2:
  8은 5보다 크므로 5를 더해줍니다.
misses = 13, nums[2] = 10, count = 2:
  13은 10보다 크므로 10을 더해줍니다.
배열을 모두 탐색했으므로 반복문을 빠져나가 count를 반환합니다.
```

마지막에 misses가 23이 되면서 1부터 23미만까지(22) 커버할 수 있게 되었습니다. 기존 배열의 원소들을 포함하기 때문에 효율적으로 20까지 딱 맞춘 게 아니라 범위가 오버되었지만 최소한의 갯수를 포함하면서 나머지 숫자들을 모두 커버할 수 있게 되었습니다.

실제로 추가된 수는 [2, 4] 입니다.

## Test

```java
package io.lcalmsky.leetcode.patching_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenArray_whenAddOrPatchSomeIntegers_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3}, 6, 1),
                () -> test(new int[]{1, 5, 10}, 20, 2),
                () -> test(new int[]{1, 2, 2}, 5, 0)
        );
    }

    private void test(int[] givenArray, int givenNumber, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.minPatches(givenArray, givenNumber);

        // then
        assertEquals(expected, actual);
    }
}
```