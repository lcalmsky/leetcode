package io.lcalmsky.leetcode.complex_number_multiplication;

/**
 * A complex number can be represented as a string on the form "real+imaginaryi" where:
 * <p>
 * real is the real part and is an integer in the range [-100, 100].
 * imaginary is the imaginary part and is an integer in the range [-100, 100].
 * i2 == -1.
 * Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "1+1i", num2 = "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * <p>
 * Input: num1 = "1+-1i", num2 = "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * num1 and num2 are valid complex numbers.
 */
public class Solution2 {
    public String complexNumberMultiply(String num1, String num2) {
        int plusIndex = num1.indexOf("+");
        int real1 = getRealPart(num1, plusIndex);
        int imaginary1 = getImaginaryPart(num1, plusIndex);
        plusIndex = num2.indexOf("+");
        int real2 = getRealPart(num2, plusIndex);
        int imaginary2 = getImaginaryPart(num2, plusIndex);
        return String.format("%d+%di", real1 * real2 - imaginary1 * imaginary2, real1 * imaginary2 + real2 * imaginary1);
    }

    private static int getImaginaryPart(String num1, int plusIndex) {
        return Integer.parseInt(num1.substring(plusIndex + 1, num1.indexOf('i')));
    }

    private static int getRealPart(String num1, int plusIndex) {
        return Integer.parseInt(num1.substring(0, plusIndex));
    }
}
