> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/min_stack/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/min-stack/) 있습니다.

## Problem

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

* MinStack() initializes the stack object.
* void push(int val) pushes the element val onto the stack.
* void pop() removes the element on the top of the stack.
* int top() gets the top element of the stack.
* int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.

**Example 1:**

```text
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

**Constraints:**

* -2^31 <= val <= 2^31 - 1
* Methods pop, top and getMin operations will always be called on non-empty stacks.
* At most 3 * 104 calls will be made to push, pop, top, and getMin.

## Solution

스택 자료구조를 구현하면서 추가적으로 상수 시간에 최솟값을 얻는 연산을 지원하는 클래스를 구현하는 문제입니다.

```java
package io.lcalmsky.leetcode.min_stack;

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (!minStack.isEmpty() && pop == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

```

* `push(int val)`: 주어진 값 `val`을 스택에 추가합니다. 먼저 `val`을 `stack`에 push하고, `minStack`이 비어 있거나 `minStack`의 `top` 값이 `val`보다 크거나 같은 경우에만 `val`을 `minStack`에도 push합니다. 이를 통해 `minStack`에는 항상 현재 스택의 최솟값이 유지됩니다.
* `pop()`: 스택에서 가장 위에 있는 요소를 제거합니다. `stack`에서 `pop`한 값을 `pop` 변수에 저장한 후, `minStack`이 비어 있지 않고 `pop` 값이 `minStack`의 `top` 값과 같다면 `minStack`에서도 `pop` 연산을 수행합니다. 이는 최솟값이 제거되는 경우에 `minStack`의 상태를 업데이트하기 위함입니다.
* `top()`: 스택의 가장 위에 있는 요소를 반환합니다. `stack`의 `peek()` 메서드를 호출하여 구현합니다.
* `getMin()`: 스택에서 가장 작은 값을 반환합니다. 이는 `minStack`의 `top` 값을 반환하는 것으로 구현되어 있습니다. `minStack`에는 항상 현재 스택의 최솟값이 저장되어 있으므로, `minStack`의 `top` 값을 반환하면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.min_stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStackTest {
    @Test
    void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin()); // return -3
        minStack.pop();
        assertEquals(0, minStack.top());    // return 0
        assertEquals(-2, minStack.getMin()); // return -2
    }
}
```