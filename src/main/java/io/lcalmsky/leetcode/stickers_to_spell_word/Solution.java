package io.lcalmsky.leetcode.stickers_to_spell_word;

import java.util.*;

/**
 * <pre>
 * We are given N different types of stickers. Each sticker has a lowercase English word on it.
 *
 * You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.
 *
 * You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
 *
 * What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.
 *
 * Example 1:
 * Input:
 * ["with", "example", "science"], "thehat"
 * Output:
 * 3
 * Explanation:
 * We can use 2 "with" stickers, and 1 "example" sticker.
 * After cutting and rearrange the letters of those stickers, we can form the target "thehat".
 * Also, this is the minimum number of stickers necessary to form the target string.
 *
 * Example 2:
 * Input:
 * ["notice", "possible"], "basicbasic"
 * Output:
 * -1
 * Explanation:
 * We can't form the target "basicbasic" from cutting letters from the given stickers.
 * Note:
 *
 * stickers has length in the range [1, 50].
 * stickers consists of lowercase English words (without apostrophes).
 * target has length in the range [1, 15], and consists of lowercase English letters.
 * In all test cases, all words were chosen randomly from the 1000 most common US English words, and the target was chosen as a concatenation of two random words.
 * The time limit may be more challenging than usual. It is expected that a 50 sticker test case can be solved within 35ms on average.
 * </pre>
 */
public class Solution {
    public int minStickers(String[] stickers, String target) {
        char[] chars = target.toCharArray();
        Arrays.sort(chars);
        target = String.valueOf(chars);
        stickers = getMinimalStickers(stickers, target);
        final int INF = 1 << 29;
        int[] f = new int[1 << target.length()];
        for (int mask = 1; mask < f.length; mask++) {
            f[mask] = INF;
            for (String sticker : stickers) {
                int newMask = mask;
                for (int i = 0, j = 0; i < sticker.length() && j < target.length(); )
                    if (sticker.charAt(i) < target.charAt(j)) i++;
                    else if (sticker.charAt(i) > target.charAt(j)) j++;
                    else {
                        if ((mask & (1 << j)) != 0) {
                            i++;
                            newMask ^= 1 << j;
                        }
                        j++;
                    }
                f[mask] = Math.min(f[mask], f[newMask] + 1);
            }
        }
        return f[f.length - 1] == INF ? -1 : f[f.length - 1];
    }

    private String[] getMinimalStickers(String[] stickers, String target) {
        int mask = 0;
        for (char ch : target.toCharArray())
            mask |= 1 << (ch - 'a');
        Set<String> candidates = new HashSet<>();
        for (String sticker : stickers) {
            StringBuilder builder = new StringBuilder();
            for (char ch : sticker.toCharArray())
                if (((1 << (ch - 'a')) & mask) != 0)
                    builder.append(ch);
            char[] chars = builder.toString().toCharArray();
            Arrays.sort(chars);
            candidates.add(String.valueOf(chars));
        }

        List<String> result = new ArrayList<>();
        for (String sticker : candidates) {
            boolean keep = true;
            for (String another : result)
                if (isSubsequence(sticker, another)) {
                    keep = false;
                    break;
                }
            if (keep)
                result.add(sticker);
        }
        return result.toArray(new String[0]);
    }

    private boolean isSubsequence(String src, String des) {
        for (int i = 0, j = 0; i < src.length() && j < des.length(); j++)
            if (src.charAt(i) == des.charAt(j)) {
                if (i == src.length() - 1) return true;
                i++;
            }
        return false;
    }
}
