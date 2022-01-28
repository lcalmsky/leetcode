> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode//Users/jaime/git-repo/leetcode/design_add_and_search_words_data_structure/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/design-add-and-search-words-data-structure/) 있습니다.

## Problem

Design a data structure that supports adding new words and finding if a string matches any
previously added string.

Implement the WordDictionary class:

* WordDictionary() Initializes the object.
* void addWord(word) Adds word to the data structure, it can be matched later.
* bool search(word) Returns true if there is any string in the data structure that matches word or
  false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example:

```text
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
```

**Constraints:**

* 1 <= word.length <= 500
* word in addWord consists lower-case English letters.
* word in search consist of  '.' or lower-case English letters.
* At most 50000 calls will be made to addWord and search.

## Solution

새로운 단어를 추가하고 기존 단어를 찾아주는 데이터 구조(사전)를 설계하는 문제입니다.

생성자와 두 개의 메서드를 구현해야 합니다.

* WordDictionary(): 객체 초기화
* void addWord(word): 단어 추가
* boolean search(word): 일치하는 단어가 있는지 확인, '.'이 포함될 수 있고 어떤 문자와도 매칭될 수 있음

[트라이(trie) 구조](https://ko.wikipedia.org/wiki/%ED%8A%B8%EB%9D%BC%EC%9D%B4_(%EC%BB%B4%ED%93%A8%ED%8C%85))를
이용해 풀 수 있습니다.

```java
public class WordDictionary {

  private final TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) { // (1)
      int index = c - 'a'; // (2)
      if (node.children[index] == null) { // (3)
        node.children[index] = new TrieNode();
      }
      node = node.children[index]; // (4)
    }
    node.word = word; // (5)
  }

  public boolean search(String word) {
    return match(word.toCharArray(), 0, root);
  }

  private boolean match(char[] charArray, int index, TrieNode node) {
    if (index == charArray.length) { // (6)
      return node.word != null;
    }
    if (charArray[index] != '.') { // (7)
      int i = charArray[index] - 'a';
      return node.children[i] != null && match(charArray, index + 1, node.children[i]);
    }
    for (int i = 0; i < node.children.length; i++) { // (8) 
      if (node.children[i] != null) {
        if (match(charArray, index + 1, node.children[i])) {
          return true;
        }
      }
    }
    return false;
  }


  public static class TrieNode {

    TrieNode[] children;
    String word;

    public TrieNode() {
      children = new TrieNode[26];
    }
  }
}
```

1. 단어의 각 문자를 순차적으로 탐색하면서
2. 각 단어의 인덱스를 구한 뒤
3. 자식 노드 중 해당 인덱스가 비어있으면 노드를 생성해주고
4. 비어있지 않으면 노드를 자식 노드로 바꿔줍니다.
5. 마지막 자식노드에 다다랐을 때 단어를 저장합니다.
6. 마지막 문자열까지 다다랐을 때 node의 단어가 null인지 여부를 반환합니다.
7. 인덱스에 해당하는 문자가 '.'이 아닌 경우, 해당하는 알파벳의 자식노드가 null이 아니면 다음 문자열을 검사해줍니다.
8. 인덱스에 해당하는 문자가 '.'인 경우, 자식 노드가 null이 아닌 노드를 찾아 다음 문자열을 검사합니다.

---

다른 답을 보니 훨씬 더 간단히 구현할 수 있네요.

```java
class WordDictionary {

  private final List<String>[] list;

  public WordDictionary2() {
    //noinspection unchecked
    list = new LinkedList[501];
    for (int i = 0; i < list.length; i++) {
      list[i] = new LinkedList<>();
    }
  }

  public void addWord(String word) {
    List<String> words = list[word.length()];
    words.add(word);
  }

  public boolean search(String word) {
    List<String> words = list[word.length()];
    for (String currentWord : words) {
      if (compare(currentWord, word)) {
        return true;
      }
    }
    return false;
  }

  private boolean compare(String source, String pattern) {
    for (int i = 0; i < source.length(); i++) {
      char letter = pattern.charAt(i);
      if (letter == '.') {
        continue;
      }
      if (source.charAt(i) != letter) {
        return false;
      }
    }
    return true;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.design_add_and_search_words_data_structure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordDictionaryTest {

  @Test
  void test() {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    assertFalse(wordDictionary.search("pad"));
    assertTrue(wordDictionary.search("bad"));
    assertTrue(wordDictionary.search(".ad"));
    assertTrue(wordDictionary.search("b.."));
  }
}
```