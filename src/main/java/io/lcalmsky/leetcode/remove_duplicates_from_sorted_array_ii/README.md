> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/remove_duplicates_from_sorted_array_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/) 있습니다.

## Problem

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such
that each unique element appears at most twice. The relative order of the elements should be kept
the same.

Since it is impossible to change the length of the array in some languages, you must instead have
the result be placed in the first part of the array nums. More formally, if there are k elements
after removing the duplicates, then the first k elements of nums should hold the final result. It
does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array
in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

```text
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```

If all assertions pass, then your solution will be accepted.

**Example 1:**

```text
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Example 2:**

```text
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Constraints:**

* 1 <= nums.length <= 3 * 10^4
* -10^4 <= nums[i] <= 10^4
* nums is sorted in non-decreasing order.

## Solution

감소하지 않는 순으로 정렬된 배열이 주어질 때 같은 엘리먼트가 최대 두 번만 나타나도록 중복을 in-place로 제거해야 합니다. 이 때 기존 엘리먼트들의 순서는 동일하게
유지되어야 합니다.

배열의 길이를 바꾸는 것이 불가능한 언어가 존재하므로 in-place로 배열 내 엘리먼트들의 배치를 조작했을 때 감소하기 직전까지의 길이를 반환하면 됩니다.

추가 메모리를 사용해서는 안 됩니다.

배열이 정렬되어 있으므로 모든 중복 함옥은 연속됩니다. 따라서 2개의 포인터를 사용해 하나는 세 번 이상 나타나는 숫자를 가리키고, 다른 하나는 대체될 위치를 나타냅니다.

반복문을 순차적으로 탐색하면서 3회 이상 나타나는 중복된 숫자들을 모두 덮어쓸 때까지 반복하면 답을 구할 수 있습니다.

```java
public class Solution {

  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    if (n <= 2) {
      return n;
    }
    int indexToBeInserted = 1;
    for (int i = 2; i < n; i++) {
      if (nums[i] != nums[indexToBeInserted - 1]) {
        nums[++indexToBeInserted] = nums[i];
      }
    }
    return indexToBeInserted + 1;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.remove_duplicates_from_sorted_array_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 1, 2, 2, 3}, 5),
        () -> test(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, 7)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.removeDuplicates(given);
    // then
    assertEquals(expected, actual);
  }
}
```