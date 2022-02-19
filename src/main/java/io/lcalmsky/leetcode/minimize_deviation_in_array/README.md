> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/minimize_deviation_in_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/minimize-deviation-in-array/) 있습니다.

## Problem

You are given an array nums of n positive integers.

You can perform two types of operations on any element of the array any number of times:

If the element is even, divide it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
If the element is odd, multiply it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
The deviation of the array is the maximum difference between any two elements in the array.

Return the minimum deviation the array can have after performing some number of operations.

**Example 1:**
```text
Input: nums = [1,2,3,4]
Output: 1
Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
```
**Example 2:**
```text
Input: nums = [4,1,5,20,3]
Output: 3
Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
```
**Example 3:**
```text
Input: nums = [2,10,8]
Output: 3
```

**Constraints:**

* n == nums.length
* 2 <= n <= 10^5
* 1 <= nums[i] <= 10^9

## Solution

n개의 양의 정수를 가진 배열이 주어지고 아래와 같은 두 개의 연산을 아무 원소에 원하는 만큼 수행할 수 있습니다.

* 짝수면 2로 나눔
* 홀수면 2를 곱함

배열의 편차는 배열의 두 개의 원소의 차이 중 가장 큰 값입니다.

최소의 편차를 얻을 때까지 위의 연산을 수행하고 해당 편차를 반환하는 문제입니다.

TreeSet을 이용해 정렬된 상태로 중복 원소를 제거해 나가면 문제를 해결할 수 있습니다.

```java
import java.util.TreeSet;

public class Solution {

  public int minimumDeviation(int[] nums) {
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (int num : nums) { // (1)
      if (num % 2 == 1) {
        treeSet.add(num * 2);
      } else {
        treeSet.add(num);
      }
    }
    int minDeviation = treeSet.last() - treeSet.first(); // (2)
    while (treeSet.last() % 2 == 0) { // (3)
      treeSet.add(treeSet.last() / 2); // (4)
      treeSet.remove(treeSet.last()); // (5)
      minDeviation = Math.min(minDeviation, treeSet.last() - treeSet.first()); // (6)
    }
    return minDeviation;
  }
}
```

1. 배열의 원소를 순차적으로 TreeSet에 넣는데, 홀수인 경우 두 배를 곱해서 넣어줍니다.
2. TreeSet의 마지막 값은 가장 큰 값, 첫 번째 값은 가장 작은 값이므로 두 수의 차는 편차가 됩니다.
3. 마지막 원소가 짝수인 동안 반복합니다. 가장 큰 수가 짝수일 경우 2로 나눠 가장 작은 수와의 편차를 줄일 수 있기 때문입니다.
4. 마지막 원소를 2로 나눠 TreeSet에 추가합니다.
5. 마지막 원소를 제거합니다. 4~5번을 반복할 때마다 마지막 원소의 값이 반이 됩니다.
6. 최소 편차를 다시 구합니다.

예제 1번에 주어진 값으로 예를 들면 아래와 같습니다.

```text
주어진 배열: [1, 2, 3, 4]

TreeSet에 넣을 때:

[2, 2, 3, 4]: 첫 번째 원소인 1은 홀수이므로 2배
[2, 2, 3, 4]: 두 번째 원소인 2는 짝수이므로 통과 
[2, 2, 6, 4]: 첫 번째 원소인 3은 홀수이므로 2배
[2, 2, 6, 4]: 네 번째 원소인 4은 짝수이므로 통과

중복을 제거한 결과: [2, 4, 6]

현재 편차: 6 - 2 = 4

마지막 원소가 짝수가 아닐 때까지 반복

[2, 3, 4, 6]: 마지막 원소를 반으로 나눠 추가
[2, 3, 4]: 마지막 원소 제거
현재 편차: 4 - 2 = 2

[2, 2, 3, 4]: 마지막 원소를 반으로 나눠 추가(중복이라 둘 중 하나는 제거됨)
[2, 3]: 마지막 원소를 제거
현재 편차: 3 - 2 = 1

마지막 원소가 짝수가 아니므로 더 이상 진행 불가

현재 편차인 1 반환
```

## Test

```java
package io.lcalmsky.leetcode.minimize_deviation_in_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4}, 1),
        () -> test(new int[]{4, 1, 5, 20, 3}, 3),
        () -> test(new int[]{2, 10, 8}, 3)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minimumDeviation(given);
    // then
    assertEquals(expected, actual);
  }
}
```