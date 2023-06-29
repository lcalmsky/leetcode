> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/lru_cache/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/lru-cache/) 있습니다.

## Problem

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

* LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
* int get(int key) Return the value of the key if the key exists, otherwise return -1.
* void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

Example 1:

```text
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
```

**Constraints:**

* 1 <= capacity <= 3000
* 0 <= key <= 10^4
* 0 <= value <= 10^5
* At most 2 * 10^5 calls will be made to get and put.

## Solution

LRU(Least Recently Used; 가장 최근에 사용되지 않은 데이터를 제거하는 알고리즘) `Cache`를 구현하는 문제입니다.

`Capacity`가 넘어갈 때마다 최근에 사용되지 않은 `Node`를 지워줘야 합니다.

`get`과 `put` 모두 시간 복잡도 O(1)에 수행되어야 하므로 자료구조에 신경써야하는 문제입니다.

시간복잡도 O(1)하면 바로 떠올려야하는 `Map` 인터페이스를 이용해야 하는데 `LinkedHashMap`을 사용하면 아주 간단히 구현할 수 있습니다.

```java
package io.lcalmsky.leetcode.lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap {
    private final Map<Integer, Integer> cache;

    public LRUCacheWithLinkedHashMap(int capacity) {
        cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

```

`LinkedHashMap`을 생성할 때 파라미터로 `capacity`, `loadFactor`(해시 맵 내부에서 해시 테이블의 사용량을 조절하는데 사용), `accessOrder`(순서 보장)를 넘겨주고, `removeEldestEntry`라는 메서드만 `Cache` 사이즈가 `capacity`를 넘어갔을 때 삭제하도록 `override` 하면 간단히 통과됩니다. (심지어 공간복잡도 점수는 매우 높게 나옵니다.)

하지만 문제 출제 의도는 이게 아니겠죠?

직접 구현하기 위해선 마찬가지로 `Map` 인터페이스를 사용하긴 해야합니다만, 문제는 가장 오래된 데이터를 어떻게 찾아서 지우느냐 입니다.

이 때 떠올려야 할 자료구조는 `DoublyLinkedList`(Node) 입니다. 

`Node`가 추가되는 시점에는 `head`나 `tail`로, 삭제되는 시점에는 `Node`의 앞, 뒤 연결을 끊어주게되면 n번 돌면서 찾아서 지울 필요가 없기 때문에 시간복잡도 O(1)을 만족시킬 수 있습니다.

풀이는 더미 `head`, `tail`를 사용하여 지우고 추가할 때마다 `null` 체크를 하지 않아도 되도록 작성되었습니다.

```java
package io.lcalmsky.leetcode.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Node> cache;
    private final int capacity;
    private final Node dummyHead;
    private final Node dummyTail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node); // 최근 조회한 Node를 head로 옮김
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node); // 최근 업데이트한 Node를 head로 옮김
            return;
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        cache.put(key, newNode); // cache에 Node를 추가
        addNodeToHead(newNode); // 최근 추가한 Node를 head로 옮김
        removeTailIfCapacityExceeded(); // capacity가 넘어갔을 경우 tail을 지움
    }

    private void moveToHead(Node node) {
        removeNode(node); // 현재 Node를 삭제하고 O(1)
        addNodeToHead(node); // head에 추가함 O(1)
    }

    private void removeNode(Node node) {
        Node prev = node.prev; // 현재 Node의 이전 Node
        Node next = node.next; // 현재 Node의 다음 Node
        prev.next = next; // 이전 Node를 다음 Node에 연결시켜 이전 Node와 현재 Node와의 연결을 끊음
        next.prev = prev; // 다음 Node를 이전 Node에 연결시켜 다음 Node와 현재 Node와의 연결을 끊음
    }

    private void addNodeToHead(Node node) { // dummyHead와 실제 head 사이에 현재 head를 추가함
        node.prev = dummyHead; // 현재 Node의 이전 Node를 dummyHead로 설정
        node.next = dummyHead.next; // 현재 Node의 다음 Node를 dummyHead의 다음 Node(실제 head)로 설정
        dummyHead.next.prev = node; // 실제 head의 이전 Node를 현재 Node로 설정
        dummyHead.next = node; // dummyHead의 다음 Node를 현재 Node로 설정(실제 head가 됨)
    }

    private void removeTailIfCapacityExceeded() {
        if (cache.size() > this.capacity) {
            Node removedTail = removeTail();
            this.cache.remove(removedTail.key); // cache에서 Node를 제거
        }
    }

    private Node removeTail() {
        Node realTail = dummyTail.prev; // 실제 tailNode를 구함
        removeNode(realTail); // 실제 tailNode를 삭제함
        return realTail;
    }

    private final static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.lru_cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {
    @Test
    void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int i = lruCache.get(1);
        assertEquals(1, i);
        lruCache.put(3, 3);
        int j = lruCache.get(2);
        assertEquals(-1, j);
        lruCache.put(4, 4);
        int k = lruCache.get(1);
        assertEquals(-1, k);
        int l = lruCache.get(3);
        assertEquals(3, l);
        int m = lruCache.get(4);
        assertEquals(4, m);
    }

    @Test
    void test2() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        int i = lruCache.get(1);
        assertEquals(-1, i);
        int j = lruCache.get(2);
        assertEquals(3, j);
    }
}
```