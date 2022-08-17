> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/unique_morse_code_words/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/unique-morse-code-words/) 있습니다.

## Problem

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

'a' maps to ".-",
'b' maps to "-...",
'c' maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:

```
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
```

Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

* For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
Return the number of different transformations among all words we have.



**Example 1:**
```text
Input: words = ["gin","zen","gig","msg"]
Output: 2
Explanation: The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations: "--...-." and "--...--.".
```

**Example 2:**
```text
Input: words = ["a"]
Output: 1
```

**Constraints:**

* 1 <= words.length <= 100
* 1 <= words[i].length <= 12
* words[i] consists of lowercase English letters.

## Solution

주어진 단어를 모스 코드로 변환한 뒤 서로 다른 모스코드의 개수를 구하는 문제입니다.

```java
import java.util.HashSet;
import java.util.Set;

public class Solution {

  private static final String[] MORSE_CODES = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
      "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
      "..-", "...-", ".--", "-..-", "-.--", "--.."};

  public int uniqueMorseRepresentations(String[] words) {
    Set<String> uniqueMorseRepresentations = new HashSet<>();
    for (String word : words) {
      StringBuilder stringBuilder = new StringBuilder();
      for (char c : word.toCharArray()) {
        stringBuilder.append(MORSE_CODES[c - 'a']);
      }
      uniqueMorseRepresentations.add(stringBuilder.toString());
    }
    return uniqueMorseRepresentations.size();
  }
}
```

단어를 순차적으로 탐색하면서 단어의 각 단어를 모스부호로 변환하여 붙이고 Set을 이용해 unique한 모스 부호의 개수를 확인할 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.unique_morse_code_words;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new String[]{"gin", "zen", "gig", "msg"}, 2),
        () -> test(new String[]{"a"}, 1)
    );
  }

  private void test(String[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.uniqueMorseRepresentations(given);
    // then
    assertEquals(expected, actual);
  }
}
```