> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/jump_game/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/jump-game/) 있습니다.

## Problem

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

**Example 1:**

```text
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**

```text
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
```

**Constraints:**

* 1 <= nums.length <= 10^4
* 0 <= nums[i] <= 10^5

## Solution

각 값이 최대 점프 길이를 가지는 배열이 주어졌을 때 첫 번 째 위치에서 시작하여 마지막 위치에 도달할 수 있는지 확인하는 문제입니다.

```java
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) { // (1)
            return true;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max <= i && nums[i] == 0) { // (2)
                return false;
            }
            if (i + nums[i] > max) { // (3)
                max = i + nums[i];
            }
            if (max >= nums.length - 1) { // (4)
                return true;
            }
        }
        return false;
    }
}
```

(1) 길이가 1 이하이면 무조건 마지막 인덱스에 도달할 수 있으므로 true를 반환합니다.  
(2) 현재 최대로 도달할 수 있는 값을 max라고 할 때 max 값이 i보다 작거나 같고 인덱스 i에 해당하는 값이 0일 경우 마지막까지 도달할 수 없으므로 false를 반환합니다.  
(3) max의 값을 현재 인덱스 + 현재 인덱스에 해당하는 값을 더해 최대로 도달할 수 있는 인덱스 값으로 갱신합니다.  
(4) max값이 배열의 길이보다 크거나 같으면 true를 반환합니다.

---

제출하고 다른 사람들의 답을 확인해보니 훨씬 더 간단한 방법이 있어 소개합니다.

```java
public class Solution {
    public boolean canJump(int[] nums) {
        int distance = 0;
        for (int i = 0; i <= distance; i++) {
            distance = Math.max(distance, i + nums[i]);
            if (distance >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
```

처음 소개한 풀이보다 훨씬 단순하네요. 😅

## Test


