> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/single_element_in_a_sorted_array/Solution.java) 있습니다.  
> 문제는 [여기](https://github.com/lcalmsky/leetcode/issues/34) 있습니다.

## Problem

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

**Example 1:**

```text
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
```

**Example 2:**

```text
Input: nums = [3,3,7,7,10,11,11]
Output: 10
```

**Constraints:**

* 1 <= nums.length <= 10^5
* 0 <= nums[i] <= 10^5

## Solution

정렬된 정수 배열이 주어지고 배열의 원소는 하나를 제외하고는 모두 정확히 두 개씩 같은 원소들이 포함되어 있을 때 한 번만 나타나는 원소를 구하는 문제입니다.

O(log n)의 시간 복잡도와 O(1)의 공간 복잡도 내에서 해결하라는 제약이 있습니다.

O(log n)의 시간복잡도에서 힌트를 얻을 수 있는데 검색할 때마다 반씩 줄여나가면서 원소를 찾아야 합니다.

하나를 제외하고는 무조건 두 개의 같은 원소의 쌍으로 구성되어있기 때문에 (0, 1), (1, 2) 이런식으로 인접한 두 원소는 항상 같아야합니다.

하지만 반씩 범위를 줄여나가다보면 안 맞는 경우를 찾을 수 있는데 이 때 그 인덱스에 해당하는 값이 오로지 한 개만 존재하는 원소라고 단정지을 순 없습니다.

1번 예를 기준으로 생각해보면,

```text
1 1 2 3 3 4 4 8 8
        ^
```

4번 인덱스 3이 중간 값이 되고 바로 앞의 값과는 동일하지만 바로 뒤 값과는 다릅니다.

아래 예시처럼 하나의 원소가 뒤쪽에 있을 수도, 앞 쪽에 있을 수도 있습니다.

중간 인덱스를 정한뒤 중간 인덱스가 홀수라면 바로 앞 짝수와 비교하고 그 값이 같은 경우 중간보다 오른쪽에, 그렇지 않은 경우 왼쪽에 위치한다는 것을 알 수 있습니다. 

계속 반복해서 반을 줄여나가다보면 최종적으로 다른 하나의 원소를 찾을 수 있습니다.

```java
public class Solution {

  public int singleNonDuplicate(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == nums[mid ^ 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.single_element_in_a_sorted_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenSortedArray_whenFindSingleElement_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}, 2),
        () -> test(new int[]{3, 3, 7, 7, 10, 11, 11}, 10)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution singleElementInASortedArray = new Solution();
    int actual = singleElementInASortedArray.singleNonDuplicate(given);

    // then
    assertEquals(expected, actual);
  }
}
```