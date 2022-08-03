> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/my_calendar_i/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/my-calendar-i/) 있습니다.

## Problem

You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

* MyCalendar() Initializes the calendar object.
* boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

**Example 1:**
```text
Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
```

**Constraints:**

* 0 <= start < end <= 10^9
* At most 1000 calls will be made to book.

## Solution

캘린더로 사용할 프로그램을 구현합니다. 이중 예약이 발생하지 않는 경우 새 이벤트를 추가할 수 있습니다.

```java
import java.util.TreeMap;

class MyCalendar {

  private final TreeMap<Integer, Integer> calendar;

  public MyCalendar() {
    this.calendar = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    Integer previousStart = calendar.floorKey(start);
    Integer previousEnd = calendar.get(previousStart);
    Integer nextStart = calendar.ceilingKey(start);
    if ((previousStart == null || previousEnd <= start) && (nextStart == null || end <= nextStart)) {
      calendar.put(start, end);
      return true;
    }
    return false;
  }
}
```

`TreeMap`을 이용하면 쉽게 풀이할 수 있습니다.

`TreeMap`의 `floorKey()`는 주어진 키보다 작거나 같은 값 중 가장 큰 키를 반환하고, `ceilingKey()`는 주어진 값보다 크거나 같은 값 중 가장 낮은 키를 반환합니다.

`TreeMap`의 키를 `start`, 값을 `end`로 추가하면서 이전 end 값보다 현재 start가 더 높은 숫자일 때, 그리고 end가 다음 start 값보다 더 작은 값일 때만 추가 후 true를 반환하게 합니다.

## Test

```java
package io.lcalmsky.leetcode.my_calendar_i;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MyCalendarTest {

  @Test
  void test() {
    MyCalendar myCalendar = new MyCalendar();
    assertTrue(myCalendar.book(10, 20));
    assertFalse(myCalendar.book(15, 25));
    assertTrue(myCalendar.book(20, 30));
  }
}
```