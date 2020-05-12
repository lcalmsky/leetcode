package io.lcalmsky.leetcode.convert_a_number_to_hexadecimal;

/**
 * <pre>
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 *
 * Input:
 * 26
 *
 * Output:
 * "1a"
 * Example 2:
 *
 * Input:
 * -1
 *
 * Output:
 * "ffffffff"
 * </pre>
 */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        int hex = 15;
        int digit = 10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 8; i++) {
            int d = num & hex;
            if (d >= digit)
                stringBuilder.insert(0, (char) ('a' + (d - digit)));
            else {
                stringBuilder.insert(0, (char) ('0' + d));
            }
            num >>= 4;
        }
        int i = 0;
        int len = stringBuilder.length() - 1;
        while (i < len) {
            if (stringBuilder.charAt(0) == '0')
                stringBuilder.deleteCharAt(0);
            else
                break;
            i++;
        }
        return stringBuilder.toString();
    }
}
