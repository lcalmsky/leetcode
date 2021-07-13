## Problem

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the
index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

Example 1:

```text
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
```

Example 2:

```text
Input: nums = [1,2,1,3,5,6,4]
Output: 5 Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5
where the peak element is 6.
```

Constraints:

* 1 <= nums.length <= 1000
* -2^31 <= nums[i] <= 2^31 - 1
* nums[i] != nums[i + 1] for all valid i.

## Solution

`peak element`는 이웃한 `element`보다 큰 `element` 입니다.

문제에서는 정수 배열이 주어졌을 때 `peak element`가 존재하면 아무 `peak element`의 인덱스를 반환하라고 되어있습니다.

그리고 시간복잡도 `O(log n)`를 사용하라고 되어있습니다.

그냥 peak element를 구하는 방법은 매우 간단합니다.

순차적으로 탐색하면서 더 커지는 순간을 구해도 충분하죠.

하지만 예시가 1000개이고 1000 번 째 숫자 때 숫자가 증가한다고 가정하면 효율이 매우 떨어지고 O(log n)으로 해결했다고 할 수 없습니다.

(당연히 제출하더라도 실패할 거구요)

따라서, 이진 탐색으로 무조건 `O(log n)`의 시간 복잡도가 소요되게 구현하시면 됩니다.

```java
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
```

배열의 왼쪽, 오른쪽 끝 인덱스를 나타내는 포인터를 선언한 뒤, 더 작은 인덱스가 더 큰 인덱스와 같아지는 순간의 인덱스를 반환합니다.

좌우 인덱스 값을 이용해 중간 값을 구해 탐색의 범위를 한 번 반복할 때마다 반으로 줄여 `O(log n)`으로 해결할 수 있습니다.

일단 알고리즘이 정확히 구현되었는지 확인하기 위해 테스트 클래스도 작성하였습니다.

```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 1}, 2),
                () -> test(new int[]{1, 2, 1, 3, 5, 6, 4}, 5)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        solution = new Solution();
        int actual = solution.findPeakElement(nums);

        // then
        assertEquals(expected, actual);
    }
}
```

테스트가 무사히 통과되었습니다 🥳

---

매우 단순한 문제이지만 문제 의도를 파악하는데 한참 걸렸네요.

요즘 계속 연습하고 있는 게, 문제를 꼼꼼히 읽어 남에게 설명할 수 있을 정도로 문제의 의도를 정확히 파악하는 것인데 아직도 한참 멀은 거 같습니다.

라이브 코딩테스트를 준비하는 분이라면 꼭 문제 의도를 남에게 설명할 수 있을 정도로 파악하는 방법을 연습해보세요 😀

그 이후에는 어떤 방식으로 접근할지 혼잣말(또는 마음 속으로 생각)로라도 설명하는 연습을 많이 해야 라이브 코딩테스트 때 실력을 발휘할 수 있습니다. 