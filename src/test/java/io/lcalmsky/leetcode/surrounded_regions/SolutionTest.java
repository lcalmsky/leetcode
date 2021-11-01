package io.lcalmsky.leetcode.surrounded_regions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("주어진 행렬의 X로 둘러쌓인 O를 모두 X로 바꿔라")
    void testAll() {
        assertAll(
            () -> test(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
            }, new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}})
        );
    }

    private void test(char[][] given, char[][] expected) {
        // when
        Solution solution = new Solution();
        solution.solve(given);
        // then
        assertArrayEquals(expected, given);
    }
}