> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) 있습니다.

## Problem

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The
binary tree has the following definition:

```
struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be
set to NULL.

Initially, all next pointers are set to `NULL`.

Follow up:

* You may only use constant extra space.
* Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

Example 1:

```text
       1                 1-> null         
     /   \             /   \       
   /       \         /       \    
  2         3       2 ------> 3 -> null  
 /  \      /  \    /  \      /  \ 
4    5    6    7  4 -> 5 -> 6 -> 7 -> null 
```

```text
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to
its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers,
with '#' signifying the end of each level.
```

Constraints:

* The number of nodes in the given tree is less than 4096.
* -1000 <= node.val <= 1000

## Solution

이 문제는 완전 이진 트리에서 각 노드별로 `next`라는 속성을 가지는데, 이 때 `next`는 각 노드의 현재 위치에서 우측에 있는 노드를 말하고, 트리의 모든 노드에 `next` 노드를 설정하는 문제입니다.

처음에 든 생각은 `Queue`나 `Stack`에 각 노드를 넣고 꺼내면서 처리하는 것이었습니다.

`Stack`에 넣게 되면 꺼낼 때 역순이 되기 때문에 `Queue`를 사용하여 코딩해보았으나 현재 `depth`를 억지로 판단(2의 n 제곱 갯수만큼 진행됐을 때 depth를 올려주는 식)하면서 뭔가 꼬이기
시작했고 분명히 더 나은 방법이 존재할 거 같아 생각을 바꾸기로 했습니다.

풀이한 순서는 다음과 같습니다.

1. 현재 노드를 각 `depth`의 첫 노드로 설정
    ```text
          (1)        
         /   \      
       /       \    
      2         3   
     /  \      /  \ 
    4    5    6    7
    ```
2. 현재 노드가 `null`이 아닌지 판단
    ```text
          (1) <- `null` 아님        
         /   \      
       /       \    
      2         3   
     /  \      /  \ 
    4    5    6    7
    ```
3. 현재 노드의 `left` 노드가 `null`이 아닌지 판단
    ```text
           1        
         /   \      
       /       \    
     (2)        3   
     /  \      /  \ 
    4    5    6    7
    ```
4. `left` 노드의 `next` 노드는 현재 노드의 `right` 노드
    ```text
           1        
         /   \      
       /       \    
     (2) ----> (3)   
     /  \      /  \ 
    4    5    6    7
    ```
5. 현재 노드의 `right` 노드가 `null`이 아닌지 판단
    ```text
           1        
         /   \      
       /       \    
      2  ----> (3)   
     /  \      /  \ 
    4    5    6    7
    ```
6. 현재 노드의 `next` 노드가 `null`이 아닌지 판단
    ```text
          (1 -> null)        
         /   \      
       /       \    
      2  ---->  3   
     /  \      /  \ 
    4    5    6    7
    ```
7. 현재 노드의 `right` 노드의 `next` 노드는 현재 노드의 `next` 노드의 `left` 노드   
   7.1. 6번이 `null`이기 때문에 해당사항 없음
8. 현재 노드를 현재 노드의 next 노드로 바꿔줌  
   8.1. `next` 노드가 `null`이라 바꿀 수 없음  
   8.2. `null`이 아닐 경우 `null`이 될 때까지 2~7번 반복
9. 각 `depth`의 첫 번 째 `node`를 현재 `node`의 `left`로 바꿔줌
    ```text
           1        
         /   \      
       /       \    
     (2) ---->  3   
     /  \      /  \ 
    4    5    6    7
    ```
10. 1번부터 반복

소스 코드로 확인해볼까요?

```java
package io.lcalmsky.leetcode.populating_next_right_pointers_in_each_node;

public class Solution {
    public Node connect(Node root) {
        Node firstNodeOfCurrentDepth = root;
        while (firstNodeOfCurrentDepth != null) {
            Node current = firstNodeOfCurrentDepth;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }
                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            firstNodeOfCurrentDepth = firstNodeOfCurrentDepth.left;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
```

로컬에서 테스트를 위해 테스트 코드도 작성했습니다.

```java
package io.lcalmsky.leetcode.populating_next_right_pointers_in_each_node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
    @Test
    void test() {
        // given
        Node root = new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null);
        // when
        Solution solution = new Solution();
        Node actual = solution.connect(root);

        // then
        assertNull(actual.next);
        assertEquals(actual.left.next, actual.right);
        assertEquals(actual.left.left.next, actual.left.right);
        assertEquals(actual.left.right.next, actual.right.left);
        assertEquals(actual.right.left.next, actual.right.right);
        assertNull(actual.right.right.next);
    }
}
```

테스트는 성공했고 제출해보았습니다.

그 결과..

```text
Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node.
Memory Usage: 39.3 MB, less than 41.00% of Java online submissions for Populating Next Right Pointers in Each Node.
```

좋은 성적을 받았습니다 😁

---

저는 `LeetCode`에서 풀 문제를 고를 때 인터뷰 `Top 100` 리스트에서 순차적으로 풀곤하는데 이번 문제는 👍가 무려 3800이 넘고 👎가 200도 안 되는 좋은 문제라 풀면서 굉장히 재밌었습니다.

`Tree`나 `LinkedList` 등 자료구조를 활용하는 문제는 그 자료구조의 원리를 100% 이해한 상태에서 응용된 문제를 많이 풀어보면서 경험을 많이 쌓아야 코딩테스트에서 좋은 결과를 얻을 거 같다는 생각이
들었습니다. 