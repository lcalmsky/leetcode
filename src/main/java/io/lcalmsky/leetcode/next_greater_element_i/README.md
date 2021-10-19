> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/next_greater_element_i/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/next-greater-element-i/) 있습니다.

## Problem

The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

**Example 1:**

```text
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
```

**Example 2:**

```text
Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
```

**Constraints:**

* 1 <= nums1.length <= nums2.length <= 1000
* 0 <= nums1[i], nums2[i] <= 10^4
* All integers in nums1 and nums2 are unique.
* All the integers of nums1 also appear in nums2.

**Follow up:** Could you find an O(nums1.length + nums2.length) solution?

## Solution

`next greater element`는 배열 내에서 특정 `element`의 우측에 존재하는 `element`중 `x` 가장 처음 나타나는 x보다 큰 값 입니다.

두 개의 배열이 주어졌을 때 첫 번 째 배열에 대해 `next greater element`를 구하는 문제입니다.

첫 번 째 배열은 두 번 째 배열의 부분 배열이고 `next greater element`가 존재하지 않으면 -1로 나타냅니다.

먼저 가장 간단한 방법으로 풀어보았습니다.

첫 번 째 반복문에서 기준 값을 정하고, 중첩된 반복문에서 같은 숫자의 인덱스를 구한 뒤, 해당 인덱스의 다음부터 더 커지는 숫자를 결과로 반환하면 됩니다. 

```java
import java.util.Arrays;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            int index = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == num1) {
                    index = j;
                    break;
                }
            }
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > num1) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}
```

이렇게 하면 시간복잡도가 O(M*N)이 되는데요, 문제의 마지막에 O(M+N)으로도 풀어보라고 하고있으니 당연히 풀어봐야겠죠?

처음 `N`번은 `Map`에 값과 인덱스를 저장하고 그 이후 `M`번 반복하며 `Map`에서 `index`를 찾아(O(1)) 해당 `index` 이후로 `next greater element` 값을 반환하면 됩니다.

```java
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.putIfAbsent(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = findNext(nums1[i], nums2, map);
        }
        return nums1;
    }


    int findNext(int number, int[] nums2, Map<Integer, Integer> map) {
        int result = -1;
        if (map.containsKey(number)) {
            int idx = map.get(number);
            for (int j = idx + 1; j < nums2.length; j++) {
                if (nums2[j] > number) {
                    result = nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.next_greater_element_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    void givenTwoArrays_whenFindNextGreaterElement_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1}),
                () -> test(new int[]{2, 4}, new int[]{1, 2, 3, 4}, new int[]{3, -1})
        );
    }

    private void test(int[] nums1, int[] nums2, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.nextGreaterElement(nums1, nums2);
        // then
        assertArrayEquals(expected, actual);
    }
}
```