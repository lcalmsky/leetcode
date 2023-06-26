> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/leetcode.total_cost_to_hire_k_workers/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/leetcode.total-cost-to-hire-k-workers/) 있습니다.

## Problem

You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

* You will run k sessions and hire exactly one worker in each session.
* In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
  * For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
  * In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
* If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
* A worker can only be chosen once.

Return the total cost to hire exactly k workers.

**Example 1:**

```text
Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
Output: 11
Explanation: We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8]. The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
- In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8]. The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
- In the third hiring round we choose the worker from [17,12,10,7,11,20,8]. The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was common in the first and last four workers.
  The total hiring cost is 11.
```

**Example 2:**

```text
Input: costs = [1,2,4,1], k = 3, candidates = 3
Output: 4
Explanation: We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [1,2,4,1]. The lowest cost is 1, and we break the tie by the smallest index, which is 0. The total cost = 0 + 1 = 1. Notice that workers with index 1 and 2 are common in the first and last 3 workers.
- In the second hiring round we choose the worker from [2,4,1]. The lowest cost is 1 (index 2). The total cost = 1 + 1 = 2.
- In the third hiring round there are less than three candidates. We choose the worker from the remaining workers [2,4]. The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
  The total hiring cost is 4.
```

**Constraints:**

* 1 <= costs.length <= 10^5
* 1 <= costs[i] <= 10^5
* 1 <= k, candidates <= costs.length

## Solution

i번째 일꾼을 고용하는데 드는 비용 배열과 k와 candidates 정수가 주어집니다. 우리는 정확히 k명의 일꾼을 아래 규칙에 맞춰 고용하려고 합니다.

* k 번의 세션을 수행하면서 각 세션당 정확히 한 명의 일꾼을 고용해야 합니다.
* 고용 세션에서는 가장 저렴한 비용의 일꾼을 고용해야 합니다. 비용이 동일할 경우 더 낮은 인덱스의 일꾼을 고용합니다.
* 일꾼이 후보자 수보다 적어지면 그 중 가장 저렴한 일꾼을 선택합니다. 마찬가지로 비용이 동일할 경우 더 낮은 인덱스의 일꾼을 고용합니다.
* 일꾼은 한번에 한 명만 선택될 수 있습니다.

k명의 일꾼을 고용하는데 필요한 총 비용을 반환하는 문제입니다.



## Test