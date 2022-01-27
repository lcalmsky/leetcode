> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximum_xor_of_two_numbers_in_an_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) 있습니다.

## Problem

Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

**Example 1:**
```text
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
```

**Example 2:**
```text
Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
```

**Constraints:**

* 1 <= nums.length <= 2 * 10^5
* 0 <= nums[i] <= 2^31 - 1

## Solution

정수 배열이 주어졌을 때 두 정수의 XOR값이 최대가 되는 값을 구하는 문제입니다.



## Test