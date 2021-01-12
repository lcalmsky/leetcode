package io.lcalmsky.leetcode.next_greater_element_ii;

/**
 * <pre>
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * </pre>
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        while (i < nums.length) {
            int j = (i + 1) % nums.length;
            while (j != i) {
                if (nums[i] < nums[j]) {
                    result[i] = nums[j];
                    break;
                }
                j = (j + 1) % nums.length;
            }
            if (j == i) {
                result[i] = -1;
            }
            i++;
        }
        return result;
    }
}
