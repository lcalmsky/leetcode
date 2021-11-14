> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/iterator_for_combination/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/iterator-for-combination/) 있습니다.

## Problem
Design the CombinationIterator class:

CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.

**Example 1:**

```text
Input
["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[["abc", 2], [], [], [], [], [], []]
Output
[null, "ab", true, "ac", true, "bc", false]

Explanation
CombinationIterator itr = new CombinationIterator("abc", 2);
itr.next();    // return "ab"
itr.hasNext(); // return True
itr.next();    // return "ac"
itr.hasNext(); // return True
itr.next();    // return "bc"
itr.hasNext(); // return False
```

**Constraints:**

* 1 <= combinationLength <= characters.length <= 15
* All the characters of characters are unique.
* At most 104 calls will be made to next and hasNext.
* It's guaranteed that all calls of the function next are valid.

## Solution

주어진 문자열을 주어진 숫자에 맞게 문자를 쪼개 유일하고 정렬된 Iterator 자료구조를 구현하는 문제입니다.

생성자에서 주어진 숫자로 문자를 나누어 저장하는 부분이 구현되어야 하고, next, hasNext 메서드는 일반 Iterator 인터페이스와 동일하게 구현하면 됩니다.

```java
package io.lcalmsky.leetcode.iterator_for_combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

  private final int combinationLength;
  private final List<String> words;
  private int currentIndex;

  public CombinationIterator(String characters, int combinationLength) {
    this.combinationLength = combinationLength;
    boolean[] visited = new boolean[characters.length()];
    this.words = new ArrayList<>();
    this.currentIndex = 0;
    generateWords(characters, 0, new StringBuilder(), visited);
  }

  private void generateWords(String characters, int startIndex, StringBuilder stringBuilder,
      boolean[] visited) {
    if (stringBuilder.length() == combinationLength) { // (8)
      words.add(stringBuilder.toString());
      return;
    }
    while (startIndex < characters.length()) { // (7)
      if (visited[startIndex]) { // (6)
        startIndex++;
        continue;
      }
      visited[startIndex] = true; // (1)
      stringBuilder.append(characters.charAt(startIndex)); // (2)
      generateWords(characters, startIndex++, stringBuilder, visited); // (3)
      visited[startIndex - 1] = false; // (4)
      stringBuilder.setLength(stringBuilder.length() - 1); // (5)
    }
  }

  public String next() {
    return words.get(currentIndex++); // (9)
  }

  public boolean hasNext() {
    return currentIndex < words.size(); // (1)
  }
}
```

1. 방문하지 않은 문자열을 방문했다고 업데이트 합니다.
2. 시작 인덱스에 해당하는 문자열을 추가합니다.
3. 시작 인덱스를 1 더해 재귀호출로 다시 메서드를 호출합니다.
4. 이미 조건에 해당하는 길이를 다 채운 경우(8) 마지막에 방문한 문자열을 다시 방문하지 않았다고 업데이트 합니다.
5. 조합된 문자열의 길이를 1 줄입니다.
6. 방문한 문자열에 다시 방문했을 경우 시작 인덱스를 더해줍니다.
7. 1~6을 시작 인덱스가 전체 문자열의 길이보다 작을동안 반복합니다.
8. 재귀호출로 다시 진입했을 때 요구하는 길이를 만족하면 조합을 저장하는 리스트에 추가합니다.
9. iterator를 생성하면 현재 인덱스가 0부터 시작하므로 next를 호출하면 해당 인덱스의 엘리먼트를 반환하고 현재 인덱스를 1 올려줍니다.
10. 현재 인덱스가 전체 조합의 갯수보다 작을동안은 다음 엘리먼트가 존재합니다.

---

visited 배열을 사용하지 않고 재귀호출을 두 번 하는 방법으로 메모리를 아낄 수 있습니다.

```java
class CombinationIterator2 {
  
  private final List<String> words = new ArrayList<>();
  private int currentIndex = 0;

  public CombinationIterator2(String characters, int combinationLength) {
    char[] chs = characters.toCharArray();
    Arrays.sort(chs);
    dfs(chs, new StringBuilder(), 0, combinationLength);
  }

  public String next() {
    return words.get(currentIndex++);
  }

  public boolean hasNext() {
    return currentIndex < words.size();
  }

  public void dfs(char[] characters, StringBuilder stringBuilder, int start, int length) {
    if (stringBuilder.length() == length) {
      words.add(stringBuilder.toString());
      return;
    }
    if (start >= characters.length) {
      return;
    }
    dfs(characters, stringBuilder.append(characters[start]), start + 1, length); // (1)
    stringBuilder.deleteCharAt(stringBuilder.length() - 1); // (2)
    dfs(characters, stringBuilder, start + 1, length); // (3)
  }
}
```

1. 현재 문자열을 더한 상태로 재귀호출 합니다.
2. 마지막 문자열을 빼줍니다.
3. 1번을 수행하기 전 상태로 다시 재귀호출을 합니다.

## Test

```java
package io.lcalmsky.leetcode.iterator_for_combination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CombinationIteratorTest {

  @Test
  void test() {
    CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
    assertEquals("ab", combinationIterator.next());
    assertTrue(combinationIterator.hasNext());
    assertEquals("ac", combinationIterator.next());
    assertTrue(combinationIterator.hasNext());
    assertEquals("bc", combinationIterator.next());
    assertFalse(combinationIterator.hasNext());
  }
}
```