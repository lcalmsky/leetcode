> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/reduce_array_size_to_the_half/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/reduce-array-size-to-the-half/) 있습니다.

## Problem

You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

**Example 1:**
```text
Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
```

**Example 2:**
```text
Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
```

**Constraints:**

* 2 <= arr.length <= 10^5
* arr.length is even.
* 1 <= arr[i] <= 10^5

## Solution

정수 배열이 주어지고 몇 개의 정수를 골라 제거할 수 있습니다. 이 때 배열이 적어도 절반 이상 제거될 수 있는 최소 정수 개수를 구하는 문제입니다.

```java
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution {

  public int minSetSize(int[] arr) {
    Map<Integer, Integer> frequencies = new HashMap<>();
    for (int element : arr) {
      frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
    }
    List<Entry<Integer, Integer>> sortedEntries = frequencies.entrySet().stream()
        .sorted((a, b) -> b.getValue() - a.getValue())
        .collect(Collectors.toUnmodifiableList());
    int count = 0;
    int index = 0;
    while (count * 2 < arr.length) {
      count = count + sortedEntries.get(index).getValue();
      index++;
    }
    return index;
  }
}
```

숫자의 빈도를 먼저 계산한 뒤, 빈도순으로 정렬하고, 빈도가 높은 숫자부터 제거했을 때 배열의 길이의 반이 되는 순간의 인덱스를 반환하면 됩니다. 



## Test

```java
package io.lcalmsky.leetcode.reduce_array_size_to_the_half;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}, 2),
        () -> test(new int[]{7, 7, 7, 7, 7, 7}, 1)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minSetSize(given);
    // then
    assertEquals(expected, actual);
  }
}
```