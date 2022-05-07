> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/_132_pattern/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/132-pattern/) 있습니다.

## Problem

Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

**Example 1:**
```text
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
```
**Example 2:**
```text
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
```
**Example 3:**
```text
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
```

**Constraints:**

* n == nums.length
* 1 <= n <= 2 * 10^5
* -10^9 <= nums[i] <= 10^9

## Solution

n개의 정수 배열이 주어질 때, 정수 배열의 부분 배열 중 132 패턴이 존재하는지 확인하는 문제입니다.

132 패턴은 i < j < k 일 때 nums[i] < nums[k] < nums[j]를 만족시키는 패턴입니다.



## Test