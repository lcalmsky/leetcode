package io.lcalmsky.leetcode.trapping_rain_water;

public class TrappingRainWaterTests {
    public static void main(String[] args) {
        final TrappingRainWaterTests trappingRainWaterTests = new TrappingRainWaterTests();
        System.out.println(trappingRainWaterTests.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = height[0];
        left[0] = max;

        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) max = height[i];
            left[i] = max;
        }

        max = height[height.length - 1];
        right[height.length - 1] = max;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] >= max) max = height[i];
            right[i] = max;
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}
