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
public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        Complex complex1 = new Complex(num1);
        Complex complex2 = new Complex(num2);
        return complex1.multiply(complex2).toString();
    }

    private static class Complex {
        int real;
        int imaginary;

        public Complex() {

        }

        public Complex(String number) {
            String[] split = number.split("\\+");
            this.real = Integer.parseInt(split[0]);
            this.imaginary = Integer.parseInt(split[1].substring(0, split[1].indexOf('i')));
        }

        public Complex multiply(Complex that) {
            Complex complex = new Complex();
            complex.real = this.real * that.real - this.imaginary * that.imaginary;
            complex.imaginary = this.real * that.imaginary + this.imaginary * that.real;
            return complex;
        }

        @Override
        public String toString() {
            return String.format("%d+%di", real, imaginary);
        }
    }
}
