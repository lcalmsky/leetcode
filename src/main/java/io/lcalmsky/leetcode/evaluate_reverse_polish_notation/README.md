> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/evaluate_reverse_polish_notation/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/evaluate-reverse-polish-notation/) 있습니다.

## Problem

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

**Note** that:

* The valid operators are '+', '-', '*', and '/'.
* Each operand may be an integer or another expression.
* The division between two integers always truncates toward zero.
* There will not be any division by zero.
* The input represents a valid arithmetic expression in a reverse polish notation.
* The answer and all the intermediate calculations can be represented in a 32-bit integer.


**Example 1:**
```text
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```

**Example 2:**
```text
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
```

**Example 3:**
```text
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
```

**Constraints:**

* 1 <= tokens.length <= 10^4
* tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].

## Solution

후위 표기법으로 된 배열이 주어지면 계산한 결과를 반환하는 문제입니다.

```java
package io.lcalmsky.leetcode.evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}

```

각 토큰을 순차적으로 탐색하면서 연산자가 아닐 땐 stack에 넣고, 연산자일 경우 해당 연산자에 맞게 stack에서 정수를 꺼내 연산한 뒤 연산한 결과를 stack에 다시 저장하는 것을 반복하면 최종적으로 하나의 요소만 남게 됩니다.

## Test

```java
package io.lcalmsky.leetcode.evaluate_reverse_polish_notation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new String[]{"2", "1", "+", "3", "*"}, 9),
                () -> test(new String[]{"4", "13", "5", "/", "+"}, 6),
                () -> test(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }

    private void test(String[] tokens, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.evalRPN(tokens);
        // then
        assertEquals(expected, actual);
    }

}
```