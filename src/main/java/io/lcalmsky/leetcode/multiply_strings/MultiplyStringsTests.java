package io.lcalmsky.leetcode.multiply_strings;

public class MultiplyStringsTests {
    public static void main(String[] args) {
        MultiplyStringsTests multiplyStringsTests = new MultiplyStringsTests();
        System.out.println(multiplyStringsTests.multiply("2", "3"));
        System.out.println(multiplyStringsTests.multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        short[] d = new short[num1.length() + num2.length()];

        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        for (int i = n1.length() - 1; i >= 0; i--) {
            for (int j = n2.length() - 1; j >= 0; j--) {
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        int mod, carry;
        for (int i = 0; i < d.length; i++) {
            mod = d[i] % 10;
            carry = d[i] / 10;
            if (i + 1 < d.length) d[i + 1] += carry;
            sb.insert(0, mod);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
