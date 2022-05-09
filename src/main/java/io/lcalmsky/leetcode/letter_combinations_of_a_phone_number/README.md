> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/letter_combinations_of_a_phone_number/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) 있습니다.

## Problem

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

**Example 1:**
```text
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
```
**Example 2:**
```text
Input: digits = ""
Output: []
```
**Example 3:**
```text
Input: digits = "2"
Output: ["a","b","c"]
```

**Constraints:**

* 0 <= digits.length <= 4
* digits[i] is a digit in the range ['2', '9'].

## Solution

2에서 9사이의 숫자가 주어질 때 나타낼 수 있는 모든 가능한 문자의 조합을 반환하는 문제입니다.

먼저 큐를 이용한 방법입니다.

```java
package io.lcalmsky.leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public static final String[] TABLE = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno",
      "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return Collections.emptyList();
    }
    char[] digitChars = digits.toCharArray();
    int[] numbers = new int[digitChars.length];
    for (int i = 0; i < digitChars.length; i++) { // (1)
      numbers[i] = digitChars[i] - '0';
    }
    int length = numbers.length;
    return letterCombinationsUtil(numbers, length);
  }

  public List<String> letterCombinationsUtil(int[] numbers, int length) {
    List<String> list = new ArrayList<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(""); // (2)
    String letterCombination, letters;
    while (!queue.isEmpty()) { // (3)
      letterCombination = queue.poll();
      if (letterCombination.length() == length) { // (4)
        list.add(letterCombination);
        continue;
      }
      letters = TABLE[numbers[letterCombination.length()]]; // (5)
      for (int i = 0; i < letters.length(); i++) { // (6)
        queue.add(letterCombination + letters.charAt(i));
      }
    }
    return list; // (7)
  }
}

```

1. 주어진 숫자를 배열에 할당합니다.
2. 빈 문자열을 기본 값으로 큐에 추가합니다.
3. 큐가 빌 때까지 반복하면서
4. 큐의 head에 있던 문자열의 길이가 처음 주어진 숫자의 길이와 같을 때 결과 리스트에 문자 조합을 추가합니다.
5. 현재 조합중인 문자열의 길이에 해당하는 다이얼 숫자를 찾고, 다이얼에 해당하는 문자열을 찾습니다.
6. 다이얼의 문자를 순차적으로 조합하여 큐에 다시 추가합니다.
7. 결과를 반환합니다.

---

다음은 DFS를 이용한 방법입니다.

```java
import java.util.ArrayList;
import java.util.List;

class Solution {

  public static String[] TABLE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    dfs(digits, 0, new StringBuilder(), result);
    return result;
  }

  public void dfs(String digits, int index, StringBuilder stringBuilder, List<String> result) {
    if (index == digits.length()) {
      result.add(stringBuilder.toString());
      return;
    }
    String letters = TABLE[digits.charAt(index) - '0'];
    for (int i = 0; i < letters.length(); i++) {
      stringBuilder.append(letters.charAt(i));
      dfs(digits, index + 1, stringBuilder, result);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
  }
}
```

인덱스 값을 높여가며 재귀호출하여 인덱스 값이 주어진 숫자의 길이와 같아졌을 때 결과를 저장하고 마지막 문자열을 하나 제거하는 과정을 반복하여 구할 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.letter_combinations_of_a_phone_number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenLetters_whenGetCombinationOfPhoneNumbers_thenCorrect() {
    assertAll(
        () -> test("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
        () -> test("", Collections.emptyList()),
        () -> test("234",
            List.of("adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg",
                "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg",
                "ceh", "cei", "cfg", "cfh", "cfi")),
        () -> test("2", List.of("a", "b", "c"))
    );
  }

  private void test(String given, List<String> expected) {
    // when
    Solution letterCombinationsOfAPhoneNumbers = new Solution();
    List<String> actual = letterCombinationsOfAPhoneNumbers.letterCombinations(given);

    // then
    assertThat(expected).containsAll(actual);
  }
}
```