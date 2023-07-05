package io.lcalmsky.leetcode.word_break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict));
    }

    private boolean wordBreak(String s, Set<String> set) {
        int restLength = s.length();
        if (restLength == 0) {
            return true;
        }
        for (int i = 1; i <= restLength; ++i) {
            if (set.contains(s.substring(0, i)) && wordBreak(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}
