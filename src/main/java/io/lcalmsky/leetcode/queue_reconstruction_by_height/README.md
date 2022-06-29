> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/queue_reconstruction_by_height/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/queue-reconstruction-by-height/) 있습니다.

## Problem

You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

**Example 1:**
```text
Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
```

**Example 2:**
```text
Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
```

**Constraints:**

* 1 <= people.length <= 2000
* 0 <= hi <= 106
* 0 <= ki < people.length
* It is guaranteed that the queue can be reconstructed.

## Solution

줄을 서있는 people 배열이 주어지는데 각 people[i] = [hi, ki]는 `hi`의 키를 가진 사람으로 `hi`보다 크거나 같은 키를 가진 `ki`명의 다른 사람들을 나타냅니다.

키(hi) 순으로 줄을 다시 구성하는 문제입니다.

정렬을 이용하여 풀이할 수 있습니다.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public int[][] reconstructQueue(int[][] people) {
    int[][] result = new int[people.length][];
    Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]); 
    List<int[]> list = new ArrayList<>();
    for (int[] array : people) {
      list.add(array[1], array);
    }
    for (int i = 0; i < people.length; i++) {
      result[i] = list.get(i);
    }
    return result;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.queue_reconstruction_by_height;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenQueue_whenReconstruction_thenOrderedByHeightCorrectly() {
    assertAll(
        () -> test(
            new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}},
            new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}}
        )
    );
  }

  private void test(int[][] given, int[][] expected) {
    // when
    Solution queueReconstructionByHeight = new Solution();
    int[][] actual = queueReconstructionByHeight.reconstructQueue(given);
    // then
    assertArrayEquals(expected, actual);
  }
}
```