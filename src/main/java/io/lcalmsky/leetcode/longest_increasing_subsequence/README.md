> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/longest_increasing_subsequence/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/longest-increasing-subsequence/) 있습니다.

## Problem

Given an integer array nums, return the length of the longest strictly increasing subsequence.

**Example 1:**

```text
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```

**Example 2:**

```text
Input: nums = [0,1,0,3,2,3]
Output: 4
```

**Example 3:**

```text
Input: nums = [7,7,7,7,7,7,7]
Output: 1
```

**Constraints:**

* 1 <= nums.length <= 2500
* -10^4 <= nums[i] <= 10^4

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

## Solution

주어진 정수 배열에서 가장 긴 증가하는 부분 수열의 길이를 찾는 문제입니다.

먼저 dp를 이용한 방법이 있습니다.

```java
package io.lcalmsky.leetcode.longest_increasing_subsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}

```

주어진 배열의 길이와 같은 길이를 갖는 배열 dp를 생성하고, 모든 원소를 1로 초기화합니다. dp[i]는 인덱스 i까지의 가장 긴 증가하는 부분 수열의 길이를 나타냅니다.

그리고 최대 길이를 저장할 변수 max를 1로 초기화합니다.

이제 배열의 각 원소에 대해 두 개의 반복문을 사용하여 모든 가능한 증가하는 부분 수열의 길이를 계산합니다.

바깥쪽 반복문에서는 인덱스 i를 0부터 배열의 끝까지 증가시킵니다. 이는 현재 원소를 기준으로 증가하는 부분 수열의 길이를 계산하기 위함입니다.

안쪽 반복문에서는 인덱스 j를 0부터 i 직전까지 증가시킵니다. 이는 현재 원소보다 작은 이전 원소들을 확인하기 위함입니다.

만약 nums[j]가 nums[i]보다 작은 경우, 이는 증가하는 부분 수열에 새로운 원소를 추가할 수 있는 경우입니다. 따라서 dp[i]와 dp[j] + 1 중 더 큰 값을 선택하여 dp[i]를 업데이트합니다. 여기서 dp[j] + 1은 이전에 만들어진 가장 긴 증가하는 부분 수열에 현재 원소를 추가한 길이입니다.

매번 dp[i]를 업데이트할 때마다 max와 비교하여 최대 길이를 갱신합니다.

모든 반복이 완료된 후, max를 반환합니다. 이는 주어진 배열에서 가장 긴 증가하는 부분 수열의 길이를 나타냅니다.

이 방법은 시간복잡도가 O(n^2) 이므로 문제의 follow up에서 요구하는 O(n log(n))을 만족하려면 다른 방법을 사용해야 합니다.

O(log(n))하면 떠오르는 이진 탐색을 활용해 볼 수 있습니다.

```java
package io.lcalmsky.leetcode.longest_increasing_subsequence;

public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int left = 0, right = size;
            while (left != right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}

```

먼저, 배열 tails를 생성하여 부분 수열을 저장할 배열로 사용합니다. tails 배열의 인덱스는 부분 수열의 길이를 나타내며, 해당 인덱스에는 해당 길이의 부분 수열에서 가장 작은 값이 저장됩니다.

또한, 변수 size를 생성하여 현재까지 구해진 가장 긴 증가하는 부분 수열의 길이를 나타냅니다. 초기값은 0으로 설정합니다.

그 후, 주어진 배열 nums를 순회하면서 각 원소를 처리합니다.

반복문 안에서는 이진 탐색을 통해 현재 원소를 삽입할 위치를 찾습니다. 이진 탐색을 위해 변수 left와 right를 사용합니다. left는 부분 수열의 시작 인덱스를 나타내고, right는 부분 수열의 끝 다음 인덱스를 나타냅니다.

이진 탐색을 수행하는 동안 left와 right가 같아질 때까지 반복합니다. 반복문 안에서는 현재 부분 수열의 중간 위치를 나타내는 변수 mid를 계산하고, tails[mid]와 현재 원소를 비교하여 left와 right를 갱신합니다.

tails[mid] < num인 경우, 중간 위치의 값보다 현재 원소가 더 크므로 오른쪽 범위로 이동하여 탐색을 계속합니다. 그렇지 않은 경우, 왼쪽 범위로 이동하여 탐색을 계속합니다.

이진 탐색이 종료되면 left는 현재 원소를 삽입할 위치를 나타냅니다. 따라서 tails[left]에 현재 원소를 저장합니다.

그리고 만약 left가 현재까지 구해진 부분 수열의 길이인 size와 같다면, 현재 원소는 가장 긴 부분 수열에 새로운 값으로 추가되는 것이므로 size를 1 증가시킵니다.

배열 nums의 모든 원소에 대한 반복이 완료되면, size를 반환하여 가장 긴 증가하는 부분 수열의 길이를 얻습니다.

## Test

```java
package io.lcalmsky.leetcode.longest_increasing_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
                () -> test(new int[]{0, 1, 0, 3, 2, 3}, 4),
                () -> test(new int[]{7, 7, 7, 7, 7, 7, 7}, 1)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.lengthOfLIS(nums);
        // then
        assertEquals(expected, actual);
    }
}
```