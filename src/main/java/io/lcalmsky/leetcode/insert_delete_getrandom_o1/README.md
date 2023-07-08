> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/insert_delete_getrandom_o1/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/insert-delete-getrandom-o1/) 있습니다.

## Problem

Implement the RandomizedSet class:

* RandomizedSet() Initializes the RandomizedSet object.
* bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
* bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
* int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

You must implement the functions of the class such that each function works in average O(1) time complexity.

**Example 1:**
```text
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
```

**Constraints:**

* -2^31 <= val <= 2^31 - 1
* At most 2 * 105 calls will be made to insert, remove, and getRandom.
* There will be at least one element in the data structure when getRandom is called.

## Solution

O(1) 시간 복잡도로 삽입(insert), 삭제(remove), 무작위 조회(getRandom) 연산을 수행할 수 있는 데이터 구조를 작성하는 문제입니다.

O(1) 내에 연산을 수행하기 위해 Map 구조를 사용해야 하고, getRandom을 위해 추가로 List 구조가 필요합니다.

```java
package io.lcalmsky.leetcode.insert_delete_getrandom_o1;

import java.util.*;

public class RandomizedSet {

    private final List<Integer> values;
    private final Map<Integer, Integer> indexMap;
    private final Random random;

    public RandomizedSet() {
        this.values = new ArrayList<>();
        this.indexMap = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        Integer currentIndex = indexMap.get(val);
        int lastIndex = values.size() - 1;
        swap(currentIndex, lastIndex);
        indexMap.remove(val);
        values.remove(lastIndex);
        return true;
    }

    private void swap(Integer currentIndex, int lastIndex) {
        Integer lastValue = values.get(lastIndex);
        values.set(currentIndex, lastValue);
        indexMap.put(lastValue, currentIndex);
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}

```

위 코드는 RandomizedSet 클래스를 구현한 것으로, O(1) 시간 복잡도로 삽입(insert), 삭제(remove), 무작위 조회(getRandom) 연산을 수행할 수 있는 데이터 구조를 생성하는 알고리즘입니다.

1. 클래스 멤버 변수 선언
    * values: 정수 값을 저장하기 위한 동적 배열(ArrayList)
    * indexMap: 값과 해당 값의 인덱스를 저장하기 위한 해시맵(HashMap)
    * random: 임의의 값을 선택하기 위한 Random 객체
2. 생성자(RandomizedSet)에서 클래스 멤버 변수들을 초기화합니다.
3. insert 메서드는 삽입 연산을 처리합니다. indexMap을 사용하여 이미 해당 값이 존재하는지 확인하고, 존재할 경우 삽입을 실패하고 false를 반환합니다. 존재하지 않을 경우, indexMap에 값과 해당 값의 인덱스를 저장하고 values에 값을 추가한 후, 삽입 성공을 나타내는 true를 반환합니다.
4. remove 메서드는 삭제 연산을 처리합니다. indexMap을 사용하여 해당 값이 존재하는지 확인하고, 존재하지 않을 경우 삭제를 실패하고 false를 반환합니다. 존재할 경우, indexMap에서 해당 값을 찾아 현재 인덱스를 currentIndex 변수에 저장하고, values의 마지막 인덱스를 lastIndex 변수에 저장합니다. swap 메서드를 호출하여 currentIndex와 lastIndex 위치의 값을 교환하고, indexMap에서 해당 값을 제거한 후, values에서 마지막 값을 제거합니다. 삭제 성공을 나타내는 true를 반환합니다.
5. swap 메서드는 values 리스트 내에서 두 인덱스의 값을 교환하고, indexMap에서 해당 값의 인덱스를 업데이트합니다.
6. getRandom 메서드는 values 리스트에서 임의의 값을 반환합니다. random.nextInt(values.size())를 사용하여 values 리스트의 인덱스 범위 내에서 임의의 인덱스를 선택한 후 해당 인덱스의 값을 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.insert_delete_getrandom_o1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RandomizedSetTests {
    @Test
    public void givenTests_whenDoTest_thenWork() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(1));
        assertFalse(randomizedSet.remove(2));
        assertTrue(randomizedSet.insert(2));
        assertTrue(Arrays.asList(1, 2).contains(randomizedSet.getRandom()));
        assertTrue(randomizedSet.remove(1));
        assertFalse(randomizedSet.insert(2));
        assertEquals(randomizedSet.getRandom(), 2);
    }
}

```