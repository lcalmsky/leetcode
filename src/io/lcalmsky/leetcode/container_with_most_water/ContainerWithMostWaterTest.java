package io.lcalmsky.leetcode.container_with_most_water;

public class ContainerWithMostWaterTest {

    public static void main(String[] args) {
        ContainerWithMostWaterTest containerWithMostWaterTest = new ContainerWithMostWaterTest();
        System.out.println(containerWithMostWaterTest.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(containerWithMostWaterTest.maxArea(new int[]{1, 2, 1, 1, 1, 2, 1, 1, 1}));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
//    public int maxArea(int[] height) {
//        int len = height.length;
//
//        int max = 0;
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
//            }
//        }
//
//        return max;
//    }
}
