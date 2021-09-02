> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/array_nesting/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3960/) 있습니다.

## Problem
You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].

You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:

The first element in s[k] starts with the selection of the element nums[k] of index = k.
The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
We stop adding right before a duplicate element occurs in s[k].
Return the longest length of a set s[k].

**Example 1:**
```
Input: nums = [5,4,0,3,1,6,2]
Output: 4
Explanation:
nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
One of the longest sets s[k]:
s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
```

**Example 2:**

```
Input: nums = [0,1,2]
Output: 1
```

**Constraints:**

* 1 <= nums.length <= 10^5
* 0 <= nums[i] < nums.length
* All the values of nums are unique.

## Solution

0에서 N-1까지 숫자로 구성된 배열이 주어졌을 때, s[k] 중 가장 긴 길이를 반환하는 문제입니다.

여기서 s[k]란 배열의 k번 째 인덱스에서 시작하여 해당 엘리먼트를 인덱스로 가지는 다음 엘리먼트를 순차적으로 찾아가는 것으로, 중복된 엘리먼트를 만날 때까지 진행될 수 있습니다.

예제 1에서 s[0]은 nums[0]에서 출발해 nums[0]의 값인 5가 다음 인덱스가 되고, nums[5]의 값인 6이 다음 인덱스, nums[6]의 값인 2가 다음 인덱스, nums[2]의 값이 0이라 다시 순환하게 되므로 이 때 종료되어 길이가 4가 됩니다.

s[1]을 하나만 더 확인해보면, nums[1] = 4 -> nums[4] = 1로 다시 순환하게 되므로 길이가 2 입니다.

이렇게 나타낼 수 있는 s[k] 중 가장 긴 값을 구하는 문제입니다.

풀이를 위해선 방문했던 인덱스를 체크할 필요가 있는데요, 추가로 boolean 배열을 사용하는 방법도 있지만 문제에서 주어진 숫자의 범위가 0~10^5 이기 때문에 이 범위를 벗어나는 숫자로 변경한다면 메모리를 아낄 수 있습니다.

나머지는 s[k]의 방식을 그대로 따라서 구현하시면 됩니다.

s[0] 부터 s[n-1] 까지 반복하게 될텐데 이 중 한 번이라도 등장한 인덱스는 무조건 방문처리 해야합니다.

예를 들어 s[0]의 길이가 4였는데 방문한 인덱스는 0, 5, 6, 2 인데, 이미 방문한 인덱스 중 s[2]를 진행한다고 가정하면 2, 0, 5, 6으로 엘리먼트는 동일하고 순서만 달라지므로 길이에 영향이 없기 때문입니다.

```java
class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int next = nums[i], count = 0;
                while (nums[next] != -1) {
                    int previous = next; // 방문한 인덱스 체크하기 위해 임시 변수 선언
                    next = nums[next]; // 다음 인덱스를 구함
                    count++; // 방문한 엘리먼트 갯수를 증가시킴
                    nums[previous] = -1; // 방문한 인덱스의 숫자를 -1로 바꿔 방문처리
                }
                max = Math.max(max, count); // 배열의 모든 인덱스를 방문하면서 최댓값을 구함
            }
        }
        return max;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.array_nesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenArray_whenFindLongestLengthOfArrayNesting_thenCorrect() {
        assertAll(
                () -> test(new int[]{5, 4, 0, 3, 1, 6, 2}, 4),
                () -> test(new int[]{0, 1, 2}, 1)
        );
    }

    private void test(int[] given, int expected) {
        // when
        AnotherSolution solution = new AnotherSolution();
        int actual = solution.arrayNesting(given);

        // then
        assertEquals(expected, actual);
    }
}
```