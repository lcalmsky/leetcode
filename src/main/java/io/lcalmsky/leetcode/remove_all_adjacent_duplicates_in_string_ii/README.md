> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/remove_all_adjacent_duplicates_in_string_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/) 있습니다.

## Problem

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.


**Example 1:**
```text
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
```

**Example 2:**
```text
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
```

**Example 3:**
```text
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
```

**Constraints:**

* 1 <= s.length <= 10^5
* 2 <= k <= 10^4
* s only contains lower case English letters.

## Solution

문자열 s와 정수 k가 주어지고 k는 연속하여 중복되는 문자열의 개수로 k에 해당하는 문자열은 지워져야 합니다.

반복적으로 중복 문자를 수행해서 더 이상 진행할 수 없을 때가 되었을 때 문자열을 반환하는 문제입니다.

먼저 가장 직관적으로 떠올릴 수 있는 방법은 스택을 이용한 방법입니다.

```java
import java.util.Stack;

public class Solution {

  public String removeDuplicates(String s, int k) {
    Stack<CharacterWithFrequency> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek().c == ch) { // (1)
        stack.peek().frequency++;
      } else { // (2)
        stack.push(new CharacterWithFrequency(ch, 1));
      }
      if (stack.peek().frequency == k) { // (3)
        stack.pop();
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    while (!stack.isEmpty()) { // (4)
      CharacterWithFrequency popped = stack.pop();
      stringBuilder.append(String.valueOf(popped.c).repeat(Math.max(0, popped.frequency)));
    }
    return stringBuilder.reverse().toString(); // (5)
  }

  private static class CharacterWithFrequency {

    char c;
    int frequency;

    public CharacterWithFrequency(char c, int frequency) {
      this.c = c;
      this.frequency = frequency;
    }
  }
}

```

1. 스택이 비어있지 않고 top에 있는 원소가 현재 문자열과 동일하면 빈도를 증가시킵니다.
2. 스택이 비어있으면 문자열과 빈도수를 저장한 객체를 생성해 push 합니다.
3. top에 있는 원소의 빈도수가 k와 일치할 경우 스택에서 제거합니다.
4. 스택의 원소들을 제거하면서 문자열을 만듭니다. 빈도수 만큼 반복해서 추가해줘야 합니다.
5. 스택에 들어있던 문자열이므로 한 번 reverse 시켜줍니다.

---

다음은 포인터를 이용한 방법입니다.

```java
public class Solution {

  public String removeDuplicates(String s, int k) {
    char[] array = s.toCharArray();
    int[] duplicates = new int[array.length];
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      array[slow] = array[fast]; // (1)
      duplicates[slow] = slow != 0 && array[slow - 1] == array[slow] // (2) 
          ? duplicates[slow - 1] + 1
          : 1;
      if (duplicates[slow] == k) { // (3)
        slow -= k;
      }
      slow++;
      fast++;
    }
    return new String(array, 0, slow); // (4)
  }
}
```

1. 느린 포인터가 가리키는 곳에 빠른 포인터가 가리키는 값을 할당합니다.
2. 이전 값과 동일한 경우 중복을 저장하는 배열의 이전 값을 더해주고 그렇지 않은 경우 현재 값을 1로 할당합니다.
3. 중복 배열의 해당 값이 k와 같을 경우 이전 포인터를 앞으로 k칸 이동합니다.
4. 중복을 제외한 값들이 배열 앞쪽으로 0~slow 포인터가 가리키는 곳으로 다 모여있으므로 해당 부분만 문자열로 변환해서 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.remove_all_adjacent_duplicates_in_string_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("abcd", 2, "abcd"),
        () -> test("deeedbbcccbdaa", 3, "aa"),
        () -> test("pbbcggttciiippooaais", 2, "ps")
    );
  }

  private void test(String given, int k, String expected) {
    // when
    Solution solution = new Solution();
    String actual = solution.removeDuplicates(given, k);
    // then
    assertEquals(expected, actual);
  }
}
```