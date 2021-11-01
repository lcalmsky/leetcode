> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/_3sum/Solution.java) 있습니다.
> 문제는 [여기](https://leetcode.com/problems/3sum/) 있습니다.

## Problem

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

**Example 1:**

```text
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

**Example 2:**

```text
Input: nums = []
Output: []
```

**Example 3:**

```text
Input: nums = [0]
Output: []
```

**Constraints:**

* 0 <= nums.length <= 3000
* -10^5 <= nums[i] <= 10^5

## Solution

주어진 배열의 세 개의 숫자를 더해 0을 만들 수 있는 모든 부분 집합을 반환하는 문제입니다.

배열을 정렬한 뒤 세 개의 포인터를 이용해 합이 0이 되는 원소들을 구합니다.

현재 위치를 나타내는 포인터 하나와, 현재 포인터 이후로 가장 작은 값, 가장 큰 값을 나타내는 포인터 이렇게 총 세 개 입니다.

배열을 순차적으로 탐색하면서 현재 값, 가장 작은 값, 가장 큰 값을 더해 0이 될 때 리스트에 추가하고, 0보다 작으면 가장 작은 값을 가리키는 포인터를 이동시키고, 0보다 크면 가장 큰 값을 가리키는 포인터를 이동시켜 0이 되는 모든 부분 집합을 구합니다.

0이 되었을 경우에도 중복된 답을 방지하기 위해 가장 작은 값, 가장 큰 값을 가리키는 포인터가 기존 값과 동일한 경우 추가로 더 이동시켜 줍니다.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum < 0) {
                    low++;
                    continue;
                }
                if (sum > 0) {
                    high--;
                    continue;
                }
                result.add(List.of(nums[i], nums[low], nums[high]));
                while (low < high && low + 1 < nums.length && nums[low + 1] == nums[low]) {
                    low++;
                }
                while (low < high && high - 1 >= 0 && nums[high - 1] == nums[high]) {
                    high--;
                }
                low++;
                high--;
            }
        }
        return result;
    }
}

```

## Test

```java
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("주어진 배열에서 세 개의 원소를 더해 0을 만드는 모든 부분 배열을 구한다.")
    void test() {
        assertAll(
            () -> test(new int[]{-1, 0, 1, 2, -1, 4},
                List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))),
            () -> test(new int[]{}, Collections.emptyList()),
            () -> test(new int[]{0}, Collections.emptyList())
        );
    }

    private void test(int[] given, List<List<Integer>> expected) {
        // when
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.threeSum(given);

        // then
        assertEquals(expected, actual);
    }
}
```