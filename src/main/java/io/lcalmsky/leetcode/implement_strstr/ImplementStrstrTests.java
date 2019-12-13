package io.lcalmsky.leetcode.implement_strstr;

public class ImplementStrstrTests {
    public static void main(String[] args) {
        ImplementStrstrTests implementStrstrTests = new ImplementStrstrTests()  ;
        System.out.println(implementStrstrTests.strStr("hello", "ll"));
        System.out.println(implementStrstrTests.strStr("aaaaa", "bba"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
