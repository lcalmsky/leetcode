> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/complex_number_multiplication/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3917/) 있습니다.


## Problem
A complex number can be represented as a string on the form "real+imaginaryi" where:

* real is the real part and is an integer in the range [-100, 100].
* imaginary is the imaginary part and is an integer in the range [-100, 100].
* i^2 == -1.

Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

**Example 1:**

```text
Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
```

**Example 2:**

```text
Input: num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
```

**Constraints:**

* num1 and num2 are valid complex numbers.

## Solution

복소수(Complex)의 곱 연산을 구현하는 문제로 정답률이 70%가 넘는 쉬운 문제입니다.

여러 단순한 방법들이 존재하겠지만 먼저 커스텀 클래스를 작성해 풀어보았습니다.

```java
public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        Complex complex1 = new Complex(num1);
        Complex complex2 = new Complex(num2);
        return complex1.multiply(complex2).toString();
    }

    private static class Complex { // (1)
        int real;
        int imaginary;

        public Complex() {

        }

        public Complex(String number) { // (2)
            String[] split = number.split("\\+");
            this.real = Integer.parseInt(split[0]);
            this.imaginary = Integer.parseInt(split[1].substring(0, split[1].indexOf('i')));
        }

        public Complex multiply(Complex that) { // (3)
            Complex complex = new Complex();
            complex.real = this.real * that.real - this.imaginary * that.imaginary;
            complex.imaginary = this.real * that.imaginary + this.imaginary * that.real;
            return complex;
        }

        @Override
        public String toString() { // (4)
            return String.format("%d+%di", real, imaginary);
        }
    }
}
```

> (1) 복소수를 정의한 클래스로 실수부와 허수부 필드를 가집니다. 내부에서만 사용할 클래스라 `private static`으로 정의하였고, 필드도 바로 접근할 수 있게 하였습니다.  
> (2) 생성자에 복소수 문자열을 입력하면 파싱하여 실수, 허수부 필드를 초기화 하였습니다.  
> (3) 복소수의 곱을 구현하였습니다.  
> (4) 문제에서 요구하는 형식으로 답을 작성할 수 있게 `toString`을 재정의하였습니다.

## Test

```java
package io.lcalmsky.leetcode.complex_number_multiplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenComplexes_whenMultiply_thenCorrect() {
        assertAll(
                () -> test("1+1i", "1+1i", "0+2i"),
                () -> test("1+-1i", "1+-1i", "0+-2i")
        );
    }

    private void test(String num1, String num2, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.complexNumberMultiply(num1, num2);

        // then
        assertEquals(expected, actual);
    }
}
```