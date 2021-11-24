> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/interval_list_intersections/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/interval-list-intersections/) 있습니다.

## Problem

You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

**Example 1:**

```text
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
```

**Example 2:**

```text
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
```

**Example 3:**

```text
Input: firstList = [], secondList = [[4,8],[10,12]]
Output: []
```

**Example 4:**

```text
Input: firstList = [[1,7]], secondList = [[3,10]]
Output: [[3,7]]
```

**Constraints:**

* 0 <= firstList.length, secondList.length <= 1000
* firstList.length + secondList.length >= 1
* 0 <= starti < endi <= 109
* endi < starti+1
* 0 <= startj < endj <= 109
* endj < startj+1

## Solution

두 구간을 나타내는 배열이 주어졌을 때 겹치는 구간의 부분 배열을 구하는 문제입니다.



## Test