> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/3sum_with_multiplicity/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/_3sum-with-multiplicity/) 있습니다.

## Problem

Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 10^9 + 7.

**Example 1:**
```text
Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation:
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
```

**Example 2:**
```text
Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation:
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.
```

Constraints:

* 3 <= arr.length <= 3000
* 0 <= arr[i] <= 100
* 0 <= target <= 300

## Solution

정수 배열과 타겟 정수가 주어질 때 배열의 세 정수의 합이 타겟 정수가 되는 모든 경우의 수를 구하는 문제입니다.

정답이 매우 커질 수 있으니 10^9 + 7로 나눈 값을 반환합니다.

```java
package io.lcalmsky.leetcode._3sum_with_multiplicity;

import java.util.Arrays;

public class Solution {

  private static final int MOD = 1_000_000_007;

  public int threeSumMulti(int[] array, int target) {
    long answer = 0;
    Arrays.sort(array); // (1) 
    for (int i = 0; i < array.length; ++i) {
      int twoSum = target - array[i]; // (2) 
      int j = i + 1, k = array.length
          - 1; // (3) 
      while (j < k) { // (4) 
        if (array[j] + array[k] < twoSum) { // (5) 
          j++;
        } else if (array[j] + array[k] > twoSum) { // (6) 
          k--;
        } else if (array[j] != array[k]) { // (7) 
          int left = 1, right = 1;
          while (j + 1 < k && array[j] == array[j + 1]) { // (8) 
            left++;
            j++;
          }
          while (k - 1 > j && array[k] == array[k - 1]) { // (9) 
            right++;
            k--;
          }
          answer += (long) left * right; // (10)
          answer %= MOD;
          j++;
          k--;
        } else { // (11)
          answer += (long) (k - j + 1) * (k - j) / 2;
          answer %= MOD;
          break;
        }
      }
    }

    return (int) answer;
  }
}
```

1. 배열을 정렬합니다.
2. i를 제외한 j와 k의 합이 되어야 하는 수 입니다.
3. i, j, k 포인터 세 개를 사용합니다. i가 기준이고 j는 i보다 큰 수 중 가장 작은 수, k는 가장 큰 수 입니다.
4. 여기부터는 두 개의 포인터를 다루듯이 구현할 수 있습니다.
5. j와 k의 합이 목표보다 작으면 j를 올려줍니다.
6. j와 k의 합이 목표보다 크면 k를 줄여줍니다.
7. j와 k의 합이 목표(twoSum)와 같은데 j와 k가 다를 때
8. j가 같은 수인 개수를 셉니다.
9. k도 마찬가지로 같은 수 개수를 셉니다.
10. j 같은 수의 개수와 k 같은 수의 개수를 곱해줍니다.
11. j와 k의 합이 목표와 같고 j와 k가 같을 때, j부터 k까지 모두 동일한 수라는 뜻이기 때문에, k-j+1 개 중 2개를 뽑는 경우의 수만큼 결과에 추가합니다.

## Test

```java
package io.lcalmsky.leetcode._3sum_with_multiplicity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8, 20),
        () -> test(new int[]{1, 1, 2, 2, 2, 2,}, 5, 12)
    );
  }

  private void test(int[] array, int target, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.threeSumMulti(array, target);
    // then
    assertEquals(expected, actual);
  }
}
```