package io.lcalmsky.leetcode.rotate_string;

public class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
