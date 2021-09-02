> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/unique_binary_search_trees_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3961/) 있습니다.

## Problem
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg)

```
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
```

**Example 2:**
```
Input: n = 1
Output: [[1]]
```

**Constraints:**

* 1 <= n <= 8

## Solution

[이전 포스팅](https://jaime-note.tistory.com/72)과 동일한 문제인데 반환해야 하는 값이 다릅니다.

이전에는 단순히 갯수만 반환했다면 이번엔 각 트리를 모두 생성해서 리스트 형태로 반환해야 합니다.





## Test