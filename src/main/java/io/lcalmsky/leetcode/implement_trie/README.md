> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/implement_trie/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/implement-trie-prefix-tree/) 있습니다.

## Problem

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

* Trie() Initializes the trie object.
* void insert(String word) Inserts the string word into the trie.
* boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
* boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

**Example 1:**

```text
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
```

**Constraints:**

* 1 <= word.length, prefix.length <= 2000
* word and prefix consist only of lowercase English letters.
* At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.

## Solution

`trie`는 문자열 데이터 집합에서 키를 효율적으로 저장하고 검색하는 데 사용되는 트리 데이터 구조 입니다.

자동 완성 및 앚춤법 검사 등에 활용됩니다.

생성자와 주어진 세 개의 메서드를 구현하는 문제입니다.

`insert`는 단어를 `trie`에 저장하는 메서드이고, `search`는 `trie`에 해당 문자열이 존재하는지 여부를 반환하는 메서드, `startsWith`는 `trie`에 추가된 단어가 해당 문자열로 시작하는지 여부를 반환하는 메서드입니다.

먼저 `tree` 구조이기 때문에 노드를 나타내는 클래스가 필요합니다.

문자열은 오직 소문자 영어로만 주어지므로 주어진 문자열의 첫 번째 알파벳이 될 수 있는 경우의 수는 26, 그 이후도 마찬가지로 계속 26개의 경우의 수를 갖습니다.

apple의 경우 Node가 저장해야 할 값은 'a' - 'p' - 'p' - 'l' - 'e' 이고 각 노드의 child 노드가 가지고 있게 되면 탐색이 훨씬 수월해집니다.

그리고 search 메서드에서 단어인지 여부를 반환해야 하기 때문에 마지막 child node가 추가되었을 때 단어임을 체크할 수 있는 변수가 필요합니다.

apple만 추가한 상태에서 a, ap, app, appl은 모두 단어가 아닙니다.

마지막에 e가 추가되었을 때 단어가 됩니다.

이를 구현하면,

```java
private static class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}
```

이렇게 나타낼 수 있습니다.

문제의 요구사항을 모두 구현하면, 아래와 같습니다.

```java
public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a'; // (1)
            if (current.children[position] == null) { // (2)
                current.children[position] = new TrieNode();
            }
            current = current.children[position]; // (3)
        }
        current.isWord = true; // (4)
    }

    public boolean search(String word) {
        TrieNode current = find(word); // (1)
        return current != null && current.isWord; // (2)
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null; // (1)
    }
    
    private TrieNode find(String word) {
        TrieNode current = root; // (1)
        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a'; // (2)
            if (current.children[position] == null) { // (3)
                return null;
            }
            current = current.children[position]; // (4)
        }
        return current; // (5)
    }

    private static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
}
```

**insert**
1. 주어진 문자열의 i 번째 문자의 알파벳 인덱스를 구합니다. 예를 들어 a일 경우 'a' - 'a'가 되어 0번 인덱스에 저장됩니다.
2. 해당 위치에 노드가 없다면 현재 노드의 자식 노드로 새로운 노드를 추가해줍니다.
3. 현재 노드를 자식 노드로 업데이트 합니다.
4. 마지막까지 진행하면 문자열의 마지막 문자에 해당하는 노드가 현재 노드가 되므로 해당 노드의 isWord 값을 true로 바꿔줍니다.

**search**
1. 단어를 찾습니다.
2. 단어가 없으면 false를 반환하고, 존재하는 경우 isWord 값을 반환합니다. apple을 추가했을 때 app이 존재하더라도 app은 아직 단어가 아닙니다.

**startsWith**
1. 단어를 찾아 존재하는지 여부를 반환합니다. apple이 추가된 상태에서 app까지만 찾더라도 app으로 시작함을 의미합니다. 단어인지 여부는 상관없습니다.

**find**  
search와 startsWith에서 공통적으로 사용한 로직을 메서드로 추출한 것 입니다.
1. 현재 노드를 root를 가리키게 합니다.
2. 주어진 문자열의 i 번빼 문자의 알파벳 인덱스를 구합니다.
3. 해당 문자에 해당하는 노드가 비어있을 경우 문자를 찾을 수 없는 것이므로 null을 반환합니다.
4. 현재 노드의 위치를 자식 노드의 위치로 갱신합니다.
5. 현재 노드를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.implement_trie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieTest {
    @Test
    void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }
}
```