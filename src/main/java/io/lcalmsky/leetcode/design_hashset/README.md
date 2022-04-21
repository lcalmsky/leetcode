> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/design_hashset/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/design-hashset/) 있습니다.

## Problem

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


**Example 1:**

```text
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
```

**Constraints:**

* 0 <= key <= 10^6
* At most 104 calls will be made to add, remove, and contains.

## Solution

hash table 관련 라이브러리를 사용하지 않고 `HashSet`을 구현하는 문제입니다.

문제가 너무 간단해서 코드만 첨부하겠습니다.

```java
package io.lcalmsky.leetcode.design_hashset;

public class MyHashSet {

  private final boolean[] elements;

  public MyHashSet() {
    elements = new boolean[1000001];
  }

  public void add(int key) {
    elements[key] = true;
  }

  public void remove(int key) {
    elements[key] = false;
  }

  public boolean contains(int key) {
    return elements[key];
  }
}

```

## Test

```java
package io.lcalmsky.leetcode.design_hashset;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MyHashSetTest {

  @Test
  void test() {
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1);
    myHashSet.add(2);
    assertTrue(myHashSet.contains(1));
    assertFalse(myHashSet.contains(3));
    myHashSet.add(2);
    assertTrue(myHashSet.contains(2));
    myHashSet.remove(2);
    assertFalse(myHashSet.contains(2));
  }
}
```