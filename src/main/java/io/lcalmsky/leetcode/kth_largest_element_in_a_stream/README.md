> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/kth_largest_element_in_a_stream/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/kth-largest-element-in-a-stream/) 있습니다.

## Problem

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

* KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
* int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.


**Example 1:**
```text
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
```

**Constraints:**

* 1 <= k <= 10^4
* 0 <= nums.length <= 10^4
* -10^4 <= nums[i] <= 10^4
* -10^4 <= val <= 10^4
* At most 10^4 calls will be made to add.
* It is guaranteed that there will be at least k elements in the array when you search for the kth element.

## Solution

스트림의 k번 째로 큰 수를 찾아주는 클래스를 구현하는 문제입니다.

먼저 생성자로 k와 초기 배열을 전달할 수 있고, 그 이후로는 원소들을 더할 수 있는데 k번째로 큰 수를 반환해야합니다.

우선순위 큐를 이용해 k개 만큼만 큐에 저장하게하고, top에 있는 엘리먼트를 반환하면 됩니다.

```java
import java.util.PriorityQueue;

public class KthLargest {

  private final PriorityQueue<Integer> queue;
  private final int k;

  public KthLargest(int k, int[] nums) {
    queue = new PriorityQueue<>();
    this.k = k;
    for (int num : nums) { // (1) 
      queue.offer(num);
      if (queue.size() > k) {
        queue.poll();
      }
    }
  }

  public int add(int val) { // (2)
    queue.offer(val);
    if (queue.size() > k) {
      queue.poll();
    }
    return queue.peek();
  }
}
```

1. queue에 모든 정수를 넣는데 k개를 초과하게되면 가장 작은 수를 제거합니다.
2. 1번과 동일합니다.

## Test

```java
package io.lcalmsky.leetcode.kth_largest_element_in_a_stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KthLargestTest {

  @Test
  void test() {
    KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
    assertEquals(4, kthLargest.add(3));
    assertEquals(5, kthLargest.add(5));
    assertEquals(5, kthLargest.add(10));
    assertEquals(8, kthLargest.add(9));
    assertEquals(8, kthLargest.add(4));
  }
}
```