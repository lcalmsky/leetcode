## Problem

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:
```text
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

Example 2:
```text
Input: nums = [2,0,1]
Output: [0,1,2]
```

Example 3:
```text
Input: nums = [0]
Output: [0]
```

Example 4:
```text
Input: nums = [1]
Output: [1]
```

Constraints:

* n == nums.length
* 1 <= n <= 300
* nums[i] is 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

## Solution

문제 해결을 위한 가장 중요한 정보는 0은 배열의 앞쪽에, 2는 배열의 뒷쪽에 위치해야 한다는 것 입니다.

배열을 처음부터 탐색하며 0이면 앞으로 보내고, 2면 끝으로 보내주면서 현재 0과 2의 위치를 기억하고있으면 간단히 해결됩니다.

```java
public class Solution {
    public void sortColors(int[] nums) {
        int zeroIndex = 0, current = 0, twoIndex = nums.length - 1; // (1)
        while (current <= twoIndex) {
            if (nums[current] == 0) { // (2)
                swap(nums, current++, zeroIndex++);
            } else if (nums[current] == 2) { // (3)
                swap(nums, current, twoIndex--);
            } else { // (4)
                current++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
```

> (1) 0이 위치해야할 인덱스 값, 2가 위치해야할 인덱스 값, 그리고 현재 위치를 나타내는 인덱스 값을 각각 초기화합니다.  
> (2) 현재 인덱스에 해당하는 값이 0이라면 현재 인덱스와 0이 위치해야할 인덱스의 값을 서로 `swap`해 주고 0의 인덱스와 현재 인덱스를 증가시킵니다.  
> (3) 현재 인덱스에 해당하는 값이 2이라면 현재 인덱스와 2가 위치해야할 인덱스의 값을 서로 `swap`해 주고 2의 인덱스는 감소시킵니다.  
> (4) 현재 인덱스에 해당하는 값이 1일 때는 아무 것도 하지 않습니다.  

주의해야 할 점은 (3)번에서 현재 인덱스 값은 변화를 주지 않는 것인데요, 바꾼 뒤에 그 값이 0일 수도 있기 때문에 한 번 더 체크해주기 위함입니다.

반대는 성립하지 않습니다. 앞에서부터 탐색하기 때문에 0을 앞으로 보내면서 `swap` 해줬을 때 그 값이 2가 될 수 없기 때문입니다.