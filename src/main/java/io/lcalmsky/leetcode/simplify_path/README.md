> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/simplify_path/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/simplify-path/) 있습니다.

## Problem

Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

**Example 1:**
```text
Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
```
**Example 2:**
```text
Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
```
**Example 3:**
```text
Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
```

**Constraints:**

* 1 <= path.length <= 3000
* path consists of English letters, digits, period '.', slash '/' or '_'.
* path is a valid absolute Unix path.

## Solution

Unix 스타일 파일 시스템에서 `.`은 현재 디렉터리를, `..`은 상위 디렉터리를, 연속된 슬래시는 하나의 슬래시 `/`를 나타냅니다.

이 문제에서는 `...`과 같은 다른 형태의 점은 파일명이나 디렉터리 명으로 간주합니다.

`canonical path`는 아래 포맷을 가집니다.

* 단일 슬래시로 시작
* 두 디렉터리는 단일 슬래시로 구분
* 슬래시로 끝나는 경로는 없음
* 경로는 root 에서 대상 파일이나 디렉터리의 경로에 있는 디렉터리만 포함

경로가 주어졌을 때 `canonical path`를 구하는 문제입니다.

```java
import java.util.Stack;

public class Solution {

  public String simplifyPath(String path) {
    String[] names = path.split("/"); // (1)
    Stack<String> stack = new Stack<>();
    for (String name : names) { // (2)
      if ("..".equals(name)) { // (3)
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (!".".equals(name) && !name.isEmpty()) { // (4)
        stack.push(name);
      }
    }
    if (stack.isEmpty()) { // (5)
      return "/";
    }
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) { // (6)
      result.insert(0, "/" + stack.pop());
    }
    return result.toString();
  }
}
```

1. 슬래시를 이용해 경로를 구분해줍니다.
2. 슬래시로 구분 된 파일(또는 디렉터리)명을 순차적으로 탐색합니다.
3. 상위 디렉터리인 경우 스택이 비어있지 않으면 스택에서 파일(또는 디렉터리)명 하나를 제거합니다.
4. 현재 디렉터리가 아니고 파일(또는 디렉터리)명이 비어있지 않으면 스택에 추가합니다.
5. 스택이 비어있으면 루트 디렉터리를 반환합니다.
6. 스택이 빌 때까지 파일(또는 디렉터리)명을 슬래시와 함께 추가하는데 스택은 최근에 추가된 값이 먼저 제거되므로 역순으로 추가해줍니다.

## Test

```java
package io.lcalmsky.leetcode.simplify_path;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("/home/", "/home"),
        () -> test("/../", "/"),
        () -> test("/home//foo/", "/home/foo")
    );
  }

  private void test(String given, String expected) {
    // when
    Solution solution = new Solution();
    String actual = solution.simplifyPath(given);
    // then
    assertEquals(expected, actual);
  }
}
```