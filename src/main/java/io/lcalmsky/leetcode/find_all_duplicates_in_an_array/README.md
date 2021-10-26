> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_all_duplicates_in_an_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-all-duplicates-in-an-array/) 있습니다.

## Problem

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

**Example 1:**

```text
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
```

**Example 2:**

```text
Input: nums = [1,1,2]
Output: [1]
```

**Example 3:**

```text
Input: nums = [1]
Output: []
```

**Constraints:**

* n == nums.length
* 1 <= n <= 10^5
* 1 <= nums[i] <= n
* Each element in nums appears once or twice.

## Solution

정수 배열이 주어졌을 때 중복 값을 찾아 반환하는 문제입니다.

정수는 한 번 또는 두 번만 나타나고 시간복잡도 O(n), 상수 범위 내의 추가 메모리를 사용하여 문제를 해결하라고 되어있습니다.

제한조건 때문에 추가로 배열을 사용하거나 맵 등의 자료구조 사용이 불가능하므로 머리를 잘 굴려야하는 문제입니다.

배열의 크기가 N일 때 배열을 구성하는 숫자들은 1~N까지인 조건을 잘 활용하면 추가적인 메모리를 사용하지 않고 중복임을 체크할 수 있습니다.

배열을 구성하는 숫자의 범위에서 1을 빼면 0~N-1로 배열의 인덱스의 범위라고 생각할 수 있습니다.

어떤 수가 있을 때 그 수를 인덱스로 가지는 곳의 부호를 바꿔주고, 다음 번에 그 인덱스에 방문하게 되면 중복임을 확인할 수 있습니다.

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) { // (2)
                result.add(Math.abs(nums[i]));
            } else { // (1)
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return result;
    }
}
```

알고리즘을 이해를 돕기위해 (1), (2) 순서를 소스 코드 순서와 상관없이 적었습니다.

(1) 배열을 순차적으로 탐색하는데 현재 인덱스에 해당하는 값을 인덱스로 가지는(정확히는 해당하는 값에서 1을 빼줘야 함) 값을 음수로 만들어줍니다. 예를 들어, nums[i]가 1일 경우엔 배열의 첫 번 째 값을 음수로 만들어줍니다.  
(2) 현재 인덱스에 해당하는 값을 절대값을 취해 배열에서 몇 번 째 인지 구하고, 그 값이 이미 음수일 경우 결과 리스트에 추가해줍니다. 예를 들어 nums[i]가 또 1인 경우 배열의 첫번째 값을 확인해야하고 (1)번에서 음수로 바꿔줬기 때문에 결과 리스트에 추가하게 됩니다. 실제로 배열에는 1이 두 개 들어있는 것이기 때문에 중복값을 이런식으로 확인해나갈 수 있습니다.

---

정답을 제출하고 보니 제약사항을 굳이 지키지 않아도 통과되는 것을 확인할 수 있었습니다. 추가 공간을 사용할 경우 훨씬 더 간단히 풀 수 있으므로 따로 풀이를 추가하진 않겠습니다. 

## Test

```java
package io.lcalmsky.leetcode.find_all_duplicates_in_an_array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void givenArray_whenFindDuplicates_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, Arrays.asList(2, 3)),
                () -> test(new int[]{1, 1, 2}, List.of(1)),
                () -> test(new int[]{1}, Collections.emptyList())
        );
    }

    private void test(int[] given, List<Integer> expected) {
        // when
        Solution findAllDuplicatesInAnArray = new Solution();
        List<Integer> actual = findAllDuplicatesInAnArray.findDuplicates(given);

        // then
        assertEquals(expected, actual);
    }
}
```