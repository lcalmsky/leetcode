package io.lcalmsky.leetcode.jewels_and_stones;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : jewels.toCharArray()) {
            map.put(c, 0);
        }
        for (char c : stones.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
        }
        return map.values().stream().reduce(0, Integer::sum);
    }
}
