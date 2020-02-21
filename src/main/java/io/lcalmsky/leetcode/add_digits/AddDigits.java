package io.lcalmsky.leetcode.add_digits;

public class AddDigits {
    public int addDigits(int num) {
        while (num / 10 != 0) {
            String s = String.valueOf(num);
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            num = sum;
        }
        return num;
    }
}
