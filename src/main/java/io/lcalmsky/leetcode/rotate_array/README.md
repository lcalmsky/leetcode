> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/rotate_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/rotate-array/) 있습니다.

## Problem

Given an array, rotate the array to the right by k steps, where k is non-negative.

**Example 1:**
```text
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```
**Example 2:**
```text
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

**Constraints:**

* 1 <= nums.length <= 10^5
* -2^31 <= nums[i] <= 2^31 - 1
* 0 <= k <= 10^5

**Follow up:**

* Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
* Could you do it in-place with O(1) extra space?

## Solution

배열과 정수 k가 주어졌을 때 배열을 k만큼 오른쪽으로 회전시키는 문제입니다.

```java
public class Solution {

  public void rotate(int[] nums, int k) {
    int length = nums.length;
    if (k > length) { // (1)
      k = k % length;
    }
    int index = length - k; // (2)
    reverse(nums, 0, index - 1); // (3)
    reverse(nums, index, length - 1); // (4)
    reverse(nums, 0, length - 1); // (5)
  }

  private void reverse(int[] nums, int left, int right) {
    if (nums == null || nums.length == 1) {
      return;
    }
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }
}
```

1. k를 배열의 길이로 나눈 나머지를 구합니다.
2. 배열의 길이에서 k를 뺀 인덱스를 기준으로 설정합니다.
3. 배열의 첫 번째부터 기준 인덱스까지의 원소를 뒤집어 줍니다.
4. 배열의 기준 인덱스부터 끝까지의 원소를 뒤집어 줍니다.
5. 배열 전체를 뒤집어 줍니다.

## Test

