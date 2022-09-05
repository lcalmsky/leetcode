> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/n_ary_tree_level_order_traversal/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/n-ary-tree-level-order-traversal/) 있습니다.

## Problem

Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children
is separated by the null value (See examples).

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

```text
Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
```

![](https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png)

**Example 2:**

```text
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
```

**Constraints:**

* The height of the n-ary tree is less than or equal to 1000
* The total number of nodes is between [0, 10^4]

## Solution

n-ary 트리가 주어졌을 때 각 노드를 레벨 순으로 순회하는 문제입니다.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int n = queue.size();
      List<Integer> temp = new ArrayList<>();
      while (n-- > 0) {
        Node node = queue.remove();
        temp.add(node.val);
        queue.addAll(node.children);
      }
      result.add(temp);
    }
    return result;
  }
}

```

같은 레벨끼리 순차적으로 순회하기 위해선 BFS를 이용해야 합니다.

BFS는 queue로 구현할 수 있습니다.

트리 관련 중급 문제중 가장 기본 문제이므로 외워버리는 것도 나쁘지 않을 거 같습니다.