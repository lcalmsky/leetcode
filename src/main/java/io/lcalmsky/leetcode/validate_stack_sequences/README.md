> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/validate_stack_sequences/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/validate-stack-sequences/) 있습니다.

## Problem

Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

**Example 1:**
```text
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
```
**Example 2:**
```text
Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
```

**Constraints:**

* 1 <= pushed.length <= 1000
* 0 <= pushed[i] <= 1000
* All the elements of pushed are unique.
* popped.length == pushed.length
* popped is a permutation of pushed.

## Solution

두 개의 정수 배열이 각각 고유의 값을 가지고있을 때 스택의 push, pop 연산의 결과가 될 수 있는지 확인하는 문제입니다.

실제로 스택에 넣었다 빼면서 가능한지 확인하는 방법으로 일단 구현해보았습니다.

```java
import java.util.Stack;

public class Solution {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int j = 0;
    for (int i : pushed) {
      stack.push(i);
      while (!stack.isEmpty() && popped[j] == stack.peek()) {
        stack.pop();
        j++;
      }
    }
    return stack.isEmpty();
  }
}
```

이렇게하면 풀리긴 하는데 성능 측면에서 아쉬운 결과를 받게 되는데요, 스택을 사용하지 않고 인덱스 값을 잘 조절하면 배열만으로도 해결할 수 있습니다.

```java
public class Solution {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int i = 0, j = 0; // (1)
    for (int val : pushed) { // (2)
      pushed[i++] = val; // (3)
      while (j < popped.length && i > 0 && pushed[i - 1] == popped[j]) { // (4)
        i--;
        j++;
      }
    }
    return i == 0; // (5)
  }
}
```

1. i는 pushed의 인덱스, j는 popped의 인덱스를 저장할 변수입니다.
2. pushed 배열을 순차적으로 탐색하면서
3. i번째에 현재 값을 할당하고 i의 값을 증가시킵니다.
4. i가 범위 내에 있고 pushed의 이전 값이 popped의 현재 값인 경우 i의 인덱스를 빼주고 j의 인덱스를 더해줍니다.
5. 4번에서 i가 0까지 다다를 경우 스택의 모든 원소를 제거했다는 뜻이 되므로 i가 0이면 true를, 그렇지 않으면 false를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.validate_stack_sequences;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.function.Consumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}, Assertions::assertTrue),
        () -> test(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}, Assertions::assertFalse)
    );
  }

  private void test(int[] pushed, int[] popped, Consumer<Boolean> then) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.validateStackSequences(pushed, popped);
    // then
    then.accept(actual);
  }
}
```