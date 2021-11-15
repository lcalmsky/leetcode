> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/largest_divisible_subset/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/largest-divisible-subset/) 있습니다.

## Problem

Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

**Example 1:**

```text
Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
```

**Example 2:**

```text
Input: nums = [1,2,4,8]
Output: [1,2,4,8]
```

**Constraints:**

* 1 <= nums.length <= 1000
* 1 <= nums[i] <= 2 * 10^9
* All the integers in nums are unique.

## Solution

주어진 배열의 가장 큰 부분 배열을 반환하는데, 이 때 조건은 부분 배열의 모든 Pair가 약수 관계여야 한다는 것입니다.

다시 정리하면 

## Test
