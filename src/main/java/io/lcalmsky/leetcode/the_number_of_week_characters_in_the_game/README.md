> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/the_number_of_week_characters_in_the_game/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/the-number-of-week-characters-in-the-game/) 있습니다.

## Problem

You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters.

**Example 1:**
```text
Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
```

**Example 2:**
```text
Input: properties = [[2,2],[3,3]]
Output: 1
Explanation: The first character is weak because the second character has a strictly greater attack and defense.
```

**Example 3:**
```text
Input: properties = [[1,5],[10,4],[4,3]]
Output: 1
Explanation: The third character is weak because the second character has a strictly greater attack and defense.
```

Constraints:

* 2 <= properties.length <= 10^5
* properties[i].length == 2
* 1 <= attacki, defensei <= 10^5

## Solution

공격과 방어 두 개의 메인 속성을 가진 캐릭터로 게임을하는데 이 때 캐릭터는 [공격, 방어] 형태로 주어집니다.

공격과 방어가 다른 캐릭터에 비해 둘 다 낮은 캐릭터를 weak 캐릭터라고 할 때 weak 캐릭터가 모두 몇 개인지 구하는 문제입니다.

```java

```

## Test