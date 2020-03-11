package io.lcalmsky.leetcode.remove_duplicate_letters;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) return s;

        char[] arr = s.toCharArray();
        int[] count = new int[256];
        boolean[] visited = new boolean[256];
        for (char c : arr) count[c]++;

        StringBuilder sb = new StringBuilder("0");
        for (char c : arr) {
            count[c]--;
            if (visited[c]) continue;
            char lastChar = sb.charAt(sb.length() - 1);
            while (c < lastChar && count[lastChar] > 0) {
                sb.deleteCharAt(sb.length() - 1);
                visited[lastChar] = false;
                lastChar = sb.charAt(sb.length() - 1);
            }
            sb.append(c);
            visited[c] = true;
        }

        return sb.substring(1);
    }
}
