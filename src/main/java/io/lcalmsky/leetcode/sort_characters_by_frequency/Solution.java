package io.lcalmsky.leetcode.sort_characters_by_frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <pre>
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * </pre>
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int valueComparisonResult = Integer.compare(o2.getValue(), o1.getValue());
            boolean areValuesSame = valueComparisonResult == 0;
            return areValuesSame ? Character.compare(o1.getKey(), o2.getKey()) : valueComparisonResult;
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) priorityQueue.offer(entry);

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> polled = priorityQueue.poll();
            Character key = polled.getKey();
            int value = polled.getValue();
            for (int i = 0; i < value; i++) sb.append(key);
        }

        return sb.toString();
    }
}
