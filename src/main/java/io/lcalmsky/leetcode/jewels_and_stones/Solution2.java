package io.lcalmsky.leetcode.jewels_and_stones;

public class Solution2 {
    public int numJewelsInStones(String jewels, String stones) {
        int[] alphabets = new int['z' - 'A' + 1];
        for (char c : stones.toCharArray()) {
            alphabets[c - 'A']++;
        }
        int sum = 0;
        for (char c : jewels.toCharArray()) {
            sum += alphabets[c - 'A'];
        }
        return sum;
    }
}
