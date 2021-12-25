> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/basic_calculator_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://github.com/lcalmsky/leetcode/issues/91) 있습니다.

## Problem

Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-2^31, 2^31 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

**Example 1:**

```text
Input: s = "3+2*2"
Output: 7
```

**Example 2:**

```text
Input: s = " 3/2 "
Output: 1
```

**Example 3:**

```text
Input: s = " 3+5 / 2 "
Output: 5
```

**Constraints:**

* 1 <= s.length <= 3 * 10^5
* s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
* s represents a valid expression.
* All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
* The answer is guaranteed to fit in a 32-bit integer.

## Solution

학부 때 과제로 많이 접해봤던 계산기 문제입니다. 단, 정수만 다루고(나누어도 소숫점 버림) valid한 input만 주어지므로 예외처리에 대한 부담이 적습니다.

계산기 문제는 기본적으로 숫자와 연산자에 대한 파싱, 연산자 우선순위에 신경써야하고 자료구조는 주로 스택을 활용합니다.

```java
import java.util.Stack;

public class Solution {

  public int calculate(String s) {
    Stack<Integer> numbers = new Stack<>();
    Stack<Character> operators = new Stack<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ' ') { // (1)
        continue;
      }
      if (Character.isDigit(c)) { // (2)
        stringBuilder.append(c);
        continue;
      }
      // (3) 
      numbers.push(Integer.parseInt(stringBuilder.toString()));
      stringBuilder = new StringBuilder();
      evaluateOperatorWithHigherPriority(numbers, operators); // (4)
      operators.push(c); // (5)
    }
    // (6)
    if (stringBuilder.length() > 0) {
      numbers.push(Integer.parseInt(stringBuilder.toString()));
    }
    evaluateOperatorWithHigherPriority(numbers, operators); // (4)
    int result = evaluateOperatorWithLowerPriority(numbers, operators); // (7)
    if (!numbers.isEmpty()) {
      result += numbers.pop();
    }
    return result;
  }

  private void evaluateOperatorWithHigherPriority(Stack<Integer> numbers,
      Stack<Character> operators) {
    if (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
      char operator = operators.pop();
      int y = numbers.pop();
      int x = numbers.pop();
      numbers.push(operator == '*' ? x * y : x / y);
    }
  }

  private int evaluateOperatorWithLowerPriority(Stack<Integer> numbers,
      Stack<Character> operators) {
    int result = 0;
    while (!operators.isEmpty()) {
      char operator = operators.pop();
      int number = numbers.pop();
      result = operator == '+' ? result + number : result - number;
    }
    return result;
  }
}

```

1. 문자가 공백일 경우 아무 것도 하지 않습니다.
2. 문자가 숫자일 경우 `StringBuilder`에 더해줍니다.
3. 문자가 연산자일 경우 여태까지 `StringBuilder`에 추가된 문자열을 숫자로 변환해 숫자 `Stack`에 추가하고 `StringBuilder`를 초기화해줍니다.
4. 우선순위 높은 연산자에 대한 연산을 수행합니다.
5. 연산자를 연산자 `Stack`에 추가합니다.
6. `StringBuilder`에 문자열이 남아있을 경우 숫자 `Stack`에 추가해줍니다.
7. 우선순위가 낮은 연산자에 대한 연산을 수행합니다.

---

더 간단하고 성능이 잘 나오는 풀이 방법이 있어서 첨부합니다.

```java
class AnotherSolution {

  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int result = 0, temp = 0, number = 0;
    char operator = '+';
    for (char current : s.toCharArray()) {
      if (current >= '0' && current <= '9') {
        temp = temp * 10 + current - '0';
      } else if (current != ' ') {
        number = cal(number, temp, operator);
        if (current == '+' || current == '-') {
          result += number;
          number = 0;
        }
        temp = 0;
        operator = current;
      }
    }
    return result + cal(number, temp, operator);
  }

  private int cal(int number, int temp, char operator) {
    if (operator == '+') {
      return number + temp;
    }
    if (operator == '-') {
      return number - temp;
    }
    if (operator == '*') {
      return number * temp;
    }
    return number / temp;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.basic_calculator_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("3+2*2", 7),
        () -> test(" 3/2 ", 1),
        () -> test(" 3+5 / 2 ", 5)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.calculate(given);
    // then
    assertEquals(expected, actual);
  }
}
```