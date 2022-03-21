> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/partition_labels/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/partition-labels/) 있습니다.

## Problem

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

**Example 1:**
```text
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
```
**Example 2:**
```text
Input: s = "eccbbbbdec"
Output: [10]
```

**Constraints:**

* 1 <= s.length <= 500
* s consists of lowercase English letters.

## Solution

문자열이 주어졌을 때 각각의 문자가 최대한 많이 나타나도록 문자열을 분리하는 문제입니다.

```java
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<Integer> partitionLabels(String S) {
    List<Integer> result = new LinkedList<>();
    char[] array = S.toCharArray();
    int length = array.length;
    int[] lastIndices = new int[26]; // (1)
    for (int i = 0; i < length; i++) { // (2)
      lastIndices[array[i] - 'a'] = i;
    }
    int max = lastIndices[array[0] - 'a'];
    int s = 0;
    for (int i = 0; i < length; i++) { // (3) 
      if (i == max) {
        result.add(max - s + 1);
        s = max + 1;
        if (i + 1 < length) {
          max = lastIndices[array[i + 1] - 'a'];
        }
      } else {
        max = Math.max(lastIndices[array[i] - 'a'], max);
      }
    }
    return result;
  }
}
```

1. 각 문자가 마지막으로 나타난 인덱스를 저장하기 위한 배열을 선언 및 초기화합니다.
2. 주어진 문자열을 탐색하면서 각각의 알파벳에 해당하는 위치에 인덱스 값을 갱신합니다.
3. 다시 문자열을 순차적으로 탐색하면서 max 값을 갱신하고, max값과 인덱스가 동일해졌을 때 결과 리스트에 해당 값을 추가합니다. 그리고 그 때까지의 길이를 따로 저장해두었다가 다음 분할지점이 왔을 때 계산에 사용합니다.

## Test

```java
package io.lcalmsky.leetcode.partition_labels;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenString_whenPartitionString_thenEachLetterAppearsMost() {
    assertAll(
        () -> test("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
        () -> test("ㄷㅊ츄ㅠㅠㅠㅇㄷㅊ", List.of(10))
    );
  }

  private void test(String given, List<Integer> expected) {
    // when
    Solution solution = new Solution();
    List<Integer> actual = solution.partitionLabels(given);
    // then
    assertEquals(expected, actual);
  }
}

```