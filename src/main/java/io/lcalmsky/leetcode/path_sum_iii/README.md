> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/path_sum_iii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/path-sum-iii/) 있습니다.

## Problem

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg)

```text
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
```

**Example 2:**

```text
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
```

**Constraints:**

* The number of nodes in the tree is in the range [0, 1000].
* -10^9 <= Node.val <= 10^9
* -1000 <= targetSum <= 1000

## Solution

이진 트리와 타겟 정수가 주어졌을 때 트리 내에서 타겟 정수를 만들 수 있는 경로의 갯수를 구하는 문제입니다.

경로는 루트나 리프노드에서 시작하거나 끝낼 필요가 없으나 반드시 아래로만 향해야 합니다.

```java


```


## Test
