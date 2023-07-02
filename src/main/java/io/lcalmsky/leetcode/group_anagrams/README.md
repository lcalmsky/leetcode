> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/group_anagrams/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/group-anagrams/) 있습니다.

## Problem

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

```text
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

**Example 2:**

```text
Input: strs = [""]
Output: [[""]]
```

**Example 3:**

```text
Input: strs = ["a"]
Output: [["a"]]
```

**Constraints:**

* 1 <= strs.length <= 10^4
* 0 <= strs[i].length <= 100
* strs[i] consists of lowercase English letters.

## Solution

아나그램은 문자의 순서를 바꿔서 다른 단어를 만들 수 있는 단어를 말합니다. 예를 들어, "eat", "tea", "ate"는 서로 아나그램입니다.

문자열 배열이 주어졌을 때 아나그램 그룹을 반환하는 문제입니다.

```java
package io.lcalmsky.leetcode.group_anagrams;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = new char[26];
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                array[c - 'a']++;
            }
            String newStr = new String(array);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

```

해당 코드는 다음과 같은 방식으로 아나그램 그룹을 찾습니다.

1. Map<String, List<String>>인 map을 생성합니다. 이 맵은 아나그램을 키로 가지고 해당 아나그램에 속하는 단어들의 리스트를 값으로 가지게 됩니다.
2. strs 배열을 순회하면서 각 문자열을 처리합니다.
3. 문자열을 구성하는 문자들을 세는 배열 array를 생성합니다. 이 배열의 인덱스는 알파벳 소문자의 아스키 코드 값에서 'a'의 아스키 코드 값을 뺀 결과입니다. 각 문자의 등장 횟수를 해당 인덱스의 값으로 기록합니다.
4. array를 문자열로 변환하여 newStr에 저장합니다.
5. map에서 newStr을 키로 가지는 리스트를 찾습니다. 만약 해당 키가 존재하지 않는다면, 새로운 ArrayList를 생성하여 해당 키로 맵에 추가합니다.
6. map에서 newStr을 키로 가지는 리스트를 가져온 후, 해당 리스트에 현재 문자열을 추가합니다.
7. map의 모든 값들을 담고 있는 리스트를 생성하여 반환합니다.

이렇게 함으로써 groupAnagrams() 메서드는 주어진 문자열 배열에서 아나그램 그룹을 찾아서 그룹별로 리스트를 반환합니다.


## Test

```java
package io.lcalmsky.leetcode.group_anagrams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"))),
                () -> test(new String[]{""}, List.of(List.of(""))),
                () -> test(new String[]{"a"}, List.of(List.of("a")))
        );
    }

    private void test(String[] strs, List<List<String>> expected) {
        // when
        Solution solution = new Solution();
        List<List<String>> actual = solution.groupAnagrams(strs);
        // then
        assertTrue(actual.stream().flatMap(List::stream).collect(Collectors.toList())
                .containsAll(expected.stream().flatMap(List::stream).collect(Collectors.toList())));
    }
}
```